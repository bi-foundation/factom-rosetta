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
 * ConstructionHashResponse is the output of the &#x60;/construction/hash&#x60; endpoint.
 */
@ApiModel(description = "ConstructionHashResponse is the output of the `/construction/hash` endpoint.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class ConstructionHashResponse   {
  @JsonProperty("transaction_hash")
  private String transactionHash = null;

  public ConstructionHashResponse transactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
    return this;
  }

  /**
   * Get transactionHash
   * @return transactionHash
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getTransactionHash() {
    return transactionHash;
  }

  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionHashResponse constructionHashResponse = (ConstructionHashResponse) o;
    return Objects.equals(this.transactionHash, constructionHashResponse.transactionHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionHashResponse {\n");
    
    sb.append("    transactionHash: ").append(toIndentedString(transactionHash)).append("\n");
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
