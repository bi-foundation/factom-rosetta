package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * In blockchains with sharded state, the SubNetworkIdentifier is required to query some object on a specific shard. This identifier is optional for all non-sharded blockchains.
 */
@Schema(description = "In blockchains with sharded state, the SubNetworkIdentifier is required to query some object on a specific shard. This identifier is optional for all non-sharded blockchains.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class SubNetworkIdentifier   {
  @JsonProperty("network")
  private String network = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public SubNetworkIdentifier network(String network) {
    this.network = network;
    return this;
  }

  /**
   * Get network
   * @return network
   **/
  @Schema(example = "shard 1", required = true, description = "")
      @NotNull

    public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public SubNetworkIdentifier metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Schema(example = "{\"producer\":\"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"}", description = "")
  
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
    SubNetworkIdentifier subNetworkIdentifier = (SubNetworkIdentifier) o;
    return Objects.equals(this.network, subNetworkIdentifier.network) &&
        Objects.equals(this.metadata, subNetworkIdentifier.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubNetworkIdentifier {\n");
    
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
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
