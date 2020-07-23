package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Instead of utilizing HTTP status codes to describe node errors (which often do not have a good analog), rich errors are returned using this object.
 */
@ApiModel(description = "Instead of utilizing HTTP status codes to describe node errors (which often do not have a good analog), rich errors are returned using this object.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class Error   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("retriable")
  private Boolean retriable = null;

  @JsonProperty("details")
  private Object details = null;

  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Code is a network-specific error code. If desired, this code can be equivalent to an HTTP status code.
   * minimum: 0
   * @return code
  **/
  @ApiModelProperty(example = "12", required = true, value = "Code is a network-specific error code. If desired, this code can be equivalent to an HTTP status code.")
      @NotNull

  @Min(0)  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Message is a network-specific error message.
   * @return message
  **/
  @ApiModelProperty(example = "Invalid account format", required = true, value = "Message is a network-specific error message.")
      @NotNull

    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error retriable(Boolean retriable) {
    this.retriable = retriable;
    return this;
  }

  /**
   * An error is retriable if the same request may succeed if submitted again.
   * @return retriable
  **/
  @ApiModelProperty(required = true, value = "An error is retriable if the same request may succeed if submitted again.")
      @NotNull

    public Boolean isRetriable() {
    return retriable;
  }

  public void setRetriable(Boolean retriable) {
    this.retriable = retriable;
  }

  public Error details(Object details) {
    this.details = details;
    return this;
  }

  /**
   * Often times it is useful to return context specific to the request that caused the error (i.e. a sample of the stack trace or impacted account) in addition to the standard error message.
   * @return details
  **/
  @ApiModelProperty(example = "{\"address\":\"0x1dcc4de8dec75d7aab85b567b6\",\"error\":\"not base64\"}", value = "Often times it is useful to return context specific to the request that caused the error (i.e. a sample of the stack trace or impacted account) in addition to the standard error message.")
  
    public Object getDetails() {
    return details;
  }

  public void setDetails(Object details) {
    this.details = details;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.retriable, error.retriable) &&
        Objects.equals(this.details, error.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, retriable, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    retriable: ").append(toIndentedString(retriable)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
