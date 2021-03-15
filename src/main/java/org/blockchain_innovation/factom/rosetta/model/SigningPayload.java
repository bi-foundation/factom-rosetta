package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.SignatureType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SigningPayload is signed by the client with the keypair associated with an AccountIdentifier using the specified SignatureType. SignatureType can be optionally populated if there is a restriction on the signature scheme that can be used to sign the payload.
 */
@Schema(description = "SigningPayload is signed by the client with the keypair associated with an AccountIdentifier using the specified SignatureType. SignatureType can be optionally populated if there is a restriction on the signature scheme that can be used to sign the payload.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class SigningPayload   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;

  @JsonProperty("hex_bytes")
  private String hexBytes = null;

  @JsonProperty("signature_type")
  private SignatureType signatureType = null;

  public SigningPayload address(String address) {
    this.address = address;
    return this;
  }

  /**
   * [DEPRECATED by `account_identifier` in `v1.4.4`] The network-specific address of the account that should sign the payload.
   * @return address
   **/
  @Schema(description = "[DEPRECATED by `account_identifier` in `v1.4.4`] The network-specific address of the account that should sign the payload.")
  
    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SigningPayload accountIdentifier(AccountIdentifier accountIdentifier) {
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

  public SigningPayload hexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
    return this;
  }

  /**
   * Get hexBytes
   * @return hexBytes
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getHexBytes() {
    return hexBytes;
  }

  public void setHexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
  }

  public SigningPayload signatureType(SignatureType signatureType) {
    this.signatureType = signatureType;
    return this;
  }

  /**
   * Get signatureType
   * @return signatureType
   **/
  @Schema(description = "")
  
    @Valid
    public SignatureType getSignatureType() {
    return signatureType;
  }

  public void setSignatureType(SignatureType signatureType) {
    this.signatureType = signatureType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SigningPayload signingPayload = (SigningPayload) o;
    return Objects.equals(this.address, signingPayload.address) &&
        Objects.equals(this.accountIdentifier, signingPayload.accountIdentifier) &&
        Objects.equals(this.hexBytes, signingPayload.hexBytes) &&
        Objects.equals(this.signatureType, signingPayload.signatureType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, accountIdentifier, hexBytes, signatureType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SigningPayload {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    hexBytes: ").append(toIndentedString(hexBytes)).append("\n");
    sb.append("    signatureType: ").append(toIndentedString(signatureType)).append("\n");
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
