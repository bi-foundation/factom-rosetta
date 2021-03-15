package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.Direction;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The related_transaction allows implementations to link together multiple transactions. An unpopulated network identifier indicates that the related transaction is on the same network.
 */
@Schema(description = "The related_transaction allows implementations to link together multiple transactions. An unpopulated network identifier indicates that the related transaction is on the same network.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class RelatedTransaction   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;

  @JsonProperty("direction")
  private Direction direction = null;

  public RelatedTransaction networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  /**
   * Get networkIdentifier
   * @return networkIdentifier
   **/
  @Schema(description = "")
  
    @Valid
    public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }

  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  public RelatedTransaction transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  /**
   * Get transactionIdentifier
   * @return transactionIdentifier
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }

  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  public RelatedTransaction direction(Direction direction) {
    this.direction = direction;
    return this;
  }

  /**
   * Get direction
   * @return direction
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedTransaction relatedTransaction = (RelatedTransaction) o;
    return Objects.equals(this.networkIdentifier, relatedTransaction.networkIdentifier) &&
        Objects.equals(this.transactionIdentifier, relatedTransaction.transactionIdentifier) &&
        Objects.equals(this.direction, relatedTransaction.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, transactionIdentifier, direction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedTransaction {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
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
