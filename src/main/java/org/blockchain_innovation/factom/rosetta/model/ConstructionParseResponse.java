package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionParseResponse contains an array of operations that occur in a transaction blob. This should match the array of operations provided to &#x60;/construction/preprocess&#x60; and &#x60;/construction/payloads&#x60;.
 */
@ApiModel(description = "ConstructionParseResponse contains an array of operations that occur in a transaction blob. This should match the array of operations provided to `/construction/preprocess` and `/construction/payloads`.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class ConstructionParseResponse   {
  @JsonProperty("operations")
  @Valid
  private List<Operation> operations = new ArrayList<Operation>();

  @JsonProperty("signers")
  @Valid
  private List<String> signers = new ArrayList<String>();

  @JsonProperty("metadata")
  private Object metadata = null;

  public ConstructionParseResponse operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  public ConstructionParseResponse addOperationsItem(Operation operationsItem) {
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

  public ConstructionParseResponse signers(List<String> signers) {
    this.signers = signers;
    return this;
  }

  public ConstructionParseResponse addSignersItem(String signersItem) {
    this.signers.add(signersItem);
    return this;
  }

  /**
   * All signers of a particular transaction. If the transaction is unsigned, it should be empty.
   * @return signers
  **/
  @ApiModelProperty(required = true, value = "All signers of a particular transaction. If the transaction is unsigned, it should be empty.")
      @NotNull

    public List<String> getSigners() {
    return signers;
  }

  public void setSigners(List<String> signers) {
    this.signers = signers;
  }

  public ConstructionParseResponse metadata(Object metadata) {
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
    ConstructionParseResponse constructionParseResponse = (ConstructionParseResponse) o;
    return Objects.equals(this.operations, constructionParseResponse.operations) &&
        Objects.equals(this.signers, constructionParseResponse.signers) &&
        Objects.equals(this.metadata, constructionParseResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operations, signers, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionParseResponse {\n");
    
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    signers: ").append(toIndentedString(signers)).append("\n");
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
