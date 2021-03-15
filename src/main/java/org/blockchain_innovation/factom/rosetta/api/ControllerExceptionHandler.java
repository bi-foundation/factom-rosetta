package org.blockchain_innovation.factom.rosetta.api;

import lombok.extern.slf4j.Slf4j;
import org.blockchain_innovation.factom.rosetta.api.factom.client.RosettaExceptions;
import org.blockchain_innovation.factom.rosetta.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Error resourceNotFoundException(Exception ex, WebRequest request) {
        log.error("{}, request: {}", ex.getMessage(), request.getDescription(true), ex);
        final Error message = new Error().code(500).message(ex.getMessage()).description(ex.getMessage()).retriable(true);

        return message;
    }
}