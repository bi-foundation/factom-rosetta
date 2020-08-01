package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.model.Address;
import org.blockchain_innovation.factom.client.api.model.response.factomd.FactoidBalanceResponse;
import org.blockchain_innovation.factom.rosetta.api.factom.client.FactomRosettaTranslations;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceResponse;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class AccountDelegate {

    private final Networks networks;
    private final FactomRosettaTranslations translate;

    @Autowired
    public AccountDelegate(Networks networks, FactomRosettaTranslations translate) {
        this.networks = networks;
        this.translate = translate;
    }

    AccountBalanceResponse accountBalance(AccountBalanceRequest accountBalanceRequest) {
        FactomdClient factomd = networks.factomd(accountBalanceRequest.getNetworkIdentifier());
        try {
            if (accountBalanceRequest.getBlockIdentifier() == null) {
                Address address = translate.address(accountBalanceRequest.getAccountIdentifier());
                FactoidBalanceResponse factoidBalance = factomd.factoidBalance(address).get().getResult();
                Amount amount = translate.amountFromBalance(factoidBalance.getBalance(), Optional.of(address.getType()));

                return new AccountBalanceResponse().addBalancesItem(amount);
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RosettaExceptions.RuntimeException(e);
        }

        throw new RosettaExceptions.NotImplementedException("Only current factoid balances supported for now");
    }


}
