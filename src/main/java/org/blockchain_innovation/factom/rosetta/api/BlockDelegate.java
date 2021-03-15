package org.blockchain_innovation.factom.rosetta.api;

import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.ENTRY_CREDIT_CHAINID;
import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.FACTOID_CHAINID;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.client.api.model.response.factomd.DirectoryBlockHeightResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.EntryCreditBlockResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.FactoidBlockResponse;
import org.blockchain_innovation.factom.rosetta.MDCKeys;
import org.blockchain_innovation.factom.rosetta.RosettaConfig;
import org.blockchain_innovation.factom.rosetta.api.factom.client.FactomRosettaTranslations;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions.NotImplementedException;
import org.blockchain_innovation.factom.rosetta.model.Block;
import org.blockchain_innovation.factom.rosetta.model.BlockRequest;
import org.blockchain_innovation.factom.rosetta.model.BlockResponse;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlockDelegate {

    private final RosettaConfig config;
    private final Networks networks;
    private final FactomRosettaTranslations translate;

    @Autowired
    public BlockDelegate(RosettaConfig config, Networks networks, FactomRosettaTranslations translate) {
        this.config = config;
        this.networks = networks;
        this.translate = translate;
    }

    public BlockResponse block(BlockRequest blockRequest) {
        final var index = blockRequest.getBlockIdentifier().getIndex();
        final var hash = blockRequest.getBlockIdentifier().getHash();
        MDC.put(MDCKeys.NETWORK_ID, blockRequest.getNetworkIdentifier().getNetwork());

        CompletableFuture<Block> blockFuture;
        if (index != null) {
            MDC.put(MDCKeys.BLOCK_INDEX, "" + index);
            FactomdClient factomd = networks.factomd(blockRequest.getNetworkIdentifier());
            blockFuture = factomd.directoryBlockByHeight(index).thenComposeAsync(directoryBlockResponse -> {
                final var entries = directoryBlockResponse.getResult().getDirectoryBlock().getDirectoryBlockEntries();
                final var factoidKeyMr = entries.stream().filter(entry -> config.getFct().isEnabled() && FACTOID_CHAINID.equals(entry.getChainId()))
                  .findFirst()
                  .map(DirectoryBlockHeightResponse.DirectoryBlock.Entry::getKeyMR);
                final var ecKeyMr = entries.stream().filter(entry -> config.getEc().isEnabled() && ENTRY_CREDIT_CHAINID.equals(entry.getChainId()))
                  .findFirst()
                  .map(DirectoryBlockHeightResponse.DirectoryBlock.Entry::getKeyMR);

                try {
                    Optional<FactoidBlockResponse> factoidBlock =
                      factoidKeyMr.isEmpty() || !config.getFct().isEnabled() ? Optional.empty()
                        : Optional.of(factomd.factoidBlock(factoidKeyMr.get()).get(30, TimeUnit.SECONDS).getResult());
                    Optional<EntryCreditBlockResponse> ecBlock =
                      ecKeyMr.isEmpty() || !config.getEc().isEnabled() ? Optional.empty()
                        : Optional.of(factomd.entryCreditBlock(ecKeyMr.get()).get(30, TimeUnit.SECONDS).getResult());
                    final var block = translate.blockFromDirectoryBlock(directoryBlockResponse.getResult(), factoidBlock, ecBlock);

                    return CompletableFuture.completedFuture(block);
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    throw new FactomException.ClientException(e);
                }

            });
        } else {
            MDC.put(MDCKeys.BLOCK_HASH, hash);
            // TODO: 04/08/2020 hash
            throw new NotImplementedException("hash not implemented");
        }

        try {
            log.info("block retrieval started...");
            final var block = blockFuture.get(30, TimeUnit.SECONDS);
            log.info("block retrieved, containing {} transactions.", block.getTransactions().size());
            return new BlockResponse().block(block);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new FactomException.ClientException(e);
        } finally {
            MDC.clear();
        }
    }


}
