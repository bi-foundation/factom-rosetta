package org.blockchain_innovation.factom.rosetta.api;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import org.blockchain_innovation.factom.rosetta.api.factom.client.FactomRosettaTranslations;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions;
import org.blockchain_innovation.factom.rosetta.model.MempoolResponse;
import org.blockchain_innovation.factom.rosetta.model.MempoolTransactionResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Transaction;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MempoolDelegate {

    private final Networks networks;
    private final FactomRosettaTranslations translate;

    @Autowired
    public MempoolDelegate(Networks networks, FactomRosettaTranslations translate) {
        this.networks = networks;
        this.translate = translate;
    }

    public MempoolResponse mempool(NetworkIdentifier networkIdentifier) {
        final var factomd = networks.factomd(networkIdentifier);

        // The 0-height is okay. The factom java client needs an update because the height will never be used at all
        // (also wouldn't make sense for pending transactions in the network)

        final var mempoolFuture = factomd.entryCreditRate().thenComposeAsync(entryCreditRate ->
          factomd.pendingTransactions(0).thenApply(
            pendingEntriesResponse -> {
                final var transactions = translate
                  .transactionsFromPendingTransactions(pendingEntriesResponse.getResult(), entryCreditRate.getResult().getRate());
                final var transactionIdentifiers = transactions.stream()
                  .map(transaction -> transaction.getTransactionIdentifier()).collect(Collectors.toList());
                return new MempoolResponse().transactionIdentifiers(transactionIdentifiers);
            }
          )
        );

        try {
            return mempoolFuture.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RosettaExceptions.RuntimeException(e);
        }
    }


    public MempoolTransactionResponse mempoolTransaction(NetworkIdentifier networkIdentifier, TransactionIdentifier transactionIdentifier) {
        final var factomd = networks.factomd(networkIdentifier);
        final var mempoolFuture = factomd.entryCreditRate().thenComposeAsync(entryCreditRate ->
          factomd.pendingTransactions(0).thenApply(
            pendingEntriesResponse -> {
                List<Transaction> transactions = translate
                  .transactionsFromPendingTransactions(pendingEntriesResponse.getResult(), entryCreditRate.getResult().getRate());
                Transaction transaction = transactions.stream()
                  .filter(filterTransaction -> filterTransaction.getTransactionIdentifier().equals(transactionIdentifier)).findFirst().orElseThrow(
                    () -> new RosettaExceptions.NotFoundException(
                      "Could not find transaction Identifier in mempool (already anchored?): " + transactionIdentifier.getHash()));
                return new MempoolTransactionResponse().transaction(transaction);
            }
          )
        );

        try {
            return mempoolFuture.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RosettaExceptions.RuntimeException(e);
        }
    }
}
