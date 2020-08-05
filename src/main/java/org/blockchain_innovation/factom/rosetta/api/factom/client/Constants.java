package org.blockchain_innovation.factom.rosetta.api.factom.client;

import org.blockchain_innovation.factom.rosetta.model.Currency;

public interface Constants {

    String FACTOM_BLOCKCHAIN = "factom";
    String MAINNET = "mainnet";
    String TESTNET = "testnet";

    Currency CURRENCY_FCT = new Currency().symbol("FCT").decimals(8);
    Currency CURRENCY_EC = new Currency().symbol("EC").decimals(8);

    String DBENTRIES = "dbentries";
    String CHAINID = "chainid";
    String DBHASH = "dbhash";
    String VERSION = "version";


    String ADMIN_CHAIND = "000000000000000000000000000000000000000000000000000000000000000a";
    String FACTOID_CHAINID = "000000000000000000000000000000000000000000000000000000000000000f";
    String ENTRY_CREDIT_CHAINID = "000000000000000000000000000000000000000000000000000000000000000c";
}
