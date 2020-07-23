package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.blockchain_innovation.factom.rosetta.model.SubNetworkIdentifier;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The network_identifier specifies which network a particular object is associated with.
 */
@ApiModel(description = "The network_identifier specifies which network a particular object is associated with.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
public class NetworkIdentifier   {
  @JsonProperty("blockchain")
  private String blockchain = null;

  @JsonProperty("network")
  private String network = null;

  @JsonProperty("sub_network_identifier")
  private SubNetworkIdentifier subNetworkIdentifier = null;

  public NetworkIdentifier blockchain(String blockchain) {
    this.blockchain = blockchain;
    return this;
  }

  /**
   * Get blockchain
   * @return blockchain
  **/
  @ApiModelProperty(example = "bitcoin", required = true, value = "")
      @NotNull

    public String getBlockchain() {
    return blockchain;
  }

  public void setBlockchain(String blockchain) {
    this.blockchain = blockchain;
  }

  public NetworkIdentifier network(String network) {
    this.network = network;
    return this;
  }

  /**
   * If a blockchain has a specific chain-id or network identifier, it should go in this field. It is up to the client to determine which network-specific identifier is mainnet or testnet.
   * @return network
  **/
  @ApiModelProperty(example = "mainnet", required = true, value = "If a blockchain has a specific chain-id or network identifier, it should go in this field. It is up to the client to determine which network-specific identifier is mainnet or testnet.")
      @NotNull

    public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public NetworkIdentifier subNetworkIdentifier(SubNetworkIdentifier subNetworkIdentifier) {
    this.subNetworkIdentifier = subNetworkIdentifier;
    return this;
  }

  /**
   * Get subNetworkIdentifier
   * @return subNetworkIdentifier
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public SubNetworkIdentifier getSubNetworkIdentifier() {
    return subNetworkIdentifier;
  }

  public void setSubNetworkIdentifier(SubNetworkIdentifier subNetworkIdentifier) {
    this.subNetworkIdentifier = subNetworkIdentifier;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkIdentifier networkIdentifier = (NetworkIdentifier) o;
    return Objects.equals(this.blockchain, networkIdentifier.blockchain) &&
        Objects.equals(this.network, networkIdentifier.network) &&
        Objects.equals(this.subNetworkIdentifier, networkIdentifier.subNetworkIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockchain, network, subNetworkIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkIdentifier {\n");
    
    sb.append("    blockchain: ").append(toIndentedString(blockchain)).append("\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    subNetworkIdentifier: ").append(toIndentedString(subNetworkIdentifier)).append("\n");
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
