package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SyncStatus is used to provide additional context about an implementation&#x27;s sync status. This object is often used by implementations to indicate healthiness when block data cannot be queried until some sync phase completes or cannot be determined by comparing the timestamp of the most recent block with the current time.
 */
@Schema(description = "SyncStatus is used to provide additional context about an implementation's sync status. This object is often used by implementations to indicate healthiness when block data cannot be queried until some sync phase completes or cannot be determined by comparing the timestamp of the most recent block with the current time.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class SyncStatus   {
  @JsonProperty("current_index")
  private Long currentIndex = null;

  @JsonProperty("target_index")
  private Long targetIndex = null;

  @JsonProperty("stage")
  private String stage = null;

  @JsonProperty("synced")
  private Boolean synced = null;

  public SyncStatus currentIndex(Long currentIndex) {
    this.currentIndex = currentIndex;
    return this;
  }

  /**
   * CurrentIndex is the index of the last synced block in the current stage. This is a separate field from current_block_identifier in NetworkStatusResponse because blocks with indices up to and including the current_index may not yet be queryable by the caller. To reiterate, all indices up to and including current_block_identifier in NetworkStatusResponse must be queryable via the /block endpoint (excluding indices less than oldest_block_identifier).
   * @return currentIndex
   **/
  @Schema(example = "100", description = "CurrentIndex is the index of the last synced block in the current stage. This is a separate field from current_block_identifier in NetworkStatusResponse because blocks with indices up to and including the current_index may not yet be queryable by the caller. To reiterate, all indices up to and including current_block_identifier in NetworkStatusResponse must be queryable via the /block endpoint (excluding indices less than oldest_block_identifier).")
  
    public Long getCurrentIndex() {
    return currentIndex;
  }

  public void setCurrentIndex(Long currentIndex) {
    this.currentIndex = currentIndex;
  }

  public SyncStatus targetIndex(Long targetIndex) {
    this.targetIndex = targetIndex;
    return this;
  }

  /**
   * TargetIndex is the index of the block that the implementation is attempting to sync to in the current stage.
   * @return targetIndex
   **/
  @Schema(example = "150", description = "TargetIndex is the index of the block that the implementation is attempting to sync to in the current stage.")
  
    public Long getTargetIndex() {
    return targetIndex;
  }

  public void setTargetIndex(Long targetIndex) {
    this.targetIndex = targetIndex;
  }

  public SyncStatus stage(String stage) {
    this.stage = stage;
    return this;
  }

  /**
   * Stage is the phase of the sync process.
   * @return stage
   **/
  @Schema(example = "header sync", description = "Stage is the phase of the sync process.")
  
    public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public SyncStatus synced(Boolean synced) {
    this.synced = synced;
    return this;
  }

  /**
   * sycned is a boolean that indicates if an implementation has synced up to the most recent block. If this field is not populated, the caller should rely on a traditional tip timestamp comparison to determine if an implementation is synced. This field is particularly useful for quiescent blockchains (blocks only produced when there are pending transactions). In these blockchains, the most recent block could have a timestamp far behind the current time but the node could be healthy and at tip.
   * @return synced
   **/
  @Schema(description = "sycned is a boolean that indicates if an implementation has synced up to the most recent block. If this field is not populated, the caller should rely on a traditional tip timestamp comparison to determine if an implementation is synced. This field is particularly useful for quiescent blockchains (blocks only produced when there are pending transactions). In these blockchains, the most recent block could have a timestamp far behind the current time but the node could be healthy and at tip.")
  
    public Boolean isSynced() {
    return synced;
  }

  public void setSynced(Boolean synced) {
    this.synced = synced;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyncStatus syncStatus = (SyncStatus) o;
    return Objects.equals(this.currentIndex, syncStatus.currentIndex) &&
        Objects.equals(this.targetIndex, syncStatus.targetIndex) &&
        Objects.equals(this.stage, syncStatus.stage) &&
        Objects.equals(this.synced, syncStatus.synced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentIndex, targetIndex, stage, synced);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyncStatus {\n");
    
    sb.append("    currentIndex: ").append(toIndentedString(currentIndex)).append("\n");
    sb.append("    targetIndex: ").append(toIndentedString(targetIndex)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
    sb.append("    synced: ").append(toIndentedString(synced)).append("\n");
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
