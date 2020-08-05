package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.client.api.FactomResponse;
import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.errors.FactomException;
import org.blockchain_innovation.factom.client.api.model.response.factomd.DirectoryBlockHeightResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.DirectoryBlockResponse;
import org.blockchain_innovation.factom.client.api.model.response.factomd.FactoidBlockResponse;
import org.blockchain_innovation.factom.client.api.ops.StringUtils;
import org.blockchain_innovation.factom.rosetta.api.factom.client.FactomRosettaTranslations;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.model.Block;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.BlockRequest;
import org.blockchain_innovation.factom.rosetta.model.BlockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.zip.CheckedInputStream;

import static org.blockchain_innovation.factom.rosetta.api.factom.client.Constants.FACTOID_CHAINID;

@Service
public class BlockDelegate {

    private final Networks networks;
    private final FactomRosettaTranslations translate;

    @Autowired
    public BlockDelegate(Networks networks, FactomRosettaTranslations translate) {
        this.networks = networks;
        this.translate = translate;
    }

    public BlockResponse block(BlockRequest blockRequest) {
        FactomdClient client = networks.factomd(blockRequest.getNetworkIdentifier());
        Long index = blockRequest.getBlockIdentifier().getIndex();
        String hash = blockRequest.getBlockIdentifier().getHash();


        CompletableFuture<Block> blockFuture;
//        if (index != null) {
        blockFuture = client.directoryBlockByHeight(index).thenCompose(directoryBlockResponse -> {
            List<DirectoryBlockHeightResponse.DirectoryBlock.Entry> entries = directoryBlockResponse.getResult().getDirectoryBlock().getDirectoryBlockEntries();
            Optional<String> factoidKeyMr = entries.stream().filter(entry -> FACTOID_CHAINID.equals(entry.getChainId())).findFirst().map(DirectoryBlockHeightResponse.DirectoryBlock.Entry::getKeyMR);
            Optional<FactoidBlockResponse> factoidBlock = Optional.empty();

            if (factoidKeyMr.isPresent()) {
                try {
                    factoidBlock = Optional.of(client.factoidBlock(factoidKeyMr.get()).get().getResult());
                } catch (InterruptedException | ExecutionException e) {
                    throw new FactomException.ClientException(e);
                }
            }
            Block block = translate.blockFromDirectoryBlock(directoryBlockResponse.getResult(), factoidBlock);

            return CompletableFuture.completedFuture(block);
        });
//        }// TODO: 04/08/2020 hash


        try {
            Block block = blockFuture.get();
            return new BlockResponse().block(block);

        } catch (InterruptedException | ExecutionException e) {
            throw new FactomException.ClientException(e);
        }
    }


}
