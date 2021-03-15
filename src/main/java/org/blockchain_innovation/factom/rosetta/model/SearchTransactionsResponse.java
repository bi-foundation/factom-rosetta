package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.BlockTransaction;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SearchTransactionsResponse contains an ordered collection of BlockTransactions that match the query in SearchTransactionsRequest. These BlockTransactions are sorted from most recent block to oldest block.
 */
@Schema(description = "SearchTransactionsResponse contains an ordered collection of BlockTransactions that match the query in SearchTransactionsRequest. These BlockTransactions are sorted from most recent block to oldest block.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class SearchTransactionsResponse   {
  @JsonProperty("transactions")
  @Valid
  private List<BlockTransaction> transactions = new ArrayList<BlockTransaction>();

  @JsonProperty("total_count")
  private Long totalCount = null;

  @JsonProperty("next_offset")
  private Long nextOffset = null;

  public SearchTransactionsResponse transactions(List<BlockTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public SearchTransactionsResponse addTransactionsItem(BlockTransaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * transactions is an array of BlockTransactions sorted by most recent BlockIdentifier (meaning that transactions in recent blocks appear first). If there are many transactions for a particular search, transactions may not contain all matching transactions. It is up to the caller to paginate these transactions using the max_block field.
   * @return transactions
   **/
  @Schema(required = true, description = "transactions is an array of BlockTransactions sorted by most recent BlockIdentifier (meaning that transactions in recent blocks appear first). If there are many transactions for a particular search, transactions may not contain all matching transactions. It is up to the caller to paginate these transactions using the max_block field.")
      @NotNull
    @Valid
    public List<BlockTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<BlockTransaction> transactions) {
    this.transactions = transactions;
  }

  public SearchTransactionsResponse totalCount(Long totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * total_count is the number of results for a given search. Callers typically use this value to concurrently fetch results by offset or to display a virtual page number associated with results.
   * minimum: 0
   * @return totalCount
   **/
  @Schema(example = "5", required = true, description = "total_count is the number of results for a given search. Callers typically use this value to concurrently fetch results by offset or to display a virtual page number associated with results.")
      @NotNull

  @Min(0L)  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public SearchTransactionsResponse nextOffset(Long nextOffset) {
    this.nextOffset = nextOffset;
    return this;
  }

  /**
   * next_offset is the next offset to use when paginating through transaction results. If this field is not populated, there are no more transactions to query.
   * minimum: 0
   * @return nextOffset
   **/
  @Schema(example = "5", description = "next_offset is the next offset to use when paginating through transaction results. If this field is not populated, there are no more transactions to query.")
  
  @Min(0L)  public Long getNextOffset() {
    return nextOffset;
  }

  public void setNextOffset(Long nextOffset) {
    this.nextOffset = nextOffset;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchTransactionsResponse searchTransactionsResponse = (SearchTransactionsResponse) o;
    return Objects.equals(this.transactions, searchTransactionsResponse.transactions) &&
        Objects.equals(this.totalCount, searchTransactionsResponse.totalCount) &&
        Objects.equals(this.nextOffset, searchTransactionsResponse.nextOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactions, totalCount, nextOffset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchTransactionsResponse {\n");
    
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    nextOffset: ").append(toIndentedString(nextOffset)).append("\n");
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
