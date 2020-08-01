package org.blockchain_innovation.factom.rosetta.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public AccountApiController(AccountDelegate accountDelegate, ObjectMapper objectMapper, HttpServletRequest request) {
        this.accountDelegate = accountDelegate;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountBalanceResponse> accountBalance(@ApiParam(value = "", required = true) @Valid @RequestBody AccountBalanceRequest body) {
        return new ResponseEntity<AccountBalanceResponse>(accountDelegate.accountBalance(body), HttpStatus.OK);
    }

}
