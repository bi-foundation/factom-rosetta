package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.SubAccountIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The account_identifier uniquely identifies an account within a network. All fields in the account_identifier are utilized to determine this uniqueness (including the metadata field, if populated).
 */
@Schema(description = "The account_identifier uniquely identifies an account within a network. All fields in the account_identifier are utilized to determine this uniqueness (including the metadata field, if populated).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class AccountIdentifier   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("sub_account")
  private SubAccountIdentifier subAccount = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public AccountIdentifier address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The address may be a cryptographic public key (or some encoding of it) or a provided username.
   * @return address
   **/
  @Schema(example = "0x3a065000ab4183c6bf581dc1e55a605455fc6d61", required = true, description = "The address may be a cryptographic public key (or some encoding of it) or a provided username.")
      @NotNull

    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public AccountIdentifier subAccount(SubAccountIdentifier subAccount) {
    this.subAccount = subAccount;
    return this;
  }

  /**
   * Get subAccount
   * @return subAccount
   **/
  @Schema(description = "")
  
    @Valid
    public SubAccountIdentifier getSubAccount() {
    return subAccount;
  }

  public void setSubAccount(SubAccountIdentifier subAccount) {
    this.subAccount = subAccount;
  }

  public AccountIdentifier metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Blockchains that utilize a username model (where the address is not a derivative of a cryptographic public key) should specify the public key(s) owned by the address in metadata.
   * @return metadata
   **/
  @Schema(description = "Blockchains that utilize a username model (where the address is not a derivative of a cryptographic public key) should specify the public key(s) owned by the address in metadata.")
  
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
    AccountIdentifier accountIdentifier = (AccountIdentifier) o;
    return Objects.equals(this.address, accountIdentifier.address) &&
        Objects.equals(this.subAccount, accountIdentifier.subAccount) &&
        Objects.equals(this.metadata, accountIdentifier.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, subAccount, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountIdentifier {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    subAccount: ").append(toIndentedString(subAccount)).append("\n");
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
