package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * ExemptionType is used to indicate if the live balance for an account subject to a BalanceExemption could increase above, decrease below, or equal the computed balance. * greater_or_equal: The live balance may increase above or equal the computed balance. This typically   occurs with staking rewards that accrue on each block. * less_or_equal: The live balance may decrease below or equal the computed balance. This typically   occurs as balance moves from locked to spendable on a vesting account. * dynamic: The live balance may increase above, decrease below, or equal the computed balance. This   typically occurs with tokens that have a dynamic supply.
 */
public enum ExemptionType {
  GREATER_OR_EQUAL("greater_or_equal"),
    LESS_OR_EQUAL("less_or_equal"),
    DYNAMIC("dynamic");

  private String value;

  ExemptionType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ExemptionType fromValue(String text) {
    for (ExemptionType b : ExemptionType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
