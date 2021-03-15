package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.Block;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A BlockResponse includes a fully-populated block or a partially-populated block with a list of other transactions to fetch (other_transactions). As a result of the consensus algorithm of some blockchains, blocks can be omitted (i.e. certain block indices can be skipped). If a query for one of these omitted indices is made, the response should not include a &#x60;Block&#x60; object. It is VERY important to note that blocks MUST still form a canonical, connected chain of blocks where each block has a unique index. In other words, the &#x60;PartialBlockIdentifier&#x60; of a block after an omitted block should reference the last non-omitted block.
 */
@Schema(description = "A BlockResponse includes a fully-populated block or a partially-populated block with a list of other transactions to fetch (other_transactions). As a result of the consensus algorithm of some blockchains, blocks can be omitted (i.e. certain block indices can be skipped). If a query for one of these omitted indices is made, the response should not include a `Block` object. It is VERY important to note that blocks MUST still form a canonical, connected chain of blocks where each block has a unique index. In other words, the `PartialBlockIdentifier` of a block after an omitted block should reference the last non-omitted block.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class BlockResponse   {
  @JsonProperty("block")
  private Block block = null;

  @JsonProperty("other_transactions")
  @Valid
  private List<TransactionIdentifier> otherTransactions = null;

  public BlockResponse block(Block block) {
    this.block = block;
    return this;
  }

  /**
   * Get block
   * @return block
   **/
  @Schema(description = "")
  
    @Valid
    public Block getBlock() {
    return block;
  }

  public void setBlock(Block block) {
    this.block = block;
  }

  public BlockResponse otherTransactions(List<TransactionIdentifier> otherTransactions) {
    this.otherTransactions = otherTransactions;
    return this;
  }

  public BlockResponse addOtherTransactionsItem(TransactionIdentifier otherTransactionsItem) {
    if (this.otherTransactions == null) {
      this.otherTransactions = new ArrayList<TransactionIdentifier>();
    }
    this.otherTransactions.add(otherTransactionsItem);
    return this;
  }

  /**
   * Some blockchains may require additional transactions to be fetched that weren't returned in the block response (ex: block only returns transaction hashes). For blockchains with a lot of transactions in each block, this can be very useful as consumers can concurrently fetch all transactions returned.
   * @return otherTransactions
   **/
  @Schema(description = "Some blockchains may require additional transactions to be fetched that weren't returned in the block response (ex: block only returns transaction hashes). For blockchains with a lot of transactions in each block, this can be very useful as consumers can concurrently fetch all transactions returned.")
      @Valid
    public List<TransactionIdentifier> getOtherTransactions() {
    return otherTransactions;
  }

  public void setOtherTransactions(List<TransactionIdentifier> otherTransactions) {
    this.otherTransactions = otherTransactions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockResponse blockResponse = (BlockResponse) o;
    return Objects.equals(this.block, blockResponse.block) &&
        Objects.equals(this.otherTransactions, blockResponse.otherTransactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(block, otherTransactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockResponse {\n");
    
    sb.append("    block: ").append(toIndentedString(block)).append("\n");
    sb.append("    otherTransactions: ").append(toIndentedString(otherTransactions)).append("\n");
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
