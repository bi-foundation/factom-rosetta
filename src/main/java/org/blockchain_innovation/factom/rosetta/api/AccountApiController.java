package org.blockchain_innovation.factom.rosetta.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-27T14:08:09.371Z[GMT]")
@Controller
public class AccountApiController implements AccountApi {

    private static final Logger log = LoggerFactory.getLogger(AccountApiController.class);

    private final AccountDelegate accountDelegate;
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountApiController(AccountDelegate accountDelegate, ObjectMapper objectMapper, HttpServletRequest request) {
        this.accountDelegate = accountDelegate;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountBalanceResponse> accountBalance(@ApiParam(value = "", required = true) @Valid @RequestBody AccountBalanceRequest body) {
//        body.getNetworkIdentifier()
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AccountBalanceResponse>(objectMapper.readValue("{\n  \"balances\" : [ {\n    \"metadata\" : { },\n    \"currency\" : {\n      \"symbol\" : \"BTC\",\n      \"metadata\" : {\n        \"Issuer\" : \"Satoshi\"\n      },\n      \"decimals\" : 8\n    },\n    \"value\" : \"1238089899992\"\n  }, {\n    \"metadata\" : { },\n    \"currency\" : {\n      \"symbol\" : \"BTC\",\n      \"metadata\" : {\n        \"Issuer\" : \"Satoshi\"\n      },\n      \"decimals\" : 8\n    },\n    \"value\" : \"1238089899992\"\n  } ],\n  \"metadata\" : {\n    \"sequence_number\" : 23\n  },\n  \"block_identifier\" : {\n    \"index\" : 1123941,\n    \"hash\" : \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\n  }\n}", AccountBalanceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AccountBalanceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AccountBalanceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
