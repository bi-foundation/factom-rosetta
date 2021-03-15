package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.AccountIdentifier;
import org.blockchain_innovation.factom.rosetta.model.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConstructionParseResponse contains an array of operations that occur in a transaction blob. This should match the array of operations provided to &#x60;/construction/preprocess&#x60; and &#x60;/construction/payloads&#x60;.
 */
@Schema(description = "ConstructionParseResponse contains an array of operations that occur in a transaction blob. This should match the array of operations provided to `/construction/preprocess` and `/construction/payloads`.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class ConstructionParseResponse   {
  @JsonProperty("operations")
  @Valid
  private List<Operation> operations = new ArrayList<Operation>();

  @JsonProperty("signers")
  @Valid
  private List<String> signers = null;

  @JsonProperty("account_identifier_signers")
  @Valid
  private List<AccountIdentifier> accountIdentifierSigners = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public ConstructionParseResponse operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  public ConstructionParseResponse addOperationsItem(Operation operationsItem) {
    this.operations.add(operationsItem);
    return this;
  }

  /**
   * Get operations
   * @return operations
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Operation> getOperations() {
    return operations;
  }

  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  public ConstructionParseResponse signers(List<String> signers) {
    this.signers = signers;
    return this;
  }

  public ConstructionParseResponse addSignersItem(String signersItem) {
    if (this.signers == null) {
      this.signers = new ArrayList<String>();
    }
    this.signers.add(signersItem);
    return this;
  }

  /**
   * [DEPRECATED by `account_identifier_signers` in `v1.4.4`] All signers (addresses) of a particular transaction. If the transaction is unsigned, it should be empty.
   * @return signers
   **/
  @Schema(description = "[DEPRECATED by `account_identifier_signers` in `v1.4.4`] All signers (addresses) of a particular transaction. If the transaction is unsigned, it should be empty.")
  
    public List<String> getSigners() {
    return signers;
  }

  public void setSigners(List<String> signers) {
    this.signers = signers;
  }

  public ConstructionParseResponse accountIdentifierSigners(List<AccountIdentifier> accountIdentifierSigners) {
    this.accountIdentifierSigners = accountIdentifierSigners;
    return this;
  }

  public ConstructionParseResponse addAccountIdentifierSignersItem(AccountIdentifier accountIdentifierSignersItem) {
    if (this.accountIdentifierSigners == null) {
      this.accountIdentifierSigners = new ArrayList<AccountIdentifier>();
    }
    this.accountIdentifierSigners.add(accountIdentifierSignersItem);
    return this;
  }

  /**
   * Get accountIdentifierSigners
   * @return accountIdentifierSigners
   **/
  @Schema(description = "")
      @Valid
    public List<AccountIdentifier> getAccountIdentifierSigners() {
    return accountIdentifierSigners;
  }

  public void setAccountIdentifierSigners(List<AccountIdentifier> accountIdentifierSigners) {
    this.accountIdentifierSigners = accountIdentifierSigners;
  }

  public ConstructionParseResponse metadata(Object metadata) {
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
    ConstructionParseResponse constructionParseResponse = (ConstructionParseResponse) o;
    return Objects.equals(this.operations, constructionParseResponse.operations) &&
        Objects.equals(this.signers, constructionParseResponse.signers) &&
        Objects.equals(this.accountIdentifierSigners, constructionParseResponse.accountIdentifierSigners) &&
        Objects.equals(this.metadata, constructionParseResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operations, signers, accountIdentifierSigners, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionParseResponse {\n");
    
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    signers: ").append(toIndentedString(signers)).append("\n");
    sb.append("    accountIdentifierSigners: ").append(toIndentedString(accountIdentifierSigners)).append("\n");
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
