package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.PublicKey;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionDeriveRequest is passed to the &#x60;/construction/derive&#x60; endpoint. Network is provided in the request because some blockchains have different address formats for different networks. Metadata is provided in the request because some blockchains allow for multiple address types (i.e. different address for validators vs normal accounts).
 */
@ApiModel(description = "ConstructionDeriveRequest is passed to the `/construction/derive` endpoint. Network is provided in the request because some blockchains have different address formats for different networks. Metadata is provided in the request because some blockchains allow for multiple address types (i.e. different address for validators vs normal accounts).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class ConstructionDeriveRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("public_key")
  private PublicKey publicKey = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public ConstructionDeriveRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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

  public ConstructionDeriveRequest publicKey(PublicKey publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  /**
   * Get publicKey
   * @return publicKey
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public PublicKey getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(PublicKey publicKey) {
    this.publicKey = publicKey;
  }

  public ConstructionDeriveRequest metadata(Object metadata) {
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
    ConstructionDeriveRequest constructionDeriveRequest = (ConstructionDeriveRequest) o;
    return Objects.equals(this.networkIdentifier, constructionDeriveRequest.networkIdentifier) &&
        Objects.equals(this.publicKey, constructionDeriveRequest.publicKey) &&
        Objects.equals(this.metadata, constructionDeriveRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, publicKey, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionDeriveRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
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
