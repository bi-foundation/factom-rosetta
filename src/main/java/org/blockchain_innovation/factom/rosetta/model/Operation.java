package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.blockchain_innovation.factom.rosetta.model.CoinChange;
import org.blockchain_innovation.factom.rosetta.model.OperationIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Operations contain all balance-changing information within a transaction. They are always one-sided (only affect 1 AccountIdentifier) and can succeed or fail independently from a Transaction. Operations are used both to represent on-chain data (Data API) and to construct new transactions (Construction API), creating a standard interface for reading and writing to blockchains.
 */
@Schema(description = "Operations contain all balance-changing information within a transaction. They are always one-sided (only affect 1 AccountIdentifier) and can succeed or fail independently from a Transaction. Operations are used both to represent on-chain data (Data API) and to construct new transactions (Construction API), creating a standard interface for reading and writing to blockchains.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class  Operation   {
  @JsonProperty("operation_identifier")
  private OperationIdentifier operationIdentifier = null;

  @JsonProperty("related_operations")
  @Valid
  private List<OperationIdentifier> relatedOperations = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("account")
  private AccountIdentifier account = null;

  @JsonProperty("amount")
  private Amount amount = null;

  @JsonProperty("coin_change")
  private CoinChange coinChange = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public Operation operationIdentifier(OperationIdentifier operationIdentifier) {
    this.operationIdentifier = operationIdentifier;
    return this;
  }

  /**
   * Get operationIdentifier
   * @return operationIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OperationIdentifier getOperationIdentifier() {
    return operationIdentifier;
  }

  public void setOperationIdentifier(OperationIdentifier operationIdentifier) {
    this.operationIdentifier = operationIdentifier;
  }

  public Operation relatedOperations(List<OperationIdentifier> relatedOperations) {
    this.relatedOperations = relatedOperations;
    return this;
  }

  public Operation addRelatedOperationsItem(OperationIdentifier relatedOperationsItem) {
    if (this.relatedOperations == null) {
      this.relatedOperations = new ArrayList<OperationIdentifier>();
    }
    this.relatedOperations.add(relatedOperationsItem);
    return this;
  }

  /**
   * Restrict referenced related_operations to identifier indices < the current operation_identifier.index. This ensures there exists a clear DAG-structure of relations. Since operations are one-sided, one could imagine relating operations in a single transfer or linking operations in a call tree.
   * @return relatedOperations
   **/
  @Schema(example = "[{\"index\":1},{\"index\":2}]", description = "Restrict referenced related_operations to identifier indices < the current operation_identifier.index. This ensures there exists a clear DAG-structure of relations. Since operations are one-sided, one could imagine relating operations in a single transfer or linking operations in a call tree.")
      @Valid
    public List<OperationIdentifier> getRelatedOperations() {
    return relatedOperations;
  }

  public void setRelatedOperations(List<OperationIdentifier> relatedOperations) {
    this.relatedOperations = relatedOperations;
  }

  public Operation type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type is the network-specific type of the operation. Ensure that any type that can be returned here is also specified in the NetworkOptionsResponse. This can be very useful to downstream consumers that parse all block data.
   * @return type
   **/
  @Schema(example = "Transfer", required = true, description = "Type is the network-specific type of the operation. Ensure that any type that can be returned here is also specified in the NetworkOptionsResponse. This can be very useful to downstream consumers that parse all block data.")
      @NotNull

    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Operation status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status is the network-specific status of the operation. Status is not defined on the transaction object because blockchains with smart contracts may have transactions that partially apply (some operations are successful and some are not). Blockchains with atomic transactions (all operations succeed or all operations fail) will have the same status for each operation. On-chain operations (operations retrieved in the `/block` and `/block/transaction` endpoints) MUST have a populated status field (anything on-chain must have succeeded or failed). However, operations provided during transaction construction (often times called \"intent\" in the documentation) MUST NOT have a populated status field (operations yet to be included on-chain have not yet succeeded or failed).
   * @return status
   **/
  @Schema(example = "Reverted", description = "Status is the network-specific status of the operation. Status is not defined on the transaction object because blockchains with smart contracts may have transactions that partially apply (some operations are successful and some are not). Blockchains with atomic transactions (all operations succeed or all operations fail) will have the same status for each operation. On-chain operations (operations retrieved in the `/block` and `/block/transaction` endpoints) MUST have a populated status field (anything on-chain must have succeeded or failed). However, operations provided during transaction construction (often times called \"intent\" in the documentation) MUST NOT have a populated status field (operations yet to be included on-chain have not yet succeeded or failed).")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Operation account(AccountIdentifier account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
   **/
  @Schema(description = "")
  
    @Valid
    public AccountIdentifier getAccount() {
    return account;
  }

  public void setAccount(AccountIdentifier account) {
    this.account = account;
  }

  public Operation amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(description = "")
  
    @Valid
    public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public Operation coinChange(CoinChange coinChange) {
    this.coinChange = coinChange;
    return this;
  }

  /**
   * Get coinChange
   * @return coinChange
   **/
  @Schema(description = "")
  
    @Valid
    public CoinChange getCoinChange() {
    return coinChange;
  }

  public void setCoinChange(CoinChange coinChange) {
    this.coinChange = coinChange;
  }

  public Operation metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Schema(example = "{\"asm\":\"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\"hex\":\"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"}", description = "")
  
    public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operation operation = (Operation) o;
    return Objects.equals(this.operationIdentifier, operation.operationIdentifier) &&
        Objects.equals(this.relatedOperations, operation.relatedOperations) &&
        Objects.equals(this.type, operation.type) &&
        Objects.equals(this.status, operation.status) &&
        Objects.equals(this.account, operation.account) &&
        Objects.equals(this.amount, operation.amount) &&
        Objects.equals(this.coinChange, operation.coinChange) &&
        Objects.equals(this.metadata, operation.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationIdentifier, relatedOperations, type, status, account, amount, coinChange, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operation {\n");
    
    sb.append("    operationIdentifier: ").append(toIndentedString(operationIdentifier)).append("\n");
    sb.append("    relatedOperations: ").append(toIndentedString(relatedOperations)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    coinChange: ").append(toIndentedString(coinChange)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
