package org.blockchain_innovation.factom.rosetta.api.factom.client;

import org.blockchain_innovation.factom.client.api.model.Address;
import org.blockchain_innovation.factom.client.api.model.types.AddressType;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
