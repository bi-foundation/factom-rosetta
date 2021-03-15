package org.blockchain_innovation.factom.rosetta.api.factom.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.rosetta.MDCKeys;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.slf4j.MDC;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Blocks {

    private final Networks networks;

    public Blocks(Networks networks) {
        this.networks = networks;
    }

    @Cacheable("genesisblockid")
    public BlockIdentifier genesisBlockIdentifier(NetworkIdentifier networkIdentifier) {
        return getBlockIdentifier(networkIdentifier, 0);
    }

    @Cacheable("blockids")
    public BlockIdentifier getBlockIdentifier(NetworkIdentifier networkIdentifier, long index) {
        MDC.put(MDCKeys.NETWORK_ID, networkIdentifier.getNetwork());
        MDC.put(MDCKeys.BLOCK_INDEX, "" + index);
        final var blockFuture = networks.factomd(networkIdentifier).factoidBlockByHeight((int) index).thenApply(factoidBlock ->
          new BlockIdentifier().index(index).hash(factoidBlock.getResult().getFactoidBlock().getLedgerKeyMR()));
        try {
            final var block = blockFuture.get(10, TimeUnit.SECONDS);
            log.info("Block identifier for block with index {} is {}", index, block.getHash());
            return block;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new FactomException.ClientException(e);
        } finally {
            MDC.clear();
        }
    }


}
