package org.blockchain_innovation.factom.rosetta.api;

import org.blockchain_innovation.factom.rosetta.model.BlockRequest;
import org.blockchain_innovation.factom.rosetta.model.BlockResponse;
import org.blockchain_innovation.factom.rosetta.model.BlockTransactionRequest;
import org.blockchain_innovation.factom.rosetta.model.BlockTransactionResponse;
import org.blockchain_innovation.factom.rosetta.model.Error;
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
public class BlockApiController implements BlockApi {

    private static final Logger log = LoggerFactory.getLogger(BlockApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BlockApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BlockResponse> block(@ApiParam(value = "" ,required=true )  @Valid @RequestBody BlockRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BlockResponse>(objectMapper.readValue("{\n  \"block\" : {\n    \"metadata\" : {\n      \"transactions_root\" : \"0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347\",\n      \"difficulty\" : \"123891724987128947\"\n    },\n    \"transactions\" : [ {\n      \"metadata\" : {\n        \"size\" : 12378,\n        \"lockTime\" : 1582272577\n      },\n      \"operations\" : [ {\n        \"amount\" : {\n          \"metadata\" : { },\n          \"currency\" : {\n            \"symbol\" : \"BTC\",\n            \"metadata\" : {\n              \"Issuer\" : \"Satoshi\"\n            },\n            \"decimals\" : 8\n          },\n          \"value\" : \"1238089899992\"\n        },\n        \"metadata\" : {\n          \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n          \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n        },\n        \"related_operations\" : [ {\n          \"index\" : 0,\n          \"operation_identifier\" : {\n            \"index\" : 0\n          }\n        } ],\n        \"type\" : \"Transfer\",\n        \"account\" : {\n          \"metadata\" : { },\n          \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n          \"sub_account\" : {\n            \"metadata\" : { },\n            \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n          }\n        },\n        \"operation_identifier\" : {\n          \"index\" : 1,\n          \"network_index\" : 0\n        },\n        \"status\" : \"Reverted\"\n      }, {\n        \"amount\" : {\n          \"metadata\" : { },\n          \"currency\" : {\n            \"symbol\" : \"BTC\",\n            \"metadata\" : {\n              \"Issuer\" : \"Satoshi\"\n            },\n            \"decimals\" : 8\n          },\n          \"value\" : \"1238089899992\"\n        },\n        \"metadata\" : {\n          \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n          \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n        },\n        \"related_operations\" : [ {\n          \"index\" : 0,\n          \"operation_identifier\" : {\n            \"index\" : 0\n          }\n        } ],\n        \"type\" : \"Transfer\",\n        \"account\" : {\n          \"metadata\" : { },\n          \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n          \"sub_account\" : {\n            \"metadata\" : { },\n            \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n          }\n        },\n        \"operation_identifier\" : {\n          \"index\" : 1,\n          \"network_index\" : 0\n        },\n        \"status\" : \"Reverted\"\n      } ],\n      \"transaction_identifier\" : {\n        \"hash\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f\"\n      }\n    }, {\n      \"metadata\" : {\n        \"size\" : 12378,\n        \"lockTime\" : 1582272577\n      },\n      \"operations\" : [ {\n        \"amount\" : {\n          \"metadata\" : { },\n          \"currency\" : {\n            \"symbol\" : \"BTC\",\n            \"metadata\" : {\n              \"Issuer\" : \"Satoshi\"\n            },\n            \"decimals\" : 8\n          },\n          \"value\" : \"1238089899992\"\n        },\n        \"metadata\" : {\n          \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n          \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n        },\n        \"related_operations\" : [ {\n          \"index\" : 0,\n          \"operation_identifier\" : {\n            \"index\" : 0\n          }\n        } ],\n        \"type\" : \"Transfer\",\n        \"account\" : {\n          \"metadata\" : { },\n          \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n          \"sub_account\" : {\n            \"metadata\" : { },\n            \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n          }\n        },\n        \"operation_identifier\" : {\n          \"index\" : 1,\n          \"network_index\" : 0\n        },\n        \"status\" : \"Reverted\"\n      }, {\n        \"amount\" : {\n          \"metadata\" : { },\n          \"currency\" : {\n            \"symbol\" : \"BTC\",\n            \"metadata\" : {\n              \"Issuer\" : \"Satoshi\"\n            },\n            \"decimals\" : 8\n          },\n          \"value\" : \"1238089899992\"\n        },\n        \"metadata\" : {\n          \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n          \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n        },\n        \"related_operations\" : [ {\n          \"index\" : 0,\n          \"operation_identifier\" : {\n            \"index\" : 0\n          }\n        } ],\n        \"type\" : \"Transfer\",\n        \"account\" : {\n          \"metadata\" : { },\n          \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n          \"sub_account\" : {\n            \"metadata\" : { },\n            \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n          }\n        },\n        \"operation_identifier\" : {\n          \"index\" : 1,\n          \"network_index\" : 0\n        },\n        \"status\" : \"Reverted\"\n      } ],\n      \"transaction_identifier\" : {\n        \"hash\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f\"\n      }\n    } ],\n    \"block_identifier\" : {\n      \"index\" : 1123941,\n      \"hash\" : \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\n    },\n    \"timestamp\" : 1582833600000\n  },\n  \"other_transactions\" : [ null, null ]\n}", BlockResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BlockResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BlockResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BlockTransactionResponse> blockTransaction(@ApiParam(value = "" ,required=true )  @Valid @RequestBody BlockTransactionRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BlockTransactionResponse>(objectMapper.readValue("{\n  \"transaction\" : {\n    \"metadata\" : {\n      \"size\" : 12378,\n      \"lockTime\" : 1582272577\n    },\n    \"operations\" : [ {\n      \"amount\" : {\n        \"metadata\" : { },\n        \"currency\" : {\n          \"symbol\" : \"BTC\",\n          \"metadata\" : {\n            \"Issuer\" : \"Satoshi\"\n          },\n          \"decimals\" : 8\n        },\n        \"value\" : \"1238089899992\"\n      },\n      \"metadata\" : {\n        \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n        \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n      },\n      \"related_operations\" : [ {\n        \"index\" : 0,\n        \"operation_identifier\" : {\n          \"index\" : 0\n        }\n      } ],\n      \"type\" : \"Transfer\",\n      \"account\" : {\n        \"metadata\" : { },\n        \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n        \"sub_account\" : {\n          \"metadata\" : { },\n          \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n        }\n      },\n      \"operation_identifier\" : {\n        \"index\" : 1,\n        \"network_index\" : 0\n      },\n      \"status\" : \"Reverted\"\n    }, {\n      \"amount\" : {\n        \"metadata\" : { },\n        \"currency\" : {\n          \"symbol\" : \"BTC\",\n          \"metadata\" : {\n            \"Issuer\" : \"Satoshi\"\n          },\n          \"decimals\" : 8\n        },\n        \"value\" : \"1238089899992\"\n      },\n      \"metadata\" : {\n        \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\n        \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"\n      },\n      \"related_operations\" : [ {\n        \"index\" : 0,\n        \"operation_identifier\" : {\n          \"index\" : 0\n        }\n      } ],\n      \"type\" : \"Transfer\",\n      \"account\" : {\n        \"metadata\" : { },\n        \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\",\n        \"sub_account\" : {\n          \"metadata\" : { },\n          \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\"\n        }\n      },\n      \"operation_identifier\" : {\n        \"index\" : 1,\n        \"network_index\" : 0\n      },\n      \"status\" : \"Reverted\"\n    } ],\n    \"transaction_identifier\" : {\n      \"hash\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f\"\n    }\n  }\n}", BlockTransactionResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BlockTransactionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BlockTransactionResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
