package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.BlockEvent;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EventsBlocksResponse contains an ordered collection of BlockEvents and the max retrievable sequence.
 */
@Schema(description = "EventsBlocksResponse contains an ordered collection of BlockEvents and the max retrievable sequence.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class EventsBlocksResponse   {
  @JsonProperty("max_sequence")
  private Long maxSequence = null;

  @JsonProperty("events")
  @Valid
  private List<BlockEvent> events = new ArrayList<BlockEvent>();

  public EventsBlocksResponse maxSequence(Long maxSequence) {
    this.maxSequence = maxSequence;
    return this;
  }

  /**
   * max_sequence is the maximum available sequence number to fetch.
   * minimum: 0
   * @return maxSequence
   **/
  @Schema(example = "5", required = true, description = "max_sequence is the maximum available sequence number to fetch.")
      @NotNull

  @Min(0L)  public Long getMaxSequence() {
    return maxSequence;
  }

  public void setMaxSequence(Long maxSequence) {
    this.maxSequence = maxSequence;
  }

  public EventsBlocksResponse events(List<BlockEvent> events) {
    this.events = events;
    return this;
  }

  public EventsBlocksResponse addEventsItem(BlockEvent eventsItem) {
    this.events.add(eventsItem);
    return this;
  }

  /**
   * events is an array of BlockEvents indicating the order to add and remove blocks to maintain a canonical view of blockchain state. Lightweight clients can use this event stream to update state without implementing their own block syncing logic.
   * @return events
   **/
  @Schema(required = true, description = "events is an array of BlockEvents indicating the order to add and remove blocks to maintain a canonical view of blockchain state. Lightweight clients can use this event stream to update state without implementing their own block syncing logic.")
      @NotNull
    @Valid
    public List<BlockEvent> getEvents() {
    return events;
  }

  public void setEvents(List<BlockEvent> events) {
    this.events = events;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventsBlocksResponse eventsBlocksResponse = (EventsBlocksResponse) o;
    return Objects.equals(this.maxSequence, eventsBlocksResponse.maxSequence) &&
        Objects.equals(this.events, eventsBlocksResponse.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxSequence, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventsBlocksResponse {\n");
    
    sb.append("    maxSequence: ").append(toIndentedString(maxSequence)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
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
