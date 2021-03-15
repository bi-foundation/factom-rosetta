package org.blockchain_innovation.factom.rosetta.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.blockchain_innovation.factom.rosetta.model.Error;
import org.blockchain_innovation.factom.rosetta.model.MempoolResponse;
import org.blockchain_innovation.factom.rosetta.model.MempoolTransactionRequest;
import org.blockchain_innovation.factom.rosetta.model.MempoolTransactionResponse;
import org.blockchain_innovation.factom.rosetta.model.NetworkRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MempoolApiController implements MempoolApi {

    private static final Logger log = LoggerFactory.getLogger(MempoolApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final MempoolDelegate mempoolDelegate;

    @Autowired
    public MempoolApiController(MempoolDelegate mempoolDelegate, ObjectMapper objectMapper, HttpServletRequest request) {
        this.mempoolDelegate = mempoolDelegate;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<MempoolResponse> mempool(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody NetworkRequest body) {
        return ResponseEntity.ok(mempoolDelegate.mempool(body.getNetworkIdentifier()));
    }

    public ResponseEntity<MempoolTransactionResponse> mempoolTransaction(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody MempoolTransactionRequest body) {
        return ResponseEntity.ok(mempoolDelegate.mempoolTransaction(body.getNetworkIdentifier(), body.getTransactionIdentifier()));
    }

}
