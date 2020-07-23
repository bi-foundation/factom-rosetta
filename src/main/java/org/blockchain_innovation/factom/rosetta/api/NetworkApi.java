/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.rosetta.model.Error;
import org.blockchain_innovation.factom.rosetta.model.MetadataRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkListResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkOptionsResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkStatusResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
@Api(value = "network", description = "the network API")
public interface NetworkApi {

    @ApiOperation(value = "Get List of Available Networks", nickname = "networkList", notes = "This endpoint returns a list of NetworkIdentifiers that the Rosetta server supports.", response = NetworkListResponse.class, tags={ "Network", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = NetworkListResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/network/list",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<NetworkListResponse> networkList(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MetadataRequest body
);


    @ApiOperation(value = "Get Network Options", nickname = "networkOptions", notes = "This endpoint returns the version information and allowed network-specific types for a NetworkIdentifier. Any NetworkIdentifier returned by /network/list should be accessible here. Because options are retrievable in the context of a NetworkIdentifier, it is possible to define unique options for each network.", response = NetworkOptionsResponse.class, tags={ "Network", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = NetworkOptionsResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/network/options",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<NetworkOptionsResponse> networkOptions(@ApiParam(value = "" ,required=true )  @Valid @RequestBody NetworkRequest body
);


    @ApiOperation(value = "Get Network Status", nickname = "networkStatus", notes = "This endpoint returns the current status of the network requested. Any NetworkIdentifier returned by /network/list should be accessible here.", response = NetworkStatusResponse.class, tags={ "Network", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = NetworkStatusResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/network/status",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<NetworkStatusResponse> networkStatus(@ApiParam(value = "" ,required=true )  @Valid @RequestBody NetworkRequest body
);

}