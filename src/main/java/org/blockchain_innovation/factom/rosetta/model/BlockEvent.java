package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.BlockEventType;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BlockEvent represents the addition or removal of a BlockIdentifier from storage. Streaming BlockEvents allows lightweight clients to update their own state without needing to implement their own syncing logic.
 */
@Schema(description = "BlockEvent represents the addition or removal of a BlockIdentifier from storage. Streaming BlockEvents allows lightweight clients to update their own state without needing to implement their own syncing logic.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class BlockEvent   {
  @JsonProperty("sequence")
  private Long sequence = null;

  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;

  @JsonProperty("type")
  private BlockEventType type = null;

  public BlockEvent sequence(Long sequence) {
    this.sequence = sequence;
    return this;
  }

  /**
   * sequence is the unique identifier of a BlockEvent within the context of a NetworkIdentifier.
   * minimum: 0
   * @return sequence
   **/
  @Schema(example = "5", required = true, description = "sequence is the unique identifier of a BlockEvent within the context of a NetworkIdentifier.")
      @NotNull

  @Min(0L)  public Long getSequence() {
    return sequence;
  }

  public void setSequence(Long sequence) {
    this.sequence = sequence;
  }

  public BlockEvent blockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
    return this;
  }

  /**
   * Get blockIdentifier
   * @return blockIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BlockIdentifier getBlockIdentifier() {
    return blockIdentifier;
  }

  public void setBlockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
  }

  public BlockEvent type(BlockEventType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BlockEventType getType() {
    return type;
  }

  public void setType(BlockEventType type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockEvent blockEvent = (BlockEvent) o;
    return Objects.equals(this.sequence, blockEvent.sequence) &&
        Objects.equals(this.blockIdentifier, blockEvent.blockIdentifier) &&
        Objects.equals(this.type, blockEvent.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequence, blockIdentifier, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockEvent {\n");
    
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
