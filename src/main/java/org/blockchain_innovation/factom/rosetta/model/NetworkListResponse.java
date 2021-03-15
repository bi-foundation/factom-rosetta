package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A NetworkListResponse contains all NetworkIdentifiers that the node can serve information for.
 */
@Schema(description = "A NetworkListResponse contains all NetworkIdentifiers that the node can serve information for.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class NetworkListResponse   {
  @JsonProperty("network_identifiers")
  @Valid
  private List<NetworkIdentifier> networkIdentifiers = new ArrayList<NetworkIdentifier>();

  public NetworkListResponse networkIdentifiers(List<NetworkIdentifier> networkIdentifiers) {
    this.networkIdentifiers = networkIdentifiers;
    return this;
  }

  public NetworkListResponse addNetworkIdentifiersItem(NetworkIdentifier networkIdentifiersItem) {
    this.networkIdentifiers.add(networkIdentifiersItem);
    return this;
  }

  /**
   * Get networkIdentifiers
   * @return networkIdentifiers
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<NetworkIdentifier> getNetworkIdentifiers() {
    return networkIdentifiers;
  }

  public void setNetworkIdentifiers(List<NetworkIdentifier> networkIdentifiers) {
    this.networkIdentifiers = networkIdentifiers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkListResponse networkListResponse = (NetworkListResponse) o;
    return Objects.equals(this.networkIdentifiers, networkListResponse.networkIdentifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkListResponse {\n");
    
    sb.append("    networkIdentifiers: ").append(toIndentedString(networkIdentifiers)).append("\n");
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
