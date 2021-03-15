package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Used by RelatedTransaction to indicate the direction of the relation (i.e. cross-shard/cross-network sends may reference `backward` to an earlier transaction and async execution may reference `forward`). Can be used to indicate if a transaction relation is from child to parent or the reverse.
 */
public enum Direction {
  FORWARD("forward"),
    BACKWARD("backward");

  private String value;

  Direction(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Direction fromValue(String text) {
    for (Direction b : Direction.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
