package org.blockchain_innovation.factom.rosetta.api.factom.client;

import org.blockchain_innovation.factom.rosetta.model.Currency;

public interface Constants {

    String FACTOM_BLOCKCHAIN = "factom";
    String MAINNET = "mainnet";
    String TESTNET = "testnet";

    Currency CURRENCY_FCT = new Currency().symbol("FCT").decimals(8);
    Currency CURRENCY_EC = new Currency().symbol("EC").decimals(8);
}
