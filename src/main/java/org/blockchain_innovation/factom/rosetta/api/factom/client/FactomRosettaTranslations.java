package org.blockchain_innovation.factom.rosetta.api.factom.client;

import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.CURRENCY_EC;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.CURRENCY_FCT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.blockchain_innovation.factom.client.api.AddressKeyConversions;
import org.blockchain_innovation.factom.client.api.model.response.factomd.DirectoryBlockHeightResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.EntryCreditBlockResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.FactoidBlockResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.PendingTransactionsResponse;
import org.blockchain_innovation.factom.client.api.model.types.AddressType;
import org.blockchain_innovation.factom.client.api.ops.Encoding;
import org.blockchain_innovation.factom.rosetta.RosettaConfig;
import org.blockchain_innovation.factom.rosetta.api.OperationConstants;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.blockchain_innovation.factom.rosetta.model.Block;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.CoinAction;
import org.blockchain_innovation.factom.rosetta.model.CoinChange;
import org.blockchain_innovation.factom.rosetta.model.CoinIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import org.blockchain_innovation.factom.rosetta.model.OperationIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Transaction;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class FactomRosettaTranslations {


    private final RosettaConfig rosettaConfig;
    private final Addresses addresses;

    private final static AddressKeyConversions KEY_CONVERSIONS = new AddressKeyConversions();

    public FactomRosettaTranslations(RosettaConfig rosettaConfig, Addresses addresses) {
        this.rosettaConfig = rosettaConfig;
        this.addresses = addresses;
    }



    public Currency currency(Optional<AddressType> addressType) {
        if (addresses.isFactoidAddress(addressType)) {
            return CURRENCY_FCT;
        } else if (addresses.isEntryCreditAddress(addressType)) {
            return CURRENCY_EC;
        }
        throw new RosettaExceptions.NotImplementedException("Cannot determine currency for address type: " + addressType.get());
    }

    public Amount amount(long balance, Optional<AddressType> addressType) {
        addresses.assertFactoidOrEntryCreditAddress(addressType);
        return new Amount().currency(currency(addressType)).value("" + balance);
    }

    public CoinIdentifier coinIdentifier(String transactionId, long index) {
        return new CoinIdentifier().identifier(String.format("%s:%d", transactionId, index));
    }

/*
    private Map<String, String> chainIdsWithKeyMrs(DirectoryBlockHeightResponse directoryBlockHeight) {
        final var entries = directoryBlockHeight.getDirectoryBlock().getDirectoryBlockEntries();
        return entries.stream().collect(Collectors
          .toMap(DirectoryBlockHeightResponse.DirectoryBlock.Entry::getChainId, DirectoryBlockHeightResponse.DirectoryBlock.Entry::getKeyMR));
    }
*/

    public Block blockFromDirectoryBlock(DirectoryBlockHeightResponse directoryBlockResponse, Optional<FactoidBlockResponse> factoidBlock,
      Optional<EntryCreditBlockResponse> entryCreditBlock) {
        final var block = new Block();
        final var currentBlockId = new BlockIdentifier();
        final var parentBlockIdentifier = new BlockIdentifier();
        block.setBlockIdentifier(currentBlockId);
        block.setParentBlockIdentifier(parentBlockIdentifier);

        final var dbHash = directoryBlockResponse.getDirectoryBlock().getDirectoryBlockHash();
        final var dbKeyMr = directoryBlockResponse.getDirectoryBlock().getKeyMR();
        final var entries = directoryBlockResponse.getDirectoryBlock().getDirectoryBlockEntries();
        final var header = directoryBlockResponse.getDirectoryBlock().getHeader();
        currentBlockId.setHash(dbKeyMr);
        currentBlockId.setIndex(header.getDirectoryBlockHeight());
        if (header.getDirectoryBlockHeight() == 0) {
            /*
             Rosetta expect the first block to return the same values for its parent Block Identifier
             @see https://djr6hkgq2tjcs.cloudfront.net/docs/common_mistakes.html#malformed-genesis-block
            */
            parentBlockIdentifier.setHash(dbKeyMr);
            parentBlockIdentifier.setIndex(0L);
        } else {
            parentBlockIdentifier.setHash(header.getPreviousKeyMR());
            parentBlockIdentifier.setIndex(header.getDirectoryBlockHeight() - 1);
        }
        // header is in minutes, whilst timestamp is in milliseconds
        block.setTimestamp(header.getTimestamp() * 60 * 1000);
        final var metadata = new HashMap<>();
        if (rosettaConfig.getData().getEntries().isEnabled()) {
            metadata.put(Constants.DBENTRIES, entries);
        }
        metadata.put(Constants.CHAINID, header.getChainId());
        metadata.put(Constants.DBHASH, dbHash);
        metadata.put(Constants.VERSION, header.getVersion());
        block.setMetadata(metadata);

        block.transactions(factoidBlock.isPresent() ? transactionsFromFactoidBlock(factoidBlock.get().getFactoidBlock()) : new ArrayList<>());
        if (rosettaConfig.getEc().isEnabled()) {
            entryCreditBlock.ifPresent(entryBlockResponse -> block.getTransactions().addAll(transactionsFromEntryCreditBlock(entryBlockResponse)));
        }
        return block;
    }

    private Operation constructOperation(@NonNull final String address, final long amount, @NonNull final Currency currency,
      final long operationIndex, @NonNull final CoinAction coinAction, final String transactionId) {
        return constructOperation(address, amount, currency, operationIndex, coinAction, transactionId, null);
    }

    private Operation constructOperation(@NonNull final String address, final long amount, @NonNull final Currency currency,
      final long operationIndex, @NonNull final CoinAction coinAction, final String transactionId, List<OperationIdentifier> relatedOperations) {
        final var operation = new Operation();
        operation.setAccount(new AccountIdentifier().address(address));
        operation.setAmount(new Amount().currency(currency).value("" + amount));
        operation.setStatus(OperationConstants.STATUS_OK);
        operation.setType(OperationConstants.TYPE_TRANSFER);
        operation.operationIdentifier(new OperationIdentifier().index(operationIndex));
        if (!CollectionUtils.isEmpty(relatedOperations)) {
            operation.setRelatedOperations(relatedOperations);
        }
        final var coinChange = new CoinChange().coinAction(coinAction).coinIdentifier(coinIdentifier(transactionId, operationIndex));
        operation.coinChange(coinChange);
        return operation;
    }


    private List<Transaction> transactionsFromFactoidBlock(FactoidBlockResponse.FactoidBlock factoidBlock) {
        List<Transaction> rosettaTransactions = new ArrayList<>();
        if (rosettaConfig.getFct().isEnabled() && factoidBlock != null) {
            rosettaTransactions = factoidBlock.getTransactions().stream().map(
              factoidTransaction -> {
                  final var rosettaTransaction = new Transaction();
                  rosettaTransaction.setTransactionIdentifier(new TransactionIdentifier().hash(factoidTransaction.getTxId()));
                  final var metadata = new HashMap<>();
                  metadata.put("chain_id", factoidBlock.getChainId());
                  metadata.put("db_height", factoidBlock.getDirectoryBlockHeight());
                  metadata.put("signature_blocks", factoidTransaction.getSignatureBlocks());
                  rosettaTransaction.setMetadata(metadata);

                  var index = 0L;
                  final List<OperationIdentifier> inputIdentifiers = new ArrayList<>();
                  final var hasInputs = !CollectionUtils.isEmpty(factoidTransaction.getInputs());
                  final var hasECs = !CollectionUtils.isEmpty(factoidTransaction.getOutputEntryCredits());

                  if (hasInputs) {
                      for (FactoidBlockResponse.FactoidBlock.Transaction.Input input : factoidTransaction.getInputs()) {
                          final var operation = constructOperation(input.getUserAddress(), -input.getAmount(), CURRENCY_FCT, index++,
                            CoinAction.SPENT, factoidTransaction.getTxId());
                          rosettaTransaction
                            .addOperationsItem(operation);
                          inputIdentifiers.add(operation.getOperationIdentifier());
                      }
                  }
                  if (!CollectionUtils.isEmpty(factoidTransaction.getOutputs())) {
                      for (FactoidBlockResponse.FactoidBlock.Transaction.Output output : factoidTransaction.getOutputs()) {
                          rosettaTransaction
                            .addOperationsItem(
                              constructOperation(output.getUserAddress(), output.getAmount(), CURRENCY_FCT, index++,
                                hasInputs ? CoinAction.SPENT : CoinAction.CREATED, factoidTransaction.getTxId(), inputIdentifiers));
                      }
                  }
                  if (rosettaConfig.getEc().isEnabled() && hasECs) {
                      final var exchangeRate = factoidBlock.getExchangeRate();
                      for (FactoidBlockResponse.FactoidBlock.Transaction.OutputEntryCredit output : factoidTransaction
                        .getOutputEntryCredits()) {
                          rosettaTransaction
                            .addOperationsItem(
                              constructOperation(output.getUserAddress(), output.getAmount() / exchangeRate, CURRENCY_EC, index++, CoinAction.CREATED,
                                factoidTransaction.getTxId(),
                                inputIdentifiers));
                      }
                  }

                  // TODO: 04/08/2020 signatureBlocks etc

                  return rosettaTransaction;
              }
            ).collect(Collectors.toList());
        }
        return rosettaTransactions;
    }

    private List<Transaction> transactionsFromEntryCreditBlock(EntryCreditBlockResponse entryCreditBlock) {
        List<Transaction> rosettaTransactions = new ArrayList<>();
        if (rosettaConfig.getEc().isEnabled() && entryCreditBlock != null) {
            final AtomicLong lastNumber = new AtomicLong(Long.MIN_VALUE);
            rosettaTransactions = entryCreditBlock.getEntryCreditBlock().getBody().getEntries().stream().sequential().map(
              entry -> {
                  if (entry.getNumber() > 0) {
                      lastNumber.set(entry.getNumber());
                      return null;
                  } else if (!StringUtils.hasText(entry.getEntryHash())) {
                      return null;
                  }
                  final var ecAddress = KEY_CONVERSIONS.keyToAddress(entry.getEntryCreditPublicKey(), AddressType.ENTRY_CREDIT_PUBLIC, Encoding.HEX);
                  final var rosettaTransaction = new Transaction();
                  rosettaTransaction.setTransactionIdentifier(new TransactionIdentifier().hash(entry.getSiganture()));
                  final var metadata = new HashMap<>();
                  metadata.put("number", lastNumber.get());
                  metadata.put("version", entry.getVersion());
                  metadata.put("entry_hash", entry.getEntryHash());
                  metadata.put("entry_credit_public_key", entry.getEntryCreditPublicKey());
                  metadata.put("entry_credit_address", ecAddress);
                  metadata.put("millitime", entry.getMilliTime());
                  metadata.put("sig", entry.getSiganture());
                  rosettaTransaction.setMetadata(metadata);

                  var index = 0L;

                  rosettaTransaction.addOperationsItem(
                    constructOperation(ecAddress, -entry.getCredits(), CURRENCY_EC, index++, CoinAction.SPENT, entry.getSiganture()));

                  return rosettaTransaction;
              }
            ).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return rosettaTransactions;
    }

    public List<Transaction> transactionsFromPendingTransactions(PendingTransactionsResponse pendingTransactions, long ecRate) {
        if (pendingTransactions == null || pendingTransactions.size() == 0) {
            return new ArrayList<>();
        }

        List<Transaction> transactions = pendingTransactions.stream().map(
          pendingTransaction -> {
              final var metadata = new HashMap<>();
              metadata.put("fees", pendingTransaction.getFees());
              metadata.put("status", pendingTransaction.getStatus());
              final var rosettaTransaction = new Transaction();
              rosettaTransaction.setTransactionIdentifier(new TransactionIdentifier().hash(pendingTransaction.getTransactionId()));

              var index = 0L;
              final List<OperationIdentifier> inputIdentifiers = new ArrayList<>();
              final var hasInputs = !CollectionUtils.isEmpty(pendingTransaction.getInputs());
              final var hasECs = !CollectionUtils.isEmpty(pendingTransaction.getEntryCreditOutputs());

              if (rosettaConfig.getFct().isEnabled() && hasInputs) {
                  for (PendingTransactionsResponse.PendingTransaction.Input input : pendingTransaction.getInputs()) {
                      final var operation = constructOperation(input.getUserAddress(), -input.getAmount(), CURRENCY_FCT, index++, CoinAction.SPENT,
                        pendingTransaction.getTransactionId());
                      inputIdentifiers.add(operation.getOperationIdentifier());
                      rosettaTransaction.addOperationsItem(operation);
                  }
              }
              if (rosettaConfig.getFct().isEnabled() && !CollectionUtils.isEmpty(pendingTransaction.getOutputs())) {
                  for (PendingTransactionsResponse.PendingTransaction.Output output : pendingTransaction.getOutputs()) {
                      rosettaTransaction
                        .addOperationsItem(constructOperation(output.getUserAddress(), output.getAmount(), CURRENCY_FCT, index++,
                          hasInputs ? CoinAction.SPENT : CoinAction.CREATED, pendingTransaction.getTransactionId(), inputIdentifiers));
                  }
              }
              if (rosettaConfig.getEc().isEnabled() && !CollectionUtils.isEmpty(pendingTransaction.getEntryCreditOutputs())) {
                  for (PendingTransactionsResponse.PendingTransaction.EntryCreditOutput output : pendingTransaction.getEntryCreditOutputs()) {
                      rosettaTransaction
                        .addOperationsItem(
                          constructOperation(output.getUserAddress(), output.getAmount() / ecRate, CURRENCY_EC, index++, CoinAction.CREATED,
                            pendingTransaction.getTransactionId(),
                            inputIdentifiers));
                  }
              }

              rosettaTransaction.setMetadata(metadata);
              return rosettaTransaction;
          }).collect(Collectors.toList());
        return transactions;
    }

}
