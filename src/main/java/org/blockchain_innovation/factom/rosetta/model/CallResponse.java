package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CallResponse contains the result of a &#x60;/call&#x60; invocation.
 */
@Schema(description = "CallResponse contains the result of a `/call` invocation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class CallResponse   {
  @JsonProperty("result")
  private Object result = null;

  @JsonProperty("idempotent")
  private Boolean idempotent = null;

  public CallResponse result(Object result) {
    this.result = result;
    return this;
  }

  /**
   * Result contains the result of the `/call` invocation. This result will not be inspected or interpreted by Rosetta tooling and is left to the caller to decode.
   * @return result
   **/
  @Schema(example = "{\"count\":1000}", required = true, description = "Result contains the result of the `/call` invocation. This result will not be inspected or interpreted by Rosetta tooling and is left to the caller to decode.")
      @NotNull

    public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public CallResponse idempotent(Boolean idempotent) {
    this.idempotent = idempotent;
    return this;
  }

  /**
   * Idempotent indicates that if `/call` is invoked with the same CallRequest again, at any point in time, it will return the same CallResponse. Integrators may cache the CallResponse if this is set to true to avoid making unnecessary calls to the Rosetta implementation. For this reason, implementers should be very conservative about returning true here or they could cause issues for the caller.
   * @return idempotent
   **/
  @Schema(required = true, description = "Idempotent indicates that if `/call` is invoked with the same CallRequest again, at any point in time, it will return the same CallResponse. Integrators may cache the CallResponse if this is set to true to avoid making unnecessary calls to the Rosetta implementation. For this reason, implementers should be very conservative about returning true here or they could cause issues for the caller.")
      @NotNull

    public Boolean isIdempotent() {
    return idempotent;
  }

  public void setIdempotent(Boolean idempotent) {
    this.idempotent = idempotent;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallResponse callResponse = (CallResponse) o;
    return Objects.equals(this.result, callResponse.result) &&
        Objects.equals(this.idempotent, callResponse.idempotent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, idempotent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallResponse {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    idempotent: ").append(toIndentedString(idempotent)).append("\n");
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
