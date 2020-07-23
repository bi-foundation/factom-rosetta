package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A TransactionSubmitResponse contains the transaction_identifier of a submitted transaction that was accepted into the mempool.
 */
@ApiModel(description = "A TransactionSubmitResponse contains the transaction_identifier of a submitted transaction that was accepted into the mempool.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class ConstructionSubmitResponse   {
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public ConstructionSubmitResponse transactionIdentifier(TransactionIdentifier transactionIdentifier) {
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

  public ConstructionSubmitResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  
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
    ConstructionSubmitResponse constructionSubmitResponse = (ConstructionSubmitResponse) o;
    return Objects.equals(this.transactionIdentifier, constructionSubmitResponse.transactionIdentifier) &&
        Objects.equals(this.metadata, constructionSubmitResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifier, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionSubmitResponse {\n");
    
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
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
