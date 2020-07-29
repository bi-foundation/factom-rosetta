package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.rosetta.api.factom.client.ClientRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Optional;

public class AccountDelegate {

    private final Environment environment;
    private final ClientRegistry registry;

    @Autowired
    public AccountDelegate(Environment environment, ClientRegistry registry) {
        this.environment = environment;
        this.registry = registry;
    }


    protected FactomdClient client(Optional<String> network) {
        return registry.client(network);
    }

}
