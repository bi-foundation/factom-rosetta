package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountCoinsRequest is utilized to make a request on the /account/coins endpoint.
 */
@Schema(description = "AccountCoinsRequest is utilized to make a request on the /account/coins endpoint.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class AccountCoinsRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;

  @JsonProperty("include_mempool")
  private Boolean includeMempool = null;

  @JsonProperty("currencies")
  @Valid
  private List<Currency> currencies = null;

  public AccountCoinsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  /**
   * Get networkIdentifier
   * @return networkIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }

  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  public AccountCoinsRequest accountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

  /**
   * Get accountIdentifier
   * @return accountIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountIdentifier getAccountIdentifier() {
    return accountIdentifier;
  }

  public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  public AccountCoinsRequest includeMempool(Boolean includeMempool) {
    this.includeMempool = includeMempool;
    return this;
  }

  /**
   * Include state from the mempool when looking up an account's unspent coins. Note, using this functionality breaks any guarantee of idempotency.
   * @return includeMempool
   **/
  @Schema(required = true, description = "Include state from the mempool when looking up an account's unspent coins. Note, using this functionality breaks any guarantee of idempotency.")
      @NotNull

    public Boolean isIncludeMempool() {
    return includeMempool;
  }

  public void setIncludeMempool(Boolean includeMempool) {
    this.includeMempool = includeMempool;
  }

  public AccountCoinsRequest currencies(List<Currency> currencies) {
    this.currencies = currencies;
    return this;
  }

  public AccountCoinsRequest addCurrenciesItem(Currency currenciesItem) {
    if (this.currencies == null) {
      this.currencies = new ArrayList<Currency>();
    }
    this.currencies.add(currenciesItem);
    return this;
  }

  /**
   * In some cases, the caller may not want to retrieve coins for all currencies for an AccountIdentifier. If the currencies field is populated, only coins for the specified currencies will be returned. If not populated, all unspent coins will be returned.
   * @return currencies
   **/
  @Schema(description = "In some cases, the caller may not want to retrieve coins for all currencies for an AccountIdentifier. If the currencies field is populated, only coins for the specified currencies will be returned. If not populated, all unspent coins will be returned.")
      @Valid
    public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountCoinsRequest accountCoinsRequest = (AccountCoinsRequest) o;
    return Objects.equals(this.networkIdentifier, accountCoinsRequest.networkIdentifier) &&
        Objects.equals(this.accountIdentifier, accountCoinsRequest.accountIdentifier) &&
        Objects.equals(this.includeMempool, accountCoinsRequest.includeMempool) &&
        Objects.equals(this.currencies, accountCoinsRequest.currencies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, accountIdentifier, includeMempool, currencies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountCoinsRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    includeMempool: ").append(toIndentedString(includeMempool)).append("\n");
    sb.append("    currencies: ").append(toIndentedString(currencies)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
