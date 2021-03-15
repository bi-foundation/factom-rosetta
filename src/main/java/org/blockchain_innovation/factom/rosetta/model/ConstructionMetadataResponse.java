package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.Amount;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The ConstructionMetadataResponse returns network-specific metadata used for transaction construction. Optionally, the implementer can return the suggested fee associated with the transaction being constructed. The caller may use this info to adjust the intent of the transaction or to create a transaction with a different account that can pay the suggested fee. Suggested fee is an array in case fee payment must occur in multiple currencies.
 */
@Schema(description = "The ConstructionMetadataResponse returns network-specific metadata used for transaction construction. Optionally, the implementer can return the suggested fee associated with the transaction being constructed. The caller may use this info to adjust the intent of the transaction or to create a transaction with a different account that can pay the suggested fee. Suggested fee is an array in case fee payment must occur in multiple currencies.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class ConstructionMetadataResponse   {
  @JsonProperty("metadata")
  private Object metadata = null;

  @JsonProperty("suggested_fee")
  @Valid
  private List<Amount> suggestedFee = null;

  public ConstructionMetadataResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Schema(example = "{\"account_sequence\":23,\"recent_block_hash\":\"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"}", required = true, description = "")
      @NotNull

    public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  public ConstructionMetadataResponse suggestedFee(List<Amount> suggestedFee) {
    this.suggestedFee = suggestedFee;
    return this;
  }

  public ConstructionMetadataResponse addSuggestedFeeItem(Amount suggestedFeeItem) {
    if (this.suggestedFee == null) {
      this.suggestedFee = new ArrayList<Amount>();
    }
    this.suggestedFee.add(suggestedFeeItem);
    return this;
  }

  /**
   * Get suggestedFee
   * @return suggestedFee
   **/
  @Schema(description = "")
      @Valid
    public List<Amount> getSuggestedFee() {
    return suggestedFee;
  }

  public void setSuggestedFee(List<Amount> suggestedFee) {
    this.suggestedFee = suggestedFee;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionMetadataResponse constructionMetadataResponse = (ConstructionMetadataResponse) o;
    return Objects.equals(this.metadata, constructionMetadataResponse.metadata) &&
        Objects.equals(this.suggestedFee, constructionMetadataResponse.suggestedFee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, suggestedFee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionMetadataResponse {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    suggestedFee: ").append(toIndentedString(suggestedFee)).append("\n");
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
