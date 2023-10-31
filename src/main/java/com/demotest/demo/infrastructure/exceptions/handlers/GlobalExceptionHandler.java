package com.demotest.demo.infrastructure.exceptions.handlers;

import com.demotest.demo.infrastructure.exceptions.errors.PriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public static final String DEAULT_INTERAL_SERVER_ERROR_MESSAGE = ErrorMessages.DEFAULT_INTERNAL_SERVER_ERROR;

    @ExceptionHandler({Exception.class, Throwable.class })
    public ResponseEntity<Object> internalExceptionHandler(Exception ex){
        log.error(ex.getLocalizedMessage(), ex);

        return buildErrorResponse(
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : DEAULT_INTERAL_SERVER_ERROR_MESSAGE,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> accountAlreadyExistsExceptionHandler(Exception ex){
        log.error(ex.getLocalizedMessage(), ex);
        return buildErrorResponse(
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : DEAULT_INTERAL_SERVER_ERROR_MESSAGE, HttpStatus.NOT_FOUND
        );
    }



    private ResponseEntity<Object> buildErrorResponse(String message, HttpStatus status){
        return ResponseEntity.status(status).body(new ExceptionResponse(message, status));
    }
}
