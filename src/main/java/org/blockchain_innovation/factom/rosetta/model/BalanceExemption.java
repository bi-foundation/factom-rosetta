package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.Currency;
import org.blockchain_innovation.factom.rosetta.model.ExemptionType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BalanceExemption indicates that the balance for an exempt account could change without a corresponding Operation. This typically occurs with staking rewards, vesting balances, and Currencies with a dynamic supply. Currently, it is possible to exempt an account from strict reconciliation by SubAccountIdentifier.Address or by Currency. This means that any account with SubAccountIdentifier.Address would be exempt or any balance of a particular Currency would be exempt, respectively. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).
 */
@Schema(description = "BalanceExemption indicates that the balance for an exempt account could change without a corresponding Operation. This typically occurs with staking rewards, vesting balances, and Currencies with a dynamic supply. Currently, it is possible to exempt an account from strict reconciliation by SubAccountIdentifier.Address or by Currency. This means that any account with SubAccountIdentifier.Address would be exempt or any balance of a particular Currency would be exempt, respectively. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class BalanceExemption   {
  @JsonProperty("sub_account_address")
  private String subAccountAddress = null;

  @JsonProperty("currency")
  private Currency currency = null;

  @JsonProperty("exemption_type")
  private ExemptionType exemptionType = null;

  public BalanceExemption subAccountAddress(String subAccountAddress) {
    this.subAccountAddress = subAccountAddress;
    return this;
  }

  /**
   * SubAccountAddress is the SubAccountIdentifier.Address that the BalanceExemption applies to (regardless of the value of SubAccountIdentifier.Metadata).
   * @return subAccountAddress
   **/
  @Schema(example = "staking", description = "SubAccountAddress is the SubAccountIdentifier.Address that the BalanceExemption applies to (regardless of the value of SubAccountIdentifier.Metadata).")
  
    public String getSubAccountAddress() {
    return subAccountAddress;
  }

  public void setSubAccountAddress(String subAccountAddress) {
    this.subAccountAddress = subAccountAddress;
  }

  public BalanceExemption currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  @Schema(description = "")
  
    @Valid
    public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public BalanceExemption exemptionType(ExemptionType exemptionType) {
    this.exemptionType = exemptionType;
    return this;
  }

  /**
   * Get exemptionType
   * @return exemptionType
   **/
  @Schema(description = "")
  
    @Valid
    public ExemptionType getExemptionType() {
    return exemptionType;
  }

  public void setExemptionType(ExemptionType exemptionType) {
    this.exemptionType = exemptionType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceExemption balanceExemption = (BalanceExemption) o;
    return Objects.equals(this.subAccountAddress, balanceExemption.subAccountAddress) &&
        Objects.equals(this.currency, balanceExemption.currency) &&
        Objects.equals(this.exemptionType, balanceExemption.exemptionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subAccountAddress, currency, exemptionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceExemption {\n");
    
    sb.append("    subAccountAddress: ").append(toIndentedString(subAccountAddress)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    exemptionType: ").append(toIndentedString(exemptionType)).append("\n");
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
