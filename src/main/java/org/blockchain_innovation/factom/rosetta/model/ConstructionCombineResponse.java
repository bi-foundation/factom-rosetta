package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionCombineResponse is returned by &#x60;/construction/combine&#x60;. The network payload will be sent directly to the &#x60;construction/submit&#x60; endpoint.
 */
@Schema(description = "ConstructionCombineResponse is returned by `/construction/combine`. The network payload will be sent directly to the `construction/submit` endpoint.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class ConstructionCombineResponse   {
  @JsonProperty("signed_transaction")
  private String signedTransaction = null;

  public ConstructionCombineResponse signedTransaction(String signedTransaction) {
    this.signedTransaction = signedTransaction;
    return this;
  }

  /**
   * Get signedTransaction
   * @return signedTransaction
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getSignedTransaction() {
    return signedTransaction;
  }

  public void setSignedTransaction(String signedTransaction) {
    this.signedTransaction = signedTransaction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionCombineResponse constructionCombineResponse = (ConstructionCombineResponse) o;
    return Objects.equals(this.signedTransaction, constructionCombineResponse.signedTransaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signedTransaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionCombineResponse {\n");
    
    sb.append("    signedTransaction: ").append(toIndentedString(signedTransaction)).append("\n");
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
