package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.SigningPayload;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionTransactionResponse is returned by &#x60;/construction/payloads&#x60;. It contains an unsigned transaction blob (that is usually needed to construct the a network transaction from a collection of signatures) and an array of payloads that must be signed by the caller.
 */
@Schema(description = "ConstructionTransactionResponse is returned by `/construction/payloads`. It contains an unsigned transaction blob (that is usually needed to construct the a network transaction from a collection of signatures) and an array of payloads that must be signed by the caller.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class ConstructionPayloadsResponse   {
  @JsonProperty("unsigned_transaction")
  private String unsignedTransaction = null;

  @JsonProperty("payloads")
  @Valid
  private List<SigningPayload> payloads = new ArrayList<SigningPayload>();

  public ConstructionPayloadsResponse unsignedTransaction(String unsignedTransaction) {
    this.unsignedTransaction = unsignedTransaction;
    return this;
  }

  /**
   * Get unsignedTransaction
   * @return unsignedTransaction
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUnsignedTransaction() {
    return unsignedTransaction;
  }

  public void setUnsignedTransaction(String unsignedTransaction) {
    this.unsignedTransaction = unsignedTransaction;
  }

  public ConstructionPayloadsResponse payloads(List<SigningPayload> payloads) {
    this.payloads = payloads;
    return this;
  }

  public ConstructionPayloadsResponse addPayloadsItem(SigningPayload payloadsItem) {
    this.payloads.add(payloadsItem);
    return this;
  }

  /**
   * Get payloads
   * @return payloads
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<SigningPayload> getPayloads() {
    return payloads;
  }

  public void setPayloads(List<SigningPayload> payloads) {
    this.payloads = payloads;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionPayloadsResponse constructionPayloadsResponse = (ConstructionPayloadsResponse) o;
    return Objects.equals(this.unsignedTransaction, constructionPayloadsResponse.unsignedTransaction) &&
        Objects.equals(this.payloads, constructionPayloadsResponse.payloads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unsignedTransaction, payloads);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionPayloadsResponse {\n");
    
    sb.append("    unsignedTransaction: ").append(toIndentedString(unsignedTransaction)).append("\n");
    sb.append("    payloads: ").append(toIndentedString(payloads)).append("\n");
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
