package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.client.api.model.response.factomd.FactoidBlockResponse;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.model.Allow;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.MetadataRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.NetworkListResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkOptionsResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkStatusResponse;
import org.blockchain_innovation.factom.rosetta.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class NetworkDelegate {

    private final Networks networks;

    @Autowired
    public NetworkDelegate(Networks networks) {
        this.networks = networks;
    }

    public NetworkListResponse networkList(MetadataRequest metadataRequest) {
        NetworkListResponse response = new NetworkListResponse();
        response.setNetworkIdentifiers(networks.getIdentifiers());
        return response;
    }

    public NetworkOptionsResponse networkOptions(NetworkRequest networkRequest) {
        Version version = networks.getVersion(networkRequest.getNetworkIdentifier());
        Allow allow = new Allow();

        //// TODO: 01/08/2020 Implement:
        allow.historicalBalanceLookup(false);

        NetworkOptionsResponse networkOptionsResponse = new NetworkOptionsResponse();
        networkOptionsResponse.setVersion(version);
        networkOptionsResponse.setAllow(allow);

        return networkOptionsResponse;
    }

    public BlockIdentifier genesisBlockIdentifier(NetworkIdentifier networkIdentifier) {
        return getBlockIdentifier(networkIdentifier, 0);
    }

    @Cacheable("blockids")
    public BlockIdentifier getBlockIdentifier(NetworkIdentifier networkIdentifier, long index) {
        BlockIdentifier blockIdentifier = new BlockIdentifier();

        try {
            FactoidBlockResponse block = networks.factomd(networkIdentifier).factoidBlockByHeight((int) index).get().getResult();
            blockIdentifier.setHash(block.getFactoidBlock().getLedgerKeyMR());
            blockIdentifier.setIndex(index);
            return blockIdentifier;
        } catch (InterruptedException | ExecutionException e) {
            throw new FactomException.ClientException(e);
        }
    }


    public NetworkStatusResponse networkStatus(NetworkRequest networkRequest) {
        final NetworkIdentifier networkId = networkRequest.getNetworkIdentifier();
        final FactomdClient client = networks.factomd(networkId);

        try {
            return client.currentMinute()
                    .thenComposeAsync(currentMinuteResponse -> {
                        long localHeight = currentMinuteResponse.getResult().getDirectoryBlockHeight();
//                        long leaderHeight = currentMinuteResponse.getResult().getLeaderHeight();

                        CompletableFuture<NetworkStatusResponse> networkStatusFuture = client.factoidBlockByHeight((int) localHeight)
                                // TODO: 01/08/2020 hmzz, odd ^^^^ result of blockheight is a long, which I would expect. argument to blockbyheight is an int, which I wouldn't expect.

                                .thenCompose(factoidBlockResponse -> {
                                            NetworkStatusResponse networkStatusResponse = new NetworkStatusResponse();
                                            networkStatusResponse.setGenesisBlockIdentifier(genesisBlockIdentifier(networkId));
                                            networkStatusResponse.setCurrentBlockIdentifier(getBlockIdentifier(networkId, localHeight));
                                            networkStatusResponse.setCurrentBlockTimestamp(currentMinuteResponse.getResult().getCurrentBlockStartTime());
                                            return CompletableFuture.completedFuture(networkStatusResponse);
                                        }
                                );


                        return networkStatusFuture;
                    })

                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FactomException.ClientException(e);
        }
    }
}
