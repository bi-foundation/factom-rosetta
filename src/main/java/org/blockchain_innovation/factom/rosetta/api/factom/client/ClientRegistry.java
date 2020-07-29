package org.blockchain_innovation.factom.rosetta.api.factom.client;

import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.spring.settings.SpringRpcSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ClientRegistry {

    public static final String MAINNET = "mainnet";
    private Map<String, FactomdClient> clients = new HashMap<>();
    private final Environment environment;

    @Autowired
    public ClientRegistry(Environment environment) {
        this.environment = environment;;
    }


    public FactomdClient client(Optional<String> network) {
        return null;
    }


    public SpringRpcSettings getRpcSettings(Optional<String> network) {
        Binder binder = Binder.get(environment);
        return binder.bind(network.orElse(MAINNET), SpringRpcSettings.class).get();

    }
}
