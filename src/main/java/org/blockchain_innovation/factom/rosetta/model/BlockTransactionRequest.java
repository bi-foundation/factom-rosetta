package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.NetworkIdentifier;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A BlockTransactionRequest is used to fetch a Transaction included in a block that is not returned in a BlockResponse.
 */
@ApiModel(description = "A BlockTransactionRequest is used to fetch a Transaction included in a block that is not returned in a BlockResponse.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class BlockTransactionRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;

  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;

  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;

  public BlockTransactionRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  /**
   * Get networkIdentifier
   * @return networkIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }

  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  public BlockTransactionRequest blockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
    return this;
  }

  /**
   * Get blockIdentifier
   * @return blockIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BlockIdentifier getBlockIdentifier() {
    return blockIdentifier;
  }

  public void setBlockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
  }

  public BlockTransactionRequest transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  /**
   * Get transactionIdentifier
   * @return transactionIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }

  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockTransactionRequest blockTransactionRequest = (BlockTransactionRequest) o;
    return Objects.equals(this.networkIdentifier, blockTransactionRequest.networkIdentifier) &&
        Objects.equals(this.blockIdentifier, blockTransactionRequest.blockIdentifier) &&
        Objects.equals(this.transactionIdentifier, blockTransactionRequest.transactionIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, blockIdentifier, transactionIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockTransactionRequest {\n");
    
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
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
