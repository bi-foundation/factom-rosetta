package org.blockchain_innovation.factom.rosetta.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.blockchain_innovation.factom.rosetta.model.ConstructionCombineRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionCombineResponse;
import org.blockchain_innovation.factom.rosetta.model.ConstructionDeriveRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionDeriveResponse;
import org.blockchain_innovation.factom.rosetta.model.ConstructionHashRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionMetadataRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionMetadataResponse;
import org.blockchain_innovation.factom.rosetta.model.ConstructionParseRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionParseResponse;
import org.blockchain_innovation.factom.rosetta.model.ConstructionPayloadsRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionPayloadsResponse;
import org.blockchain_innovation.factom.rosetta.model.ConstructionPreprocessRequest;
import org.blockchain_innovation.factom.rosetta.model.ConstructionPreprocessResponse;
import org.blockchain_innovation.factom.rosetta.model.ConstructionSubmitRequest;
import org.blockchain_innovation.factom.rosetta.model.TransactionIdentifierResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")
@RestController
public class ConstructionApiController implements ConstructionApi {

    private static final Logger log = LoggerFactory.getLogger(ConstructionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConstructionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ConstructionCombineResponse> constructionCombine(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionCombineRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConstructionCombineResponse>(objectMapper.readValue("{\n  \"signed_transaction\" : \"signed_transaction\"\n}", ConstructionCombineResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConstructionCombineResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConstructionCombineResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConstructionDeriveResponse> constructionDerive(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionDeriveRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConstructionDeriveResponse>(objectMapper.readValue("{\n  \"metadata\" : { },\n  \"address\" : \"address\",\n  \"account_identifier\" : {\n    \"metadata\" : { },\n    \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n    \"sub_account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n    }\n  }\n}", ConstructionDeriveResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConstructionDeriveResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConstructionDeriveResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TransactionIdentifierResponse> constructionHash(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionHashRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TransactionIdentifierResponse>(objectMapper.readValue("{\n  \"metadata\" : { },\n  \"transaction_identifier\" : {\n    \"hash\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f\"\n  }\n}", TransactionIdentifierResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TransactionIdentifierResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TransactionIdentifierResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConstructionMetadataResponse> constructionMetadata(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionMetadataRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConstructionMetadataResponse>(objectMapper.readValue("{\n  \"metadata\" : {\n    \"account_sequence\" : 23,\n    \"recent_block_hash\" : \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"\n  },\n  \"suggested_fee\" : [ {\n    \"metadata\" : { },\n    \"currency\" : {\n      \"symbol\" : \"BTC\",\n      \"metadata\" : {\n        \"Issuer\" : \"Satoshi\"\n      },\n      \"decimals\" : 8\n    },\n    \"value\" : \"1238089899992\"\n  }, {\n    \"metadata\" : { },\n    \"currency\" : {\n      \"symbol\" : \"BTC\",\n      \"metadata\" : {\n        \"Issuer\" : \"Satoshi\"\n      },\n      \"decimals\" : 8\n    },\n    \"value\" : \"1238089899992\"\n  } ]\n}", ConstructionMetadataResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConstructionMetadataResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConstructionMetadataResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConstructionParseResponse> constructionParse(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionParseRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConstructionParseResponse>(objectMapper.readValue("{\n  \"signers\" : [ \"signers\", \"signers\" ],\n  \"metadata\" : { },\n  \"operations\" : [ {\n    \"amount\" : {\n      \"metadata\" : { },\n      \"currency\" : {\n        \"symbol\" : \"BTC\",\n        \"metadata\" : {\n          \"Issuer\" : \"Satoshi\"\n        },\n        \"decimals\" : 8\n      },\n      \"value\" : \"1238089899992\"\n    },\n    \"metadata\" : {\n      \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n      \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n    },\n    \"related_operations\" : [ {\n      \"index\" : 1\n    }, {\n      \"index\" : 2\n    } ],\n    \"type\" : \"Transfer\",\n    \"coin_change\" : {\n      \"coin_identifier\" : {\n        \"identifier\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f:1\"\n      },\n      \"coin_action\" : \"coin_created\"\n    },\n    \"account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n      \"sub_account\" : {\n        \"metadata\" : { },\n        \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n      }\n    },\n    \"operation_identifier\" : {\n      \"index\" : 5,\n      \"network_index\" : 0\n    },\n    \"status\" : \"Reverted\"\n  }, {\n    \"amount\" : {\n      \"metadata\" : { },\n      \"currency\" : {\n        \"symbol\" : \"BTC\",\n        \"metadata\" : {\n          \"Issuer\" : \"Satoshi\"\n        },\n        \"decimals\" : 8\n      },\n      \"value\" : \"1238089899992\"\n    },\n    \"metadata\" : {\n      \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n      \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n    },\n    \"related_operations\" : [ {\n      \"index\" : 1\n    }, {\n      \"index\" : 2\n    } ],\n    \"type\" : \"Transfer\",\n    \"coin_change\" : {\n      \"coin_identifier\" : {\n        \"identifier\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f:1\"\n      },\n      \"coin_action\" : \"coin_created\"\n    },\n    \"account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n      \"sub_account\" : {\n        \"metadata\" : { },\n        \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n      }\n    },\n    \"operation_identifier\" : {\n      \"index\" : 5,\n      \"network_index\" : 0\n    },\n    \"status\" : \"Reverted\"\n  } ],\n  \"account_identifier_signers\" : [ {\n    \"metadata\" : { },\n    \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n    \"sub_account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n    }\n  }, {\n    \"metadata\" : { },\n    \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n    \"sub_account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n    }\n  } ]\n}", ConstructionParseResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConstructionParseResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConstructionParseResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConstructionPayloadsResponse> constructionPayloads(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionPayloadsRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConstructionPayloadsResponse>(objectMapper.readValue("{\n  \"unsigned_transaction\" : \"unsigned_transaction\",\n  \"payloads\" : [ {\n    \"address\" : \"address\",\n    \"account_identifier\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n      \"sub_account\" : {\n        \"metadata\" : { },\n        \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n      }\n    },\n    \"hex_bytes\" : \"hex_bytes\",\n    \"signature_type\" : \"ecdsa\"\n  }, {\n    \"address\" : \"address\",\n    \"account_identifier\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n      \"sub_account\" : {\n        \"metadata\" : { },\n        \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n      }\n    },\n    \"hex_bytes\" : \"hex_bytes\",\n    \"signature_type\" : \"ecdsa\"\n  } ]\n}", ConstructionPayloadsResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConstructionPayloadsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConstructionPayloadsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConstructionPreprocessResponse> constructionPreprocess(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionPreprocessRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConstructionPreprocessResponse>(objectMapper.readValue("{\n  \"options\" : { },\n  \"required_public_keys\" : [ {\n    \"metadata\" : { },\n    \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n    \"sub_account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n    }\n  }, {\n    \"metadata\" : { },\n    \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n    \"sub_account\" : {\n      \"metadata\" : { },\n      \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n    }\n  } ]\n}", ConstructionPreprocessResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConstructionPreprocessResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConstructionPreprocessResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TransactionIdentifierResponse> constructionSubmit(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ConstructionSubmitRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TransactionIdentifierResponse>(objectMapper.readValue("{\n  \"metadata\" : { },\n  \"transaction_identifier\" : {\n    \"hash\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f\"\n  }\n}", TransactionIdentifierResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TransactionIdentifierResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TransactionIdentifierResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
