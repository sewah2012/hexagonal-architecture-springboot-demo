package com.demotest.demo.infrastructure.exceptions.errors;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message){
        super(message);
    }
}
