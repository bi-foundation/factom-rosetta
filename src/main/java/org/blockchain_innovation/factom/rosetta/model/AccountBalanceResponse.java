package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An AccountBalanceResponse is returned on the /account/balance endpoint. If an account has a balance for each AccountIdentifier describing it (ex: an ERC-20 token balance on a few smart contracts), an account balance request must be made with each AccountIdentifier. The &#x60;coins&#x60; field was removed and replaced by by &#x60;/account/coins&#x60; in &#x60;v1.4.7&#x60;.
 */
@Schema(description = "An AccountBalanceResponse is returned on the /account/balance endpoint. If an account has a balance for each AccountIdentifier describing it (ex: an ERC-20 token balance on a few smart contracts), an account balance request must be made with each AccountIdentifier. The `coins` field was removed and replaced by by `/account/coins` in `v1.4.7`.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class AccountBalanceResponse   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;

  @JsonProperty("balances")
  @Valid
  private List<Amount> balances = new ArrayList<Amount>();

  @JsonProperty("metadata")
  private Object metadata = null;

  public AccountBalanceResponse blockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
    return this;
  }

  /**
   * Get blockIdentifier
   * @return blockIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BlockIdentifier getBlockIdentifier() {
    return blockIdentifier;
  }

  public void setBlockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
  }

  public AccountBalanceResponse balances(List<Amount> balances) {
    this.balances = balances;
    return this;
  }

  public AccountBalanceResponse addBalancesItem(Amount balancesItem) {
    this.balances.add(balancesItem);
    return this;
  }

  /**
   * A single account may have a balance in multiple currencies.
   * @return balances
   **/
  @Schema(required = true, description = "A single account may have a balance in multiple currencies.")
      @NotNull
    @Valid
    public List<Amount> getBalances() {
    return balances;
  }

  public void setBalances(List<Amount> balances) {
    this.balances = balances;
  }

  public AccountBalanceResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Account-based blockchains that utilize a nonce or sequence number should include that number in the metadata. This number could be unique to the identifier or global across the account address.
   * @return metadata
   **/
  @Schema(example = "{\"sequence_number\":23}", description = "Account-based blockchains that utilize a nonce or sequence number should include that number in the metadata. This number could be unique to the identifier or global across the account address.")
  
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
    AccountBalanceResponse accountBalanceResponse = (AccountBalanceResponse) o;
    return Objects.equals(this.blockIdentifier, accountBalanceResponse.blockIdentifier) &&
        Objects.equals(this.balances, accountBalanceResponse.balances) &&
        Objects.equals(this.metadata, accountBalanceResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, balances, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBalanceResponse {\n");
    
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
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
