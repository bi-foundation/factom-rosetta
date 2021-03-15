package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionDeriveResponse is returned by the &#x60;/construction/derive&#x60; endpoint.
 */
@Schema(description = "ConstructionDeriveResponse is returned by the `/construction/derive` endpoint.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class ConstructionDeriveResponse   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public ConstructionDeriveResponse address(String address) {
    this.address = address;
    return this;
  }

  /**
   * [DEPRECATED by `account_identifier` in `v1.4.4`] Address in network-specific format.
   * @return address
   **/
  @Schema(description = "[DEPRECATED by `account_identifier` in `v1.4.4`] Address in network-specific format.")
  
    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ConstructionDeriveResponse accountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

  /**
   * Get accountIdentifier
   * @return accountIdentifier
   **/
  @Schema(description = "")
  
    @Valid
    public AccountIdentifier getAccountIdentifier() {
    return accountIdentifier;
  }

  public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  public ConstructionDeriveResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Schema(description = "")
  
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
    ConstructionDeriveResponse constructionDeriveResponse = (ConstructionDeriveResponse) o;
    return Objects.equals(this.address, constructionDeriveResponse.address) &&
        Objects.equals(this.accountIdentifier, constructionDeriveResponse.accountIdentifier) &&
        Objects.equals(this.metadata, constructionDeriveResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, accountIdentifier, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionDeriveResponse {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
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
