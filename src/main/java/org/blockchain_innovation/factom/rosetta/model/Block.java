package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.BlockIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Blocks contain an array of Transactions that occurred at a particular BlockIdentifier.
 */
@ApiModel(description = "Blocks contain an array of Transactions that occurred at a particular BlockIdentifier.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class Block   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;

  @JsonProperty("parent_block_identifier")
  private BlockIdentifier parentBlockIdentifier = null;

  @JsonProperty("timestamp")
  private Long timestamp = null;

  @JsonProperty("transactions")
  @Valid
  private List<Transaction> transactions = new ArrayList<Transaction>();

  @JsonProperty("metadata")
  private Object metadata = null;

  public Block blockIdentifier(BlockIdentifier blockIdentifier) {
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

  public Block parentBlockIdentifier(BlockIdentifier parentBlockIdentifier) {
    this.parentBlockIdentifier = parentBlockIdentifier;
    return this;
  }

  /**
   * Get parentBlockIdentifier
   * @return parentBlockIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BlockIdentifier getParentBlockIdentifier() {
    return parentBlockIdentifier;
  }

  public void setParentBlockIdentifier(BlockIdentifier parentBlockIdentifier) {
    this.parentBlockIdentifier = parentBlockIdentifier;
  }

  public Block timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public Block transactions(List<Transaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public Block addTransactionsItem(Transaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Get transactions
   * @return transactions
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public Block metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(example = "{\"transactions_root\":\"0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347\",\"difficulty\":\"123891724987128947\"}", value = "")
  
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
    Block block = (Block) o;
    return Objects.equals(this.blockIdentifier, block.blockIdentifier) &&
        Objects.equals(this.parentBlockIdentifier, block.parentBlockIdentifier) &&
        Objects.equals(this.timestamp, block.timestamp) &&
        Objects.equals(this.transactions, block.transactions) &&
        Objects.equals(this.metadata, block.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, parentBlockIdentifier, timestamp, transactions, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Block {\n");
    
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    parentBlockIdentifier: ").append(toIndentedString(parentBlockIdentifier)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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
