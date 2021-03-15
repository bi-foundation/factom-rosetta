package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The block_identifier uniquely identifies a block in a particular network.
 */
@Schema(description = "The block_identifier uniquely identifies a block in a particular network.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class BlockIdentifier   {
  @JsonProperty("index")
  private Long index = null;

  @JsonProperty("hash")
  private String hash = null;

  public BlockIdentifier index(Long index) {
    this.index = index;
    return this;
  }

  /**
   * This is also known as the block height.
   * @return index
   **/
  @Schema(example = "1123941", required = true, description = "This is also known as the block height.")
      @NotNull

    public Long getIndex() {
    return index;
  }

  public void setIndex(Long index) {
    this.index = index;
  }

  public BlockIdentifier hash(String hash) {
    this.hash = hash;
    return this;
  }

  /**
   * Get hash
   * @return hash
   **/
  @Schema(example = "0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85", required = true, description = "")
      @NotNull

    public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockIdentifier blockIdentifier = (BlockIdentifier) o;
    return Objects.equals(this.index, blockIdentifier.index) &&
        Objects.equals(this.hash, blockIdentifier.hash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, hash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockIdentifier {\n");
    
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
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
