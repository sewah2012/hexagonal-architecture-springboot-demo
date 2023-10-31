package com.demotest.demo.infrastructure.exceptions.handlers;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        String message,
        HttpStatus status
) {
}
