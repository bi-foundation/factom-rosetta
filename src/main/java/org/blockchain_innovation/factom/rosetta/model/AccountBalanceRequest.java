package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.PartialBlockIdentifier;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An AccountBalanceRequest is utilized to make a balance request on the /account/balance endpoint. If the block_identifier is populated, a historical balance query should be performed.
 */
@ApiModel(description = "An AccountBalanceRequest is utilized to make a balance request on the /account/balance endpoint. If the block_identifier is populated, a historical balance query should be performed.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class AccountBalanceRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;

  @JsonProperty("block_identifier")
  private PartialBlockIdentifier blockIdentifier = null;

  public AccountBalanceRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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

  public AccountBalanceRequest accountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

  /**
   * Get accountIdentifier
   * @return accountIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public AccountIdentifier getAccountIdentifier() {
    return accountIdentifier;
  }

  public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  public AccountBalanceRequest blockIdentifier(PartialBlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
    return this;
  }

  /**
   * Get blockIdentifier
   * @return blockIdentifier
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public PartialBlockIdentifier getBlockIdentifier() {
    return blockIdentifier;
  }

  public void setBlockIdentifier(PartialBlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountBalanceRequest accountBalanceRequest = (AccountBalanceRequest) o;
    return Objects.equals(this.networkIdentifier, accountBalanceRequest.networkIdentifier) &&
        Objects.equals(this.accountIdentifier, accountBalanceRequest.accountIdentifier) &&
        Objects.equals(this.blockIdentifier, accountBalanceRequest.blockIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, accountIdentifier, blockIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBalanceRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
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
