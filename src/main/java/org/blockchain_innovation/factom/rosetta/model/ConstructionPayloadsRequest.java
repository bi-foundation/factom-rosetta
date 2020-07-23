package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionPayloadsRequest is the request to &#x60;/construction/payloads&#x60;. It contains the network, a slice of operations, and arbitrary metadata that was returned by the call to &#x60;/construction/metadata&#x60;.
 */
@ApiModel(description = "ConstructionPayloadsRequest is the request to `/construction/payloads`. It contains the network, a slice of operations, and arbitrary metadata that was returned by the call to `/construction/metadata`.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class ConstructionPayloadsRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("operations")
  @Valid
  private List<Operation> operations = new ArrayList<Operation>();

  @JsonProperty("metadata")
  private Object metadata = null;

  public ConstructionPayloadsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  /**
   * Get networkIdentifier
   * @return networkIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }

  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  public ConstructionPayloadsRequest operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  public ConstructionPayloadsRequest addOperationsItem(Operation operationsItem) {
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

  public ConstructionPayloadsRequest metadata(Object metadata) {
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
    ConstructionPayloadsRequest constructionPayloadsRequest = (ConstructionPayloadsRequest) o;
    return Objects.equals(this.networkIdentifier, constructionPayloadsRequest.networkIdentifier) &&
        Objects.equals(this.operations, constructionPayloadsRequest.operations) &&
        Objects.equals(this.metadata, constructionPayloadsRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, operations, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionPayloadsRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
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
