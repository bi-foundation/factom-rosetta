package org.blockchain_innovation.factom.rosetta;

import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.impl.FactomdClientImpl;

public class RosettaFactomClient {

    FactomdClient client;

    public static FactomdClient getInstance(String networkId) {
        FactomdClientImpl client = new FactomdClientImpl();
        return client;
    }
}
