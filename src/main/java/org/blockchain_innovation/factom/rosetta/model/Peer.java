package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A Peer is a representation of a node&#x27;s peer.
 */
@Schema(description = "A Peer is a representation of a node's peer.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class Peer   {
  @JsonProperty("peer_id")
  private String peerId = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public Peer peerId(String peerId) {
    this.peerId = peerId;
    return this;
  }

  /**
   * Get peerId
   * @return peerId
   **/
  @Schema(example = "0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5", required = true, description = "")
      @NotNull

    public String getPeerId() {
    return peerId;
  }

  public void setPeerId(String peerId) {
    this.peerId = peerId;
  }

  public Peer metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Schema(description = "")
  
    public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Peer peer = (Peer) o;
    return Objects.equals(this.peerId, peer.peerId) &&
        Objects.equals(this.metadata, peer.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(peerId, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Peer {\n");
    
    sb.append("    peerId: ").append(toIndentedString(peerId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
