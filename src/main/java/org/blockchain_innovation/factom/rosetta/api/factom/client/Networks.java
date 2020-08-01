package org.blockchain_innovation.factom.rosetta.api.factom.client;

import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.SigningMode;
import org.blockchain_innovation.factom.client.api.WalletdClient;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.client.api.settings.RpcSettings;
import org.blockchain_innovation.factom.client.impl.FactomdClientImpl;
import org.blockchain_innovation.factom.client.impl.WalletdClientImpl;
import org.blockchain_innovation.factom.client.impl.settings.RpcSettingsImpl;
import org.blockchain_innovation.factom.client.spring.settings.SpringRpcSettings;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Version;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.FACTOM_BLOCKCHAIN;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.MAINNET;

@Component
public class Networks {

    @Value("${factom.network-names}")
    private List<String> networkNames;

    private final Map<String, FactomdClient> factomdClients = new HashMap<>();
    private final Map<String, WalletdClient> walletdClients = new HashMap<>();
    private final Environment environment;
    private final FactomRosettaTranslations translation;
    private final ObjectProvider<FactomdClient> factomdProvider;
    private final ObjectProvider<WalletdClient> walletdProvider;

    @Autowired
    public Networks(Environment environment, FactomRosettaTranslations translation, @Named("factomdClient") ObjectProvider<FactomdClient> factomdProvider, @Named("walletdClient") ObjectProvider<WalletdClient> walletdProvider) {
        this.environment = environment;
        this.translation = translation;
        this.factomdProvider = factomdProvider;
        this.walletdProvider = walletdProvider;
    }

    public FactomdClient factomd(NetworkIdentifier networkIdentifier) {
        return factomd(translation.network(networkIdentifier));
    }


    public FactomdClient factomd(Optional<String> network) {
        String id = network.orElse(MAINNET).toLowerCase();

        if (!factomdClients.containsKey(id)) {
            SpringRpcSettings springRpcSettings = rpcSettings(network);
            FactomdClientImpl factomdClient = (FactomdClientImpl) factomdProvider.getObject(springRpcSettings);
            factomdClient.setSettings(new RpcSettingsImpl(RpcSettings.SubSystem.FACTOMD, springRpcSettings.getFactomdServer()));
            factomdClient.setExecutorService(Executors.newFixedThreadPool(springRpcSettings.getFactomdServer().getThreads()));
            factomdClients.put(id, factomdClient);
        }

        return factomdClients.get(id);
    }

    public WalletdClient walletd(NetworkIdentifier networkIdentifier) {
        return walletd(translation.network(networkIdentifier));
    }

    public WalletdClient walletd(Optional<String> network) {
        return walletd(network, Optional.empty());
    }


    public WalletdClient walletd(NetworkIdentifier networkIdentifier, Optional<SigningMode> explicitSigningMode) {
        return walletd(translation.network(networkIdentifier), explicitSigningMode);
    }

    public WalletdClient walletd(Optional<String> network, Optional<SigningMode> explicitSigningMode) {
        String id = network.orElse(MAINNET).toLowerCase();
        SpringRpcSettings springRpcSettings = rpcSettings(network);

        SigningMode signingMode = explicitSigningMode.orElse(springRpcSettings.getWalletdServer().getSigningMode());
        if (!walletdClients.containsKey(id)) {
            List<WalletdClient> availableClients = walletdProvider.stream().filter(walletdClient -> signingMode == walletdClient.signingMode()).collect(Collectors.toList());
            if (availableClients.size() == 0) {
                throw new RuntimeException("Could not find a walletd client on classpath that satisfies signing mode: " + signingMode.name());
            } else if (availableClients.size() > 1) {
                throw new RuntimeException("More than one walletd client was found that satisfies signing mode: " + signingMode.name());
            }
            WalletdClientImpl walletdClient = (WalletdClientImpl) availableClients.get(0);
            walletdClient.setSettings(new RpcSettingsImpl(RpcSettings.SubSystem.WALLETD, springRpcSettings.getWalletdServer()));
            walletdClient.setExecutorService(Executors.newFixedThreadPool(springRpcSettings.getWalletdServer().getThreads()));
            walletdClients.put(id, walletdClient);
        }
        return walletdClients.get(id);
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(networkNames);
    }

    public List<NetworkIdentifier> getIdentifiers() {
        return getNames().stream().map(name -> new NetworkIdentifier().blockchain(FACTOM_BLOCKCHAIN).network(name)).collect(Collectors.toList());
    }


    @Cacheable("versions")
    public Version getVersion(NetworkIdentifier networkIdentifier) {
        try {
            String nodeVersion = factomd(networkIdentifier).properties().get().getResult().getFactomdVersion();
            Version version = new Version().rosettaVersion("1.4.0").middlewareVersion("0.3.0").nodeVersion(nodeVersion);
            return version;
        } catch (InterruptedException | ExecutionException e) {
            throw new FactomException.ClientException(e);
        }

    }

    public SpringRpcSettings rpcSettings(Optional<String> network) {
        try {
            Binder binder = Binder.get(environment);
            return binder.bind(network.orElse(MAINNET), SpringRpcSettings.class).get();
        } catch (NoSuchElementException nse) {
            throw new RosettaExceptions.AssertionException(String.format("Network '%s' was not correctly configured on this rosetta node!", network.orElse(MAINNET)));
        }
    }


}
