package org.blockchain_innovation.factom.rosetta.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountBalanceResponse;
import org.blockchain_innovation.factom.rosetta.model.AccountCoinsRequest;
import org.blockchain_innovation.factom.rosetta.model.AccountCoinsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")
@RestController
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

    public ResponseEntity<AccountBalanceResponse> accountBalance(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AccountBalanceRequest body) {
        return new ResponseEntity<AccountBalanceResponse>(accountDelegate.accountBalance(body), HttpStatus.OK);
    }

    public ResponseEntity<AccountCoinsResponse> accountCoins(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AccountCoinsRequest body) {
        return new ResponseEntity<AccountCoinsResponse>(accountDelegate.accountCoins(body), HttpStatus.OK);

    }

}
