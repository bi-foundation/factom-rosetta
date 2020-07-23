package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transactions contain an array of Operations that are attributable to the same TransactionIdentifier.
 */
@ApiModel(description = "Transactions contain an array of Operations that are attributable to the same TransactionIdentifier.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class Transaction   {
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;

  @JsonProperty("operations")
  @Valid
  private List<Operation> operations = new ArrayList<Operation>();

  @JsonProperty("metadata")
  private Object metadata = null;

  public Transaction transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  /**
   * Get transactionIdentifier
   * @return transactionIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }

  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  public Transaction operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  public Transaction addOperationsItem(Operation operationsItem) {
    this.operations.add(operationsItem);
    return this;
  }

  /**
   * Get operations
   * @return operations
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<Operation> getOperations() {
    return operations;
  }

  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  public Transaction metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Transactions that are related to other transactions (like a cross-shard transaction) should include the tranaction_identifier of these transactions in the metadata.
   * @return metadata
  **/
  @ApiModelProperty(example = "{\"size\":12378,\"lockTime\":1582272577}", value = "Transactions that are related to other transactions (like a cross-shard transaction) should include the tranaction_identifier of these transactions in the metadata.")
  
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transactionIdentifier, transaction.transactionIdentifier) &&
        Objects.equals(this.operations, transaction.operations) &&
        Objects.equals(this.metadata, transaction.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifier, operations, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
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
