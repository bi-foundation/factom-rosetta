package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.BalanceExemption;
import org.blockchain_innovation.factom.rosetta.model.Error;
import org.blockchain_innovation.factom.rosetta.model.OperationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Allow specifies supported Operation status, Operation types, and all possible error statuses. This Allow object is used by clients to validate the correctness of a Rosetta Server implementation. It is expected that these clients will error if they receive some response that contains any of the above information that is not specified here.
 */
@Schema(description = "Allow specifies supported Operation status, Operation types, and all possible error statuses. This Allow object is used by clients to validate the correctness of a Rosetta Server implementation. It is expected that these clients will error if they receive some response that contains any of the above information that is not specified here.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class Allow   {
  @JsonProperty("operation_statuses")
  @Valid
  private List<OperationStatus> operationStatuses = new ArrayList<OperationStatus>();

  @JsonProperty("operation_types")
  @Valid
  private List<String> operationTypes = new ArrayList<String>();

  @JsonProperty("errors")
  @Valid
  private List<java.lang.Error> errors = new ArrayList<java.lang.Error>();

  @JsonProperty("historical_balance_lookup")
  private Boolean historicalBalanceLookup = null;

  @JsonProperty("timestamp_start_index")
  private Long timestampStartIndex = null;

  @JsonProperty("call_methods")
  @Valid
  private List<String> callMethods = new ArrayList<String>();

  @JsonProperty("balance_exemptions")
  @Valid
  private List<BalanceExemption> balanceExemptions = new ArrayList<BalanceExemption>();

  @JsonProperty("mempool_coins")
  private Boolean mempoolCoins = null;

  public Allow operationStatuses(List<OperationStatus> operationStatuses) {
    this.operationStatuses = operationStatuses;
    return this;
  }

  public Allow addOperationStatusesItem(OperationStatus operationStatusesItem) {
    this.operationStatuses.add(operationStatusesItem);
    return this;
  }

  /**
   * All Operation.Status this implementation supports. Any status that is returned during parsing that is not listed here will cause client validation to error.
   * @return operationStatuses
   **/
  @Schema(required = true, description = "All Operation.Status this implementation supports. Any status that is returned during parsing that is not listed here will cause client validation to error.")
      @NotNull
    @Valid
    public List<OperationStatus> getOperationStatuses() {
    return operationStatuses;
  }

  public void setOperationStatuses(List<OperationStatus> operationStatuses) {
    this.operationStatuses = operationStatuses;
  }

  public Allow operationTypes(List<String> operationTypes) {
    this.operationTypes = operationTypes;
    return this;
  }

  public Allow addOperationTypesItem(String operationTypesItem) {
    this.operationTypes.add(operationTypesItem);
    return this;
  }

  /**
   * All Operation.Type this implementation supports. Any type that is returned during parsing that is not listed here will cause client validation to error.
   * @return operationTypes
   **/
  @Schema(required = true, description = "All Operation.Type this implementation supports. Any type that is returned during parsing that is not listed here will cause client validation to error.")
      @NotNull

    public List<String> getOperationTypes() {
    return operationTypes;
  }

  public void setOperationTypes(List<String> operationTypes) {
    this.operationTypes = operationTypes;
  }

  public Allow errors(List<java.lang.Error> errors) {
    this.errors = errors;
    return this;
  }

  public Allow addErrorsItem(java.lang.Error errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * All Errors that this implementation could return. Any error that is returned during parsing that is not listed here will cause client validation to error.
   * @return errors
   **/
  @Schema(required = true, description = "All Errors that this implementation could return. Any error that is returned during parsing that is not listed here will cause client validation to error.")
      @NotNull
    @Valid
    public List<java.lang.Error> getErrors() {
    return errors;
  }

  public void setErrors(List<java.lang.Error> errors) {
    this.errors = errors;
  }

  public Allow historicalBalanceLookup(Boolean historicalBalanceLookup) {
    this.historicalBalanceLookup = historicalBalanceLookup;
    return this;
  }

  /**
   * Any Rosetta implementation that supports querying the balance of an account at any height in the past should set this to true.
   * @return historicalBalanceLookup
   **/
  @Schema(required = true, description = "Any Rosetta implementation that supports querying the balance of an account at any height in the past should set this to true.")
      @NotNull

    public Boolean isHistoricalBalanceLookup() {
    return historicalBalanceLookup;
  }

  public void setHistoricalBalanceLookup(Boolean historicalBalanceLookup) {
    this.historicalBalanceLookup = historicalBalanceLookup;
  }

  public Allow timestampStartIndex(Long timestampStartIndex) {
    this.timestampStartIndex = timestampStartIndex;
    return this;
  }

  /**
   * If populated, `timestamp_start_index` indicates the first block index where block timestamps are considered valid (i.e. all blocks less than `timestamp_start_index` could have invalid timestamps). This is useful when the genesis block (or blocks) of a network have timestamp 0. If not populated, block timestamps are assumed to be valid for all available blocks.
   * minimum: 0
   * @return timestampStartIndex
   **/
  @Schema(description = "If populated, `timestamp_start_index` indicates the first block index where block timestamps are considered valid (i.e. all blocks less than `timestamp_start_index` could have invalid timestamps). This is useful when the genesis block (or blocks) of a network have timestamp 0. If not populated, block timestamps are assumed to be valid for all available blocks.")
  
  @Min(0L)  public Long getTimestampStartIndex() {
    return timestampStartIndex;
  }

  public void setTimestampStartIndex(Long timestampStartIndex) {
    this.timestampStartIndex = timestampStartIndex;
  }

  public Allow callMethods(List<String> callMethods) {
    this.callMethods = callMethods;
    return this;
  }

  public Allow addCallMethodsItem(String callMethodsItem) {
    this.callMethods.add(callMethodsItem);
    return this;
  }

  /**
   * All methods that are supported by the /call endpoint. Communicating which parameters should be provided to /call is the responsibility of the implementer (this is en lieu of defining an entire type system and requiring the implementer to define that in Allow).
   * @return callMethods
   **/
  @Schema(required = true, description = "All methods that are supported by the /call endpoint. Communicating which parameters should be provided to /call is the responsibility of the implementer (this is en lieu of defining an entire type system and requiring the implementer to define that in Allow).")
      @NotNull

    public List<String> getCallMethods() {
    return callMethods;
  }

  public void setCallMethods(List<String> callMethods) {
    this.callMethods = callMethods;
  }

  public Allow balanceExemptions(List<BalanceExemption> balanceExemptions) {
    this.balanceExemptions = balanceExemptions;
    return this;
  }

  public Allow addBalanceExemptionsItem(BalanceExemption balanceExemptionsItem) {
    this.balanceExemptions.add(balanceExemptionsItem);
    return this;
  }

  /**
   * BalanceExemptions is an array of BalanceExemption indicating which account balances could change without a corresponding Operation. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).
   * @return balanceExemptions
   **/
  @Schema(required = true, description = "BalanceExemptions is an array of BalanceExemption indicating which account balances could change without a corresponding Operation. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).")
      @NotNull
    @Valid
    public List<BalanceExemption> getBalanceExemptions() {
    return balanceExemptions;
  }

  public void setBalanceExemptions(List<BalanceExemption> balanceExemptions) {
    this.balanceExemptions = balanceExemptions;
  }

  public Allow mempoolCoins(Boolean mempoolCoins) {
    this.mempoolCoins = mempoolCoins;
    return this;
  }

  /**
   * Any Rosetta implementation that can update an AccountIdentifier's unspent coins based on the contents of the mempool should populate this field as true. If false, requests to `/account/coins` that set `include_mempool` as true will be automatically rejected.
   * @return mempoolCoins
   **/
  @Schema(required = true, description = "Any Rosetta implementation that can update an AccountIdentifier's unspent coins based on the contents of the mempool should populate this field as true. If false, requests to `/account/coins` that set `include_mempool` as true will be automatically rejected.")
      @NotNull

    public Boolean isMempoolCoins() {
    return mempoolCoins;
  }

  public void setMempoolCoins(Boolean mempoolCoins) {
    this.mempoolCoins = mempoolCoins;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Allow allow = (Allow) o;
    return Objects.equals(this.operationStatuses, allow.operationStatuses) &&
        Objects.equals(this.operationTypes, allow.operationTypes) &&
        Objects.equals(this.errors, allow.errors) &&
        Objects.equals(this.historicalBalanceLookup, allow.historicalBalanceLookup) &&
        Objects.equals(this.timestampStartIndex, allow.timestampStartIndex) &&
        Objects.equals(this.callMethods, allow.callMethods) &&
        Objects.equals(this.balanceExemptions, allow.balanceExemptions) &&
        Objects.equals(this.mempoolCoins, allow.mempoolCoins);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationStatuses, operationTypes, errors, historicalBalanceLookup, timestampStartIndex, callMethods, balanceExemptions, mempoolCoins);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Allow {\n");
    
    sb.append("    operationStatuses: ").append(toIndentedString(operationStatuses)).append("\n");
    sb.append("    operationTypes: ").append(toIndentedString(operationTypes)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    historicalBalanceLookup: ").append(toIndentedString(historicalBalanceLookup)).append("\n");
    sb.append("    timestampStartIndex: ").append(toIndentedString(timestampStartIndex)).append("\n");
    sb.append("    callMethods: ").append(toIndentedString(callMethods)).append("\n");
    sb.append("    balanceExemptions: ").append(toIndentedString(balanceExemptions)).append("\n");
    sb.append("    mempoolCoins: ").append(toIndentedString(mempoolCoins)).append("\n");
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
