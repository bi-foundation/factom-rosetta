package org.blockchain_innovation.factom.rosetta.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.blockchain_innovation.factom.client.api.FactomdClient;
import org.blockchain_innovation.factom.client.api.model.Address;
import org.blockchain_innovation.factom.client.api.model.types.AddressType;
import org.blockchain_innovation.factom.rosetta.RosettaConfig;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Addresses;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Constants;
import org.blockchain_innovation.factom.rosetta.api.factom.client.FactomRosettaTranslations;
import org.blockchain_innovation.factom.rosetta.api.factom.client.Networks;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions.AssertionException;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceResponse;
import org.blockchain_innovation.factom.rosetta.model.AccountCoinsRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountCoinsResponse;
import org.blockchain_innovation.factom.rosetta.model.Block;
import org.blockchain_innovation.factom.rosetta.model.Coin;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class AccountDelegate {

    private final RosettaConfig config;
    private final Networks networks;
    private final FactomRosettaTranslations translate;
    private final Addresses addresses;

    @Autowired
    public AccountDelegate(RosettaConfig config, Networks networks, FactomRosettaTranslations translate, Addresses addresses) {
        this.config = config;
        this.networks = networks;
        this.translate = translate;
        this.addresses = addresses;
    }

    AccountBalanceResponse accountBalance(AccountBalanceRequest accountBalanceRequest) {
        FactomdClient factomd = networks.factomd(accountBalanceRequest.getNetworkIdentifier());
        final var address = addresses.toAddress(accountBalanceRequest.getAccountIdentifier());
        if (accountBalanceRequest.getBlockIdentifier() == null) {
            final var balanceFuture = balanceFuture(factomd, address)
              .thenApplyAsync(balance -> translate.amount(balance, Optional.of(address.getType())))
              .thenApplyAsync(amount -> new AccountBalanceResponse().addBalancesItem(amount))
              .thenComposeAsync(balanceResponse ->
                currentBlockFuture(factomd).thenApplyAsync(block -> balanceResponse.blockIdentifier(block.getBlockIdentifier())));

            try {
                return balanceFuture.get(30, TimeUnit.SECONDS);
            } catch (ExecutionException | InterruptedException | TimeoutException e) {
                throw new RosettaExceptions.RuntimeException(e);
            }
        }

        // This would need walletd support or manual scanning of all factoid blocks and transactions
        throw new RosettaExceptions.NotImplementedException("Only current factoid balances supported for now");
    }


    public AccountCoinsResponse accountCoins(final AccountCoinsRequest accountCoinsRequest) {
        FactomdClient factomd = networks.factomd(accountCoinsRequest.getNetworkIdentifier());
        final var address = addresses.toAddress(accountCoinsRequest.getAccountIdentifier());
        final var accountCurrency = translate.currency(Optional.of(address.getType()));

        final var currencies = CollectionUtils.isEmpty(accountCoinsRequest.getCurrencies())
          ? Set.of(address.getType() == AddressType.ENTRY_CREDIT_PUBLIC || address.getType() == AddressType.ENTRY_CREDIT_SECRET
          ? Constants.CURRENCY_EC : Constants.CURRENCY_FCT)
          : accountCoinsRequest.getCurrencies();

        final var accountsCoinsFuture = currentBlockFuture(factomd)
          .thenApplyAsync(Block::getBlockIdentifier)
          .thenApplyAsync(blockIdentifier -> new AccountCoinsResponse().blockIdentifier(blockIdentifier))
          .thenComposeAsync(accountCoinsResponse -> {
              List<CompletableFuture<Coin>> coinFutures = new ArrayList<>();
              for (Currency requestedCurrency : currencies) {
                  if (!requestedCurrency.getSymbol().equals(accountCurrency.getSymbol())) {
                      return CompletableFuture.failedFuture(new AssertionException(
                        String
                          .format("Currency requested '%s' for address type '%s' not supported", requestedCurrency.getSymbol(),
                            address.getType())));
                  }
                  coinFutures.add(balanceFuture(factomd, address)
                    .thenApply(balance -> new Coin().amount(translate.amount(balance, Optional.of(address.getType())))));
              }
              return combineAndMap(coinFutures).thenApply(coins -> accountCoinsResponse.coins(coins));
          });

        try {
            return accountsCoinsFuture.get(30, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RosettaExceptions.RuntimeException(e);
        }
    }

    private <T> CompletableFuture<List<T>> combineAndMap(List<CompletableFuture<T>> futures) {
        CompletableFuture<Void> allDoneFuture =
          CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        return allDoneFuture.thenApply(v ->
          futures.stream().
            map(future -> future.join()).
            collect(Collectors.<T>toList())
        );
    }

    private CompletableFuture<Long> balanceFuture(final FactomdClient factomd, final Address address) {
        if (config.getFct().isEnabled() && addresses.isFactoidAddress(address.getType())) {
            return factomd.factoidBalance(address).thenApply(factoidBalance -> factoidBalance.getResult().getBalance());
        } else if (config.getEc().isEnabled() && addresses.isEntryCreditAddress(address.getType())) {
            return factomd.entryCreditBalance(address).thenApply(entryCreditBalance -> entryCreditBalance.getResult().getBalance());
        }
        return CompletableFuture
          .failedFuture(new AssertionException(String.format("Address type '%s' not enabled or not yet supported for a balance", address.getType())));
    }

    private CompletableFuture<Block> currentBlockFuture(final FactomdClient factomd) {
        // TODO: 15/03/2021 Probably wise to keep track of latest height and block, so we are not getting the same block over and over
        return factomd.heights()
          .thenComposeAsync(
            // directoryblockheight : The current directory block height of the local factomd node.
            heightsResponse -> factomd.directoryBlockByHeight(heightsResponse.getResult().getDirectoryBlockHeight()))
          .thenApply(
            directoryBlockHeightResponse -> translate
              .blockFromDirectoryBlock(directoryBlockHeightResponse.getResult(), Optional.empty(), Optional.empty()));
    }
}
