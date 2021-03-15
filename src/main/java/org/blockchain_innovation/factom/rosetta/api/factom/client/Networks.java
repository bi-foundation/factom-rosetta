package org.blockchain_innovation.factom.rosetta.api.factom.client;

import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.FACTOM_BLOCKCHAIN;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.MAINNET;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.WalletdClient;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.client.spring.SpringNetworks;
import org.blockchain_innovation.factom.rosetta.MDCKeys;
import org.blockchain_innovation.factom.rosetta.MetadataConstants;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Version;
import org.slf4j.MDC;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Networks extends SpringNetworks {


    @Autowired
    public Networks(Environment environment, ObjectProvider<FactomdClient> factomdProvider,
      ObjectProvider<WalletdClient> offlineWalletdProvider, ObjectProvider<WalletdClient> onlineWalletdProvider) {
        super(environment, factomdProvider, offlineWalletdProvider, onlineWalletdProvider);
    }

    public List<NetworkIdentifier> getIdentifiers() {
        return getNetworkNames().stream().map(name -> getIdentifier(name)).collect(Collectors.toList());
    }

    public NetworkIdentifier getIdentifier(String network) {
        return new NetworkIdentifier().blockchain(FACTOM_BLOCKCHAIN).network(network);
    }

    public FactomdClient factomd(NetworkIdentifier networkIdentifier) {
        return factomd(Optional.of(networkIdentifier.getNetwork()));
    }

    public WalletdClient walletd(NetworkIdentifier networkIdentifier) {
        return walletd(Optional.of(networkIdentifier.getNetwork()));
    }


    @Cacheable("versions")
    public Version getVersion(NetworkIdentifier networkIdentifier) {
        MDC.put(MDCKeys.NETWORK_ID, networkIdentifier.getNetwork());
        assertFactomNetwork(networkIdentifier);
        try {
            String nodeVersion = factomd(Optional.of(networkIdentifier.getNetwork())).properties().get(10, TimeUnit.SECONDS).getResult().getFactomdVersion();
            // TODO: 11/03/2021 infer from libs/deps using gradle processResource
            Version version = new Version().rosettaVersion(MetadataConstants.ROSETTA_VERSION)
              .middlewareVersion(MetadataConstants.FACTOM_CLIENT_VERSION).nodeVersion(nodeVersion);
            log.info("Version-info for network {}: {}", networkIdentifier.getNetwork(), version);
            return version;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new FactomException.ClientException(e);
        }

    }

    public void assertFactomNetwork(NetworkIdentifier networkIdentifier) {
        assertFactomNetwork(Optional.ofNullable(networkIdentifier));
    }

    public void assertFactomNetwork(Optional<NetworkIdentifier> networkIdentifier) {
        networkIdentifier
          .filter(id -> id.getBlockchain() != null)
          .filter(id -> FACTOM_BLOCKCHAIN.equalsIgnoreCase(id.getBlockchain()))
          .orElseThrow(() -> new RosettaExceptions.AssertionException(
            "Invalid blockchain value supplied in network identifier. We only know how to handle the factom blockchain"));
    }


    public String toNetwork(NetworkIdentifier networkIdentifier) {
        assertFactomNetwork(networkIdentifier);
        return networkIdentifier.getNetwork();
    }

    public NetworkIdentifier toNetworkIdentifier(Optional<String> networkName) {
        return new NetworkIdentifier().blockchain(FACTOM_BLOCKCHAIN).network(networkName.orElse(MAINNET));
    }

}
