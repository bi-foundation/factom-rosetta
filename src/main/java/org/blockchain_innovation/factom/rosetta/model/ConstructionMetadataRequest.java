package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.PublicKey;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A ConstructionMetadataRequest is utilized to get information required to construct a transaction. The Options object used to specify which metadata to return is left purposely unstructured to allow flexibility for implementers. Options is not required in the case that there is network-wide metadata of interest. Optionally, the request can also include an array of PublicKeys associated with the AccountIdentifiers returned in ConstructionPreprocessResponse.
 */
@Schema(description = "A ConstructionMetadataRequest is utilized to get information required to construct a transaction. The Options object used to specify which metadata to return is left purposely unstructured to allow flexibility for implementers. Options is not required in the case that there is network-wide metadata of interest. Optionally, the request can also include an array of PublicKeys associated with the AccountIdentifiers returned in ConstructionPreprocessResponse.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class ConstructionMetadataRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("options")
  private Object options = null;

  @JsonProperty("public_keys")
  @Valid
  private List<PublicKey> publicKeys = null;

  public ConstructionMetadataRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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

  public ConstructionMetadataRequest options(Object options) {
    this.options = options;
    return this;
  }

  /**
   * Some blockchains require different metadata for different types of transaction construction (ex: delegation versus a transfer). Instead of requiring a blockchain node to return all possible types of metadata for construction (which may require multiple node fetches), the client can populate an options object to limit the metadata returned to only the subset required.
   * @return options
   **/
  @Schema(description = "Some blockchains require different metadata for different types of transaction construction (ex: delegation versus a transfer). Instead of requiring a blockchain node to return all possible types of metadata for construction (which may require multiple node fetches), the client can populate an options object to limit the metadata returned to only the subset required.")
  
    public Object getOptions() {
    return options;
  }

  public void setOptions(Object options) {
    this.options = options;
  }

  public ConstructionMetadataRequest publicKeys(List<PublicKey> publicKeys) {
    this.publicKeys = publicKeys;
    return this;
  }

  public ConstructionMetadataRequest addPublicKeysItem(PublicKey publicKeysItem) {
    if (this.publicKeys == null) {
      this.publicKeys = new ArrayList<PublicKey>();
    }
    this.publicKeys.add(publicKeysItem);
    return this;
  }

  /**
   * Get publicKeys
   * @return publicKeys
   **/
  @Schema(description = "")
      @Valid
    public List<PublicKey> getPublicKeys() {
    return publicKeys;
  }

  public void setPublicKeys(List<PublicKey> publicKeys) {
    this.publicKeys = publicKeys;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionMetadataRequest constructionMetadataRequest = (ConstructionMetadataRequest) o;
    return Objects.equals(this.networkIdentifier, constructionMetadataRequest.networkIdentifier) &&
        Objects.equals(this.options, constructionMetadataRequest.options) &&
        Objects.equals(this.publicKeys, constructionMetadataRequest.publicKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, options, publicKeys);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionMetadataRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    publicKeys: ").append(toIndentedString(publicKeys)).append("\n");
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
