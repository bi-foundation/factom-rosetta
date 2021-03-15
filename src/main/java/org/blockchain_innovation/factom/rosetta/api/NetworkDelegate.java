package org.blockchain_innovation.factom.rosetta.api;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.rosetta.MDCKeys;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Blocks;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.model.Allow;
import org.blockchain_innovation.factom.rosetta.model.MetadataRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkListResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkOptionsResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkStatusResponse;
import org.blockchain_innovation.factom.rosetta.model.OperationStatus;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NetworkDelegate {

    private final Networks networks;
    private final Blocks blocks;

    @Autowired
    public NetworkDelegate(Networks networks, Blocks blocks) {
        this.networks = networks;
        this.blocks = blocks;
    }


    public NetworkListResponse networkList(final MetadataRequest metadataRequest) {
        final var response = new NetworkListResponse()
          .networkIdentifiers(networks.getIdentifiers());
        return response;
    }

    public NetworkOptionsResponse networkOptions(final NetworkRequest networkRequest) {
        final var version = networks.getVersion(networkRequest.getNetworkIdentifier());
        final var allow = new Allow()
          .addOperationStatusesItem(new OperationStatus().status(OperationConstants.STATUS_OK).successful(true))
          .addOperationStatusesItem(new OperationStatus().status(OperationConstants.STATUS_ERROR).successful(false))
          .addOperationTypesItem(OperationConstants.TYPE_TRANSFER)
          //// TODO: 01/08/2020 Implement:
          .historicalBalanceLookup(false);

        final var networkOptionsResponse = new NetworkOptionsResponse()
          .version(version)
          .allow(allow);

        MDC.clear();
        return networkOptionsResponse;
    }


    public NetworkStatusResponse networkStatus(NetworkRequest networkRequest) {
        final var networkId = networkRequest.getNetworkIdentifier();
        final var client = networks.factomd(networkId);

        MDC.put(MDCKeys.NETWORK_ID, networkId.getNetwork());
        final var networkStatusFuture = client.currentMinute()
          .thenComposeAsync(currentMinuteResponse -> {
              final var localHeight = currentMinuteResponse.getResult().getDirectoryBlockHeight();
              MDC.put(MDCKeys.LOCAL_HEIGHT, "" + localHeight);
//                        long leaderHeight = currentMinuteResponse.getResult().getLeaderHeight();

              final var statusFuture = client.factoidBlockByHeight((int) localHeight)
                // TODO: 01/08/2020 hmzz, odd ^^^^ result of blockheight is a long, which I would expect. argument to blockbyheight is an int, which I wouldn't expect.

                .thenApplyAsync(factoidBlockResponse -> new NetworkStatusResponse()
                  .genesisBlockIdentifier(blocks.genesisBlockIdentifier(networkId))
                  .currentBlockIdentifier(blocks.getBlockIdentifier(networkId, localHeight))
                  .currentBlockTimestamp(currentMinuteResponse.getResult().getCurrentBlockStartTime() / 1000000)
                );
              return statusFuture;
          });

        try {
            final var networkStatusResponse = networkStatusFuture.get(10, TimeUnit.SECONDS);
            MDC.put(MDCKeys.BLOCK_INDEX, "" + networkStatusResponse.getCurrentBlockIdentifier().getIndex());
            log.info("Network status: current block: {}, ts: {}, sync status {}", networkStatusResponse.getCurrentBlockIdentifier().getIndex(),
              networkStatusResponse.getCurrentBlockTimestamp(), networkStatusResponse.getSyncStatus());
            return networkStatusResponse;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new FactomException.ClientException(e);
        } finally {
            MDC.clear();
        }
    }
}
