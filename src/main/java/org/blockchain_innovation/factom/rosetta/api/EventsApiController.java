package org.blockchain_innovation.factom.rosetta.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.blockchain_innovation.factom.rosetta.model.EventsBlocksRequest;
import org.blockchain_innovation.factom.rosetta.model.EventsBlocksResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-11T02:27:54.801Z[GMT]")
@RestController
public class EventsApiController implements EventsApi {

    private static final Logger log = LoggerFactory.getLogger(EventsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EventsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<EventsBlocksResponse> eventsBlocks(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody EventsBlocksRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EventsBlocksResponse>(objectMapper.readValue("{\n  \"max_sequence\" : 5,\n  \"events\" : [ {\n    \"sequence\" : 5,\n    \"type\" : \"block_added\",\n    \"block_identifier\" : {\n      \"index\" : 1123941,\n      \"hash\" : \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\n    }\n  }, {\n    \"sequence\" : 5,\n    \"type\" : \"block_added\",\n    \"block_identifier\" : {\n      \"index\" : 1123941,\n      \"hash\" : \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\n    }\n  } ]\n}", EventsBlocksResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EventsBlocksResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EventsBlocksResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
