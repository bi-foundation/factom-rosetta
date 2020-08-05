package org.blockchain_innovation.factom.rosetta.api.factom.client;

import org.blockchain_innovation.factom.client.api.model.Address;
import org.blockchain_innovation.factom.client.api.model.response.factomd.DirectoryBlockHeightResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.FactoidBlockResponse;
import org.blockchain_innovation.factom.client.api.model.types.AddressType;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.blockchain_innovation.factom.rosetta.model.Block;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import org.blockchain_innovation.factom.rosetta.model.OperationIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Transaction;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.CURRENCY_EC;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.FACTOM_BLOCKCHAIN;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.MAINNET;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.CURRENCY_FCT;

@Component
public class FactomRosettaTranslations {


    public Address address(AccountIdentifier accountIdentifier) {
        return Address.fromString(accountIdentifier.getAddress());
    }

    public AccountIdentifier address(Address address) {
        return new AccountIdentifier().address(address.getValue());
    }


    public Optional<String> network(NetworkIdentifier networkIdentifier) {
        assertFactomNetwork(networkIdentifier);
        return Optional.ofNullable(networkIdentifier.getNetwork());
    }

    public NetworkIdentifier network(Optional<String> networkName) {
        return new NetworkIdentifier().blockchain(FACTOM_BLOCKCHAIN).network(networkName.orElse(MAINNET));
    }

    public Currency currency(Optional<AddressType> addressType) {
        if (isFactoidAddress(addressType)) {
            return CURRENCY_FCT;
        } else if (isEntryCreditAddress(addressType)) {
            return CURRENCY_EC;
        }
        throw new RosettaExceptions.NotImplementedException("Cannot determine currency for address type: " + addressType.get());
    }

    public Amount amountFromBalance(long balance, Optional<AddressType> addressType) {
        assertFactoidAddress(addressType);
        return new Amount().currency(currency(addressType)).value("" + balance);
    }

    private Map<String, String> chainIdsWithKeyMrs(DirectoryBlockHeightResponse directoryBlockHeight) {
        List<DirectoryBlockHeightResponse.DirectoryBlock.Entry> entries = directoryBlockHeight.getDirectoryBlock().getDirectoryBlockEntries();
        return entries.stream().collect(Collectors.toMap(DirectoryBlockHeightResponse.DirectoryBlock.Entry::getChainId, DirectoryBlockHeightResponse.DirectoryBlock.Entry::getKeyMR));
    }

    public Block blockFromDirectoryBlock(DirectoryBlockHeightResponse directoryBlockResponse, Optional<FactoidBlockResponse> factoidBlock) {
        final Block block = new Block();
        final BlockIdentifier currentBlockId = new BlockIdentifier();
        final BlockIdentifier previousBlockIdentifier = new BlockIdentifier();
        block.setBlockIdentifier(currentBlockId);
        block.setParentBlockIdentifier(previousBlockIdentifier);

        String dbHash = directoryBlockResponse.getDirectoryBlock().getDirectoryBlockHash();
        String keyMr = directoryBlockResponse.getDirectoryBlock().getKeyMR();
        List<DirectoryBlockHeightResponse.DirectoryBlock.Entry> entries = directoryBlockResponse.getDirectoryBlock().getDirectoryBlockEntries();
        DirectoryBlockHeightResponse.DirectoryBlock.Header header = directoryBlockResponse.getDirectoryBlock().getHeader();
        currentBlockId.setHash(keyMr);
        currentBlockId.setIndex(header.getDirectoryBlockHeight());
        previousBlockIdentifier.setHash(header.getPreviousKeyMR());
        previousBlockIdentifier.setIndex(header.getDirectoryBlockHeight() > 0L ? header.getDirectoryBlockHeight() - 1 : 0);
        block.setTimestamp(header.getTimestamp());
        Map<String, Object> metadata = new HashMap<>();
        metadata.put(Constants.DBENTRIES, entries);
        metadata.put(Constants.CHAINID, header.getChainId());
        metadata.put(Constants.DBHASH, dbHash);
        metadata.put(Constants.VERSION, header.getVersion());
        block.setMetadata(metadata);
        // FIXME: 04/08/2020 The nullable, get call is buggy
        block.setTransactions(transactionsFromFactoidBlock(Optional.ofNullable(factoidBlock.get().getFactoidBlock())));
        return block;
    }

    private Operation operation(String address, long amount, Currency currency, Long indexReference) {
        Operation operation = new Operation();
        operation.setAccount(new AccountIdentifier().address(address));
        operation.setAmount(new Amount().currency(currency).value("" + amount));
        operation.setStatus("OK");
        operation.operationIdentifier(new OperationIdentifier().index(indexReference));
        return operation;
    }

    private List<Transaction> transactionsFromFactoidBlock(Optional<FactoidBlockResponse.FactoidBlock> factoidBlock) {
        List<Transaction> rosettaTransactions = new ArrayList<>();
        if (factoidBlock.isPresent()) {
            rosettaTransactions = factoidBlock.get().getTransactions().stream().map(
                    factoidTransaction -> {
                        Transaction rosettaTransaction = new Transaction();
                        rosettaTransaction.setTransactionIdentifier(new TransactionIdentifier().hash(factoidTransaction.getTxId()));
                        Map<String, Object> metadata = new HashMap<>();
                        metadata.put("height", factoidTransaction.getBlockHeight());
                        metadata.put("signature_blocks", factoidTransaction.getSignatureBlocks());
                        rosettaTransaction.setMetadata(metadata);

                        long index = 0;
                        for (FactoidBlockResponse.FactoidBlock.Transaction.Input input : factoidTransaction.getInputs()) {
                            rosettaTransaction.addOperationsItem(operation(input.getUserAddress(), -input.getAmount(), CURRENCY_FCT, index++));
                        }
                        for (FactoidBlockResponse.FactoidBlock.Transaction.Output output : factoidTransaction.getOutputs()) {
                            rosettaTransaction.addOperationsItem(operation(output.getUserAddress(), output.getAmount(), CURRENCY_FCT, index++));
                        }

                        // TODO: 04/08/2020 EC transaction, purchases etc

                        return rosettaTransaction;
                    }
            ).collect(Collectors.toList());
        }
        return rosettaTransactions;
    }

    private void assertFactoidAddress(Optional<AddressType> addressType) {
        if (!isFactoidAddress(addressType)) {
            throw new RosettaExceptions.AssertionException("Factoid address type was expected here, but got: " + addressType.get());
        }
    }

    private boolean isFactoidAddress(Optional<AddressType> addressType) {
        return !addressType.isPresent() || addressType.filter(type -> type == AddressType.FACTOID_PUBLIC || type == AddressType.FACTOID_SECRET).isPresent();
    }

    private boolean isEntryCreditAddress(Optional<AddressType> addressType) {
        return addressType.filter(type -> type == AddressType.ENTRY_CREDIT_PUBLIC || type == AddressType.ENTRY_CREDIT_SECRET).isPresent();
    }

    private void assertFactomNetwork(NetworkIdentifier networkIdentifier) {
        assertFactomNetwork(Optional.ofNullable(networkIdentifier));
    }

    private void assertFactomNetwork(Optional<NetworkIdentifier> networkIdentifier) {
        networkIdentifier
                .filter(id -> id.getBlockchain() != null)
                .filter(id -> FACTOM_BLOCKCHAIN.equals(id.getBlockchain().toLowerCase()))
                .orElseThrow(() -> new RosettaExceptions.AssertionException("Invalid blockchain value supplied in network identifier. We only know how to handle the factom blockchain"));
    }
}
