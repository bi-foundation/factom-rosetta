package org.blockchain_innovation.factom.rosetta.api.factom.client;

import java.util.Optional;
import org.blockchain_innovation.factom.client.api.model.Address;
import org.blockchain_innovation.factom.client.api.model.types.AddressType;
import org.blockchain_innovation.factom.rosetta.RosettaConfig;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions.AssertionException;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.springframework.stereotype.Component;

@Component
public class Addresses {

    private final RosettaConfig config;

    public Addresses(RosettaConfig config) {
        this.config = config;
    }

    public void assertFactoidOrEntryCreditAddress(Optional<AddressType> addressType) {
        if (!isFactoidAddress(addressType) && !isEntryCreditAddress(addressType)) {
            throw new RosettaExceptions.AssertionException("Factoid or EntryCredit address type was expected here, but got: " + addressType.get());
        }
    }

    public void assertFactoidAddress(Optional<AddressType> addressType) {
        if (!isFactoidAddress(addressType)) {
            throw new RosettaExceptions.AssertionException("Factoid address type was expected here, but got: " + addressType.get());
        }
    }

    public void assertEntryCreditAddress(Optional<AddressType> addressType) {
        if (!isEntryCreditAddress(addressType)) {
            throw new RosettaExceptions.AssertionException("Entry Credit address type was expected here, but got: " + addressType.get());
        }
    }


    public boolean isFactoidAddress(AddressType addressType) {
        return isFactoidAddress(Optional.ofNullable(addressType));
    }

    public boolean isFactoidAddress(Optional<AddressType> addressType) {
        return addressType != null && addressType.filter(type -> type == AddressType.FACTOID_PUBLIC || type == AddressType.FACTOID_SECRET)
          .isPresent();
    }

    public boolean isEntryCreditAddress(AddressType addressType) {
        return isEntryCreditAddress(Optional.ofNullable(addressType));
    }

    public boolean isEntryCreditAddress(Optional<AddressType> addressType) {
        return addressType != null && addressType.filter(type -> type == AddressType.ENTRY_CREDIT_PUBLIC || type == AddressType.ENTRY_CREDIT_SECRET)
          .isPresent();
    }

    public Address toAddress(AccountIdentifier accountIdentifier) {
        final var address = Address.fromString(accountIdentifier.getAddress());
        assertEnabled(address.getType());
        return address;
    }

    public AccountIdentifier toAccountIdentifier(Address address) {
        return new AccountIdentifier().address(address.getValue());
    }

    public void assertEnabled(AddressType addressType) {
        if (isFactoidAddress(addressType) && !config.getFct().isEnabled()) {
            throw new AssertionException("FCT support has not been enabled in the Rosetta configuration");
        } else if (isEntryCreditAddress(addressType) && !config.getEc().isEnabled()) {
            throw new AssertionException("EC support has not been enabled in the Rosetta configuration");
        }
    }

}
