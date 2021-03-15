package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import org.blockchain_innovation.factom.rosetta.model.RelatedTransaction;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transactions contain an array of Operations that are attributable to the same TransactionIdentifier.
 */
@Schema(description = "Transactions contain an array of Operations that are attributable to the same TransactionIdentifier.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class Transaction   {
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;

  @JsonProperty("operations")
  @Valid
  private List<Operation> operations = new ArrayList<Operation>();

  @JsonProperty("related_transactions")
  @Valid
  private List<RelatedTransaction> relatedTransactions = null;

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
  @Schema(required = true, description = "")
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
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Operation> getOperations() {
    return operations;
  }

  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  public Transaction relatedTransactions(List<RelatedTransaction> relatedTransactions) {
    this.relatedTransactions = relatedTransactions;
    return this;
  }

  public Transaction addRelatedTransactionsItem(RelatedTransaction relatedTransactionsItem) {
    if (this.relatedTransactions == null) {
      this.relatedTransactions = new ArrayList<RelatedTransaction>();
    }
    this.relatedTransactions.add(relatedTransactionsItem);
    return this;
  }

  /**
   * Get relatedTransactions
   * @return relatedTransactions
   **/
  @Schema(description = "")
      @Valid
    public List<RelatedTransaction> getRelatedTransactions() {
    return relatedTransactions;
  }

  public void setRelatedTransactions(List<RelatedTransaction> relatedTransactions) {
    this.relatedTransactions = relatedTransactions;
  }

  public Transaction metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Transactions that are related to other transactions (like a cross-shard transaction) should include the tranaction_identifier of these transactions in the metadata.
   * @return metadata
   **/
  @Schema(example = "{\"size\":12378,\"lockTime\":1582272577}", description = "Transactions that are related to other transactions (like a cross-shard transaction) should include the tranaction_identifier of these transactions in the metadata.")
  
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
        Objects.equals(this.relatedTransactions, transaction.relatedTransactions) &&
        Objects.equals(this.metadata, transaction.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifier, operations, relatedTransactions, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    relatedTransactions: ").append(toIndentedString(relatedTransactions)).append("\n");
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
