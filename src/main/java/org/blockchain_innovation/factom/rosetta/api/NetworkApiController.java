package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.rosetta.model.Error;
import org.blockchain_innovation.factom.rosetta.model.MetadataRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkListResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkOptionsResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkRequest;
import org.blockchain_innovation.factom.rosetta.model.NetworkStatusResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
@Controller
public class NetworkApiController implements NetworkApi {

    private static final Logger log = LoggerFactory.getLogger(NetworkApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public NetworkApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<NetworkListResponse> networkList(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MetadataRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<NetworkListResponse>(objectMapper.readValue("{\n  \"network_identifiers\" : [ {\n    \"blockchain\" : \"bitcoin\",\n    \"sub_network_identifier\" : {\n      \"metadata\" : {\n        \"producer\" : \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"\n      },\n      \"network\" : \"shard 1\"\n    },\n    \"network\" : \"mainnet\"\n  }, {\n    \"blockchain\" : \"bitcoin\",\n    \"sub_network_identifier\" : {\n      \"metadata\" : {\n        \"producer\" : \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"\n      },\n      \"network\" : \"shard 1\"\n    },\n    \"network\" : \"mainnet\"\n  } ]\n}", NetworkListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<NetworkListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<NetworkListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<NetworkOptionsResponse> networkOptions(@ApiParam(value = "" ,required=true )  @Valid @RequestBody NetworkRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<NetworkOptionsResponse>(objectMapper.readValue("{\n  \"allow\" : {\n    \"operation_types\" : [ \"TRANSFER\", \"TRANSFER\" ],\n    \"historical_balance_lookup\" : true,\n    \"operation_statuses\" : [ {\n      \"status\" : \"SUCCESS\",\n      \"successful\" : true\n    }, {\n      \"status\" : \"SUCCESS\",\n      \"successful\" : true\n    } ],\n    \"errors\" : [ {\n      \"retriable\" : true,\n      \"code\" : 12,\n      \"details\" : {\n        \"address\" : \"0x1dcc4de8dec75d7aab85b567b6\",\n        \"error\" : \"not base64\"\n      },\n      \"message\" : \"Invalid account format\"\n    }, {\n      \"retriable\" : true,\n      \"code\" : 12,\n      \"details\" : {\n        \"address\" : \"0x1dcc4de8dec75d7aab85b567b6\",\n        \"error\" : \"not base64\"\n      },\n      \"message\" : \"Invalid account format\"\n    } ]\n  },\n  \"version\" : {\n    \"metadata\" : { },\n    \"rosetta_version\" : \"1.2.5\",\n    \"node_version\" : \"1.0.2\",\n    \"middleware_version\" : \"0.2.7\"\n  }\n}", NetworkOptionsResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<NetworkOptionsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<NetworkOptionsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<NetworkStatusResponse> networkStatus(@ApiParam(value = "" ,required=true )  @Valid @RequestBody NetworkRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<NetworkStatusResponse>(objectMapper.readValue("{\n  \"current_block_identifier\" : {\n    \"index\" : 1123941,\n    \"hash\" : \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\n  },\n  \"peers\" : [ {\n    \"metadata\" : { },\n    \"peer_id\" : \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"\n  }, {\n    \"metadata\" : { },\n    \"peer_id\" : \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"\n  } ],\n  \"current_block_timestamp\" : 1582833600000\n}", NetworkStatusResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<NetworkStatusResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<NetworkStatusResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
