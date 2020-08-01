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

import static org.springframework.http.ResponseEntity.ok;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
@Controller
public class NetworkApiController implements NetworkApi {

    private static final Logger log = LoggerFactory.getLogger(NetworkApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final NetworkDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public NetworkApiController(ObjectMapper objectMapper, HttpServletRequest request, NetworkDelegate networkDelegate) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.delegate = networkDelegate;
    }

    public ResponseEntity<NetworkListResponse> networkList(@ApiParam(value = "", required = true) @Valid @RequestBody MetadataRequest metadataRequest) {
        return new ResponseEntity<NetworkListResponse>(delegate.networkList(metadataRequest), HttpStatus.OK);
    }

    public ResponseEntity<NetworkOptionsResponse> networkOptions(@ApiParam(value = "", required = true) @Valid @RequestBody NetworkRequest networkRequest) {
        return new ResponseEntity<NetworkOptionsResponse>(delegate.networkOptions(networkRequest), HttpStatus.OK);
    }

    public ResponseEntity<NetworkStatusResponse> networkStatus(@ApiParam(value = "", required = true) @Valid @RequestBody NetworkRequest networkRequest) {
        return new ResponseEntity<NetworkStatusResponse>(delegate.networkStatus(networkRequest), HttpStatus.OK);
    }

}
