package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.blockchain_innovation.factom.rosetta.model.OperationIdentifier;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Operations contain all balance-changing information within a transaction. They are always one-sided (only affect 1 AccountIdentifier) and can succeed or fail independently from a Transaction.
 */
@ApiModel(description = "Operations contain all balance-changing information within a transaction. They are always one-sided (only affect 1 AccountIdentifier) and can succeed or fail independently from a Transaction.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class Operation   {
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
  @ApiModelProperty(required = true, value = "")
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
   * Restrict referenced related_operations to identifier indexes < the current operation_identifier.index. This ensures there exists a clear DAG-structure of relations. Since operations are one-sided, one could imagine relating operations in a single transfer or linking operations in a call tree.
   * @return relatedOperations
  **/
  @ApiModelProperty(example = "[{\"index\":0,\"operation_identifier\":{\"index\":0}}]", value = "Restrict referenced related_operations to identifier indexes < the current operation_identifier.index. This ensures there exists a clear DAG-structure of relations. Since operations are one-sided, one could imagine relating operations in a single transfer or linking operations in a call tree.")
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
   * The network-specific type of the operation. Ensure that any type that can be returned here is also specified in the NetworkStatus. This can be very useful to downstream consumers that parse all block data.
   * @return type
  **/
  @ApiModelProperty(example = "Transfer", required = true, value = "The network-specific type of the operation. Ensure that any type that can be returned here is also specified in the NetworkStatus. This can be very useful to downstream consumers that parse all block data.")
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
   * The network-specific status of the operation. Status is not defined on the transaction object because blockchains with smart contracts may have transactions that partially apply. Blockchains with atomic transactions (all operations succeed or all operations fail) will have the same status for each operation.
   * @return status
  **/
  @ApiModelProperty(example = "Reverted", required = true, value = "The network-specific status of the operation. Status is not defined on the transaction object because blockchains with smart contracts may have transactions that partially apply. Blockchains with atomic transactions (all operations succeed or all operations fail) will have the same status for each operation.")
      @NotNull

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
  @ApiModelProperty(value = "")
  
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
  @ApiModelProperty(value = "")
  
    @Valid
    public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public Operation metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(example = "{\"asm\":\"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\"hex\":\"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"}", value = "")
  
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
        Objects.equals(this.metadata, operation.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationIdentifier, relatedOperations, type, status, account, amount, metadata);
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
