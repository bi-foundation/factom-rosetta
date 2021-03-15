package org.blockchain_innovation.factom.rosetta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.blockchain_innovation.factom.rosetta.model.CurveType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PublicKey contains a public key byte array for a particular CurveType encoded in hex. Note that there is no PrivateKey struct as this is NEVER the concern of an implementation.
 */
@Schema(description = "PublicKey contains a public key byte array for a particular CurveType encoded in hex. Note that there is no PrivateKey struct as this is NEVER the concern of an implementation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")


public class PublicKey   {
  @JsonProperty("hex_bytes")
  private String hexBytes = null;

  @JsonProperty("curve_type")
  private CurveType curveType = null;

  public PublicKey hexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
    return this;
  }

  /**
   * Hex-encoded public key bytes in the format specified by the CurveType.
   * @return hexBytes
   **/
  @Schema(required = true, description = "Hex-encoded public key bytes in the format specified by the CurveType.")
      @NotNull

    public String getHexBytes() {
    return hexBytes;
  }

  public void setHexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
  }

  public PublicKey curveType(CurveType curveType) {
    this.curveType = curveType;
    return this;
  }

  /**
   * Get curveType
   * @return curveType
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public CurveType getCurveType() {
    return curveType;
  }

  public void setCurveType(CurveType curveType) {
    this.curveType = curveType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicKey publicKey = (PublicKey) o;
    return Objects.equals(this.hexBytes, publicKey.hexBytes) &&
        Objects.equals(this.curveType, publicKey.curveType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hexBytes, curveType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicKey {\n");
    
    sb.append("    hexBytes: ").append(toIndentedString(hexBytes)).append("\n");
    sb.append("    curveType: ").append(toIndentedString(curveType)).append("\n");
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
