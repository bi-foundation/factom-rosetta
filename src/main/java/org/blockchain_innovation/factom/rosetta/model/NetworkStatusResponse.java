package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Peer;
import org.blockchain_innovation.factom.rosetta.model.SyncStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NetworkStatusResponse contains basic information about the node&#x27;s view of a blockchain network. It is assumed that any BlockIdentifier.Index less than or equal to CurrentBlockIdentifier.Index can be queried. If a Rosetta implementation prunes historical state, it should populate the optional &#x60;oldest_block_identifier&#x60; field with the oldest block available to query. If this is not populated, it is assumed that the &#x60;genesis_block_identifier&#x60; is the oldest queryable block. If a Rosetta implementation performs some pre-sync before it is possible to query blocks, sync_status should be populated so that clients can still monitor healthiness. Without this field, it may appear that the implementation is stuck syncing and needs to be terminated.
 */
@Schema(description = "NetworkStatusResponse contains basic information about the node's view of a blockchain network. It is assumed that any BlockIdentifier.Index less than or equal to CurrentBlockIdentifier.Index can be queried. If a Rosetta implementation prunes historical state, it should populate the optional `oldest_block_identifier` field with the oldest block available to query. If this is not populated, it is assumed that the `genesis_block_identifier` is the oldest queryable block. If a Rosetta implementation performs some pre-sync before it is possible to query blocks, sync_status should be populated so that clients can still monitor healthiness. Without this field, it may appear that the implementation is stuck syncing and needs to be terminated.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class NetworkStatusResponse   {
  @JsonProperty("current_block_identifier")
  private BlockIdentifier currentBlockIdentifier = null;

  @JsonProperty("current_block_timestamp")
  private Long currentBlockTimestamp = null;

  @JsonProperty("genesis_block_identifier")
  private BlockIdentifier genesisBlockIdentifier = null;

  @JsonProperty("oldest_block_identifier")
  private BlockIdentifier oldestBlockIdentifier = null;

  @JsonProperty("sync_status")
  private SyncStatus syncStatus = null;

  @JsonProperty("peers")
  @Valid
  private List<Peer> peers = new ArrayList<Peer>();

  public NetworkStatusResponse currentBlockIdentifier(BlockIdentifier currentBlockIdentifier) {
    this.currentBlockIdentifier = currentBlockIdentifier;
    return this;
  }

  /**
   * Get currentBlockIdentifier
   * @return currentBlockIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BlockIdentifier getCurrentBlockIdentifier() {
    return currentBlockIdentifier;
  }

  public void setCurrentBlockIdentifier(BlockIdentifier currentBlockIdentifier) {
    this.currentBlockIdentifier = currentBlockIdentifier;
  }

  public NetworkStatusResponse currentBlockTimestamp(Long currentBlockTimestamp) {
    this.currentBlockTimestamp = currentBlockTimestamp;
    return this;
  }

  /**
   * Get currentBlockTimestamp
   * @return currentBlockTimestamp
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getCurrentBlockTimestamp() {
    return currentBlockTimestamp;
  }

  public void setCurrentBlockTimestamp(Long currentBlockTimestamp) {
    this.currentBlockTimestamp = currentBlockTimestamp;
  }

  public NetworkStatusResponse genesisBlockIdentifier(BlockIdentifier genesisBlockIdentifier) {
    this.genesisBlockIdentifier = genesisBlockIdentifier;
    return this;
  }

  /**
   * Get genesisBlockIdentifier
   * @return genesisBlockIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BlockIdentifier getGenesisBlockIdentifier() {
    return genesisBlockIdentifier;
  }

  public void setGenesisBlockIdentifier(BlockIdentifier genesisBlockIdentifier) {
    this.genesisBlockIdentifier = genesisBlockIdentifier;
  }

  public NetworkStatusResponse oldestBlockIdentifier(BlockIdentifier oldestBlockIdentifier) {
    this.oldestBlockIdentifier = oldestBlockIdentifier;
    return this;
  }

  /**
   * Get oldestBlockIdentifier
   * @return oldestBlockIdentifier
   **/
  @Schema(description = "")
  
    @Valid
    public BlockIdentifier getOldestBlockIdentifier() {
    return oldestBlockIdentifier;
  }

  public void setOldestBlockIdentifier(BlockIdentifier oldestBlockIdentifier) {
    this.oldestBlockIdentifier = oldestBlockIdentifier;
  }

  public NetworkStatusResponse syncStatus(SyncStatus syncStatus) {
    this.syncStatus = syncStatus;
    return this;
  }

  /**
   * Get syncStatus
   * @return syncStatus
   **/
  @Schema(description = "")
  
    @Valid
    public SyncStatus getSyncStatus() {
    return syncStatus;
  }

  public void setSyncStatus(SyncStatus syncStatus) {
    this.syncStatus = syncStatus;
  }

  public NetworkStatusResponse peers(List<Peer> peers) {
    this.peers = peers;
    return this;
  }

  public NetworkStatusResponse addPeersItem(Peer peersItem) {
    this.peers.add(peersItem);
    return this;
  }

  /**
   * Get peers
   * @return peers
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Peer> getPeers() {
    return peers;
  }

  public void setPeers(List<Peer> peers) {
    this.peers = peers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkStatusResponse networkStatusResponse = (NetworkStatusResponse) o;
    return Objects.equals(this.currentBlockIdentifier, networkStatusResponse.currentBlockIdentifier) &&
        Objects.equals(this.currentBlockTimestamp, networkStatusResponse.currentBlockTimestamp) &&
        Objects.equals(this.genesisBlockIdentifier, networkStatusResponse.genesisBlockIdentifier) &&
        Objects.equals(this.oldestBlockIdentifier, networkStatusResponse.oldestBlockIdentifier) &&
        Objects.equals(this.syncStatus, networkStatusResponse.syncStatus) &&
        Objects.equals(this.peers, networkStatusResponse.peers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentBlockIdentifier, currentBlockTimestamp, genesisBlockIdentifier, oldestBlockIdentifier, syncStatus, peers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkStatusResponse {\n");
    
    sb.append("    currentBlockIdentifier: ").append(toIndentedString(currentBlockIdentifier)).append("\n");
    sb.append("    currentBlockTimestamp: ").append(toIndentedString(currentBlockTimestamp)).append("\n");
    sb.append("    genesisBlockIdentifier: ").append(toIndentedString(genesisBlockIdentifier)).append("\n");
    sb.append("    oldestBlockIdentifier: ").append(toIndentedString(oldestBlockIdentifier)).append("\n");
    sb.append("    syncStatus: ").append(toIndentedString(syncStatus)).append("\n");
    sb.append("    peers: ").append(toIndentedString(peers)).append("\n");
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
