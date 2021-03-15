package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Operator is used by query-related endpoints to determine how to apply conditions. If this field is not populated, the default `and` value will be used.
 */
public enum Operator {
  OR("or"),
    AND("and");

  private String value;

  Operator(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Operator fromValue(String text) {
    for (Operator b : Operator.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
