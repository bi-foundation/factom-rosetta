package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The transaction_identifier uniquely identifies a transaction in a particular network and block or in the mempool.
 */
@ApiModel(description = "The transaction_identifier uniquely identifies a transaction in a particular network and block or in the mempool.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class TransactionIdentifier   {
  @JsonProperty("hash")
  private String hash = null;

  public TransactionIdentifier hash(String hash) {
    this.hash = hash;
    return this;
  }

  /**
   * Any transactions that are attributable only to a block (ex: a block event) should use the hash of the block as the identifier.
   * @return hash
  **/
  @ApiModelProperty(example = "0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f", required = true, value = "Any transactions that are attributable only to a block (ex: a block event) should use the hash of the block as the identifier.")
      @NotNull

    public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionIdentifier transactionIdentifier = (TransactionIdentifier) o;
    return Objects.equals(this.hash, transactionIdentifier.hash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionIdentifier {\n");
    
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
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
