package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.CoinIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Operator;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SearchTransactionsRequest is used to search for transactions matching a set of provided conditions in canonical blocks.
 */
@Schema(description = "SearchTransactionsRequest is used to search for transactions matching a set of provided conditions in canonical blocks.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class SearchTransactionsRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("operator")
  private Operator operator = null;

  @JsonProperty("max_block")
  private Long maxBlock = null;

  @JsonProperty("offset")
  private Long offset = null;

  @JsonProperty("limit")
  private Long limit = null;

  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;

  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;

  @JsonProperty("coin_identifier")
  private CoinIdentifier coinIdentifier = null;

  @JsonProperty("currency")
  private Currency currency = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("success")
  private Boolean success = null;

  public SearchTransactionsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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

  public SearchTransactionsRequest operator(Operator operator) {
    this.operator = operator;
    return this;
  }

  /**
   * Get operator
   * @return operator
   **/
  @Schema(description = "")
  
    @Valid
    public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public SearchTransactionsRequest maxBlock(Long maxBlock) {
    this.maxBlock = maxBlock;
    return this;
  }

  /**
   * max_block is the largest block index to consider when searching for transactions. If this field is not populated, the current block is considered the max_block. If you do not specify a max_block, it is possible a newly synced block will interfere with paginated transaction queries (as the offset could become invalid with newly added rows).
   * minimum: 0
   * @return maxBlock
   **/
  @Schema(example = "5", description = "max_block is the largest block index to consider when searching for transactions. If this field is not populated, the current block is considered the max_block. If you do not specify a max_block, it is possible a newly synced block will interfere with paginated transaction queries (as the offset could become invalid with newly added rows).")
  
  @Min(0L)  public Long getMaxBlock() {
    return maxBlock;
  }

  public void setMaxBlock(Long maxBlock) {
    this.maxBlock = maxBlock;
  }

  public SearchTransactionsRequest offset(Long offset) {
    this.offset = offset;
    return this;
  }

  /**
   * offset is the offset into the query result to start returning transactions. If any search conditions are changed, the query offset will change and you must restart your search iteration.
   * minimum: 0
   * @return offset
   **/
  @Schema(example = "5", description = "offset is the offset into the query result to start returning transactions. If any search conditions are changed, the query offset will change and you must restart your search iteration.")
  
  @Min(0L)  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public SearchTransactionsRequest limit(Long limit) {
    this.limit = limit;
    return this;
  }

  /**
   * limit is the maximum number of transactions to return in one call. The implementation may return <= limit transactions.
   * minimum: 0
   * @return limit
   **/
  @Schema(example = "5", description = "limit is the maximum number of transactions to return in one call. The implementation may return <= limit transactions.")
  
  @Min(0L)  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public SearchTransactionsRequest transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  /**
   * Get transactionIdentifier
   * @return transactionIdentifier
   **/
  @Schema(description = "")
  
    @Valid
    public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }

  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  public SearchTransactionsRequest accountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

  /**
   * Get accountIdentifier
   * @return accountIdentifier
   **/
  @Schema(description = "")
  
    @Valid
    public AccountIdentifier getAccountIdentifier() {
    return accountIdentifier;
  }

  public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  public SearchTransactionsRequest coinIdentifier(CoinIdentifier coinIdentifier) {
    this.coinIdentifier = coinIdentifier;
    return this;
  }

  /**
   * Get coinIdentifier
   * @return coinIdentifier
   **/
  @Schema(description = "")
  
    @Valid
    public CoinIdentifier getCoinIdentifier() {
    return coinIdentifier;
  }

  public void setCoinIdentifier(CoinIdentifier coinIdentifier) {
    this.coinIdentifier = coinIdentifier;
  }

  public SearchTransactionsRequest currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  @Schema(description = "")
  
    @Valid
    public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public SearchTransactionsRequest status(String status) {
    this.status = status;
    return this;
  }

  /**
   * status is the network-specific operation type.
   * @return status
   **/
  @Schema(example = "reverted", description = "status is the network-specific operation type.")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SearchTransactionsRequest type(String type) {
    this.type = type;
    return this;
  }

  /**
   * type is the network-specific operation type.
   * @return type
   **/
  @Schema(example = "transfer", description = "type is the network-specific operation type.")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SearchTransactionsRequest address(String address) {
    this.address = address;
    return this;
  }

  /**
   * address is AccountIdentifier.Address. This is used to get all transactions related to an AccountIdentifier.Address, regardless of SubAccountIdentifier.
   * @return address
   **/
  @Schema(example = "0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347", description = "address is AccountIdentifier.Address. This is used to get all transactions related to an AccountIdentifier.Address, regardless of SubAccountIdentifier.")
  
    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SearchTransactionsRequest success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * success is a synthetic condition populated by parsing network-specific operation statuses (using the mapping provided in `/network/options`).
   * @return success
   **/
  @Schema(description = "success is a synthetic condition populated by parsing network-specific operation statuses (using the mapping provided in `/network/options`).")
  
    public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchTransactionsRequest searchTransactionsRequest = (SearchTransactionsRequest) o;
    return Objects.equals(this.networkIdentifier, searchTransactionsRequest.networkIdentifier) &&
        Objects.equals(this.operator, searchTransactionsRequest.operator) &&
        Objects.equals(this.maxBlock, searchTransactionsRequest.maxBlock) &&
        Objects.equals(this.offset, searchTransactionsRequest.offset) &&
        Objects.equals(this.limit, searchTransactionsRequest.limit) &&
        Objects.equals(this.transactionIdentifier, searchTransactionsRequest.transactionIdentifier) &&
        Objects.equals(this.accountIdentifier, searchTransactionsRequest.accountIdentifier) &&
        Objects.equals(this.coinIdentifier, searchTransactionsRequest.coinIdentifier) &&
        Objects.equals(this.currency, searchTransactionsRequest.currency) &&
        Objects.equals(this.status, searchTransactionsRequest.status) &&
        Objects.equals(this.type, searchTransactionsRequest.type) &&
        Objects.equals(this.address, searchTransactionsRequest.address) &&
        Objects.equals(this.success, searchTransactionsRequest.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, operator, maxBlock, offset, limit, transactionIdentifier, accountIdentifier, coinIdentifier, currency, status, type, address, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchTransactionsRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    maxBlock: ").append(toIndentedString(maxBlock)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    coinIdentifier: ").append(toIndentedString(coinIdentifier)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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
