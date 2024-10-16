package com.example.demo.exception;

public class CustomerAlreadyExistException extends RuntimeException {
    private String message;

    public CustomerAlreadyExistException(String message){
        super(message);
        this.message = message;
    }
    public CustomerAlreadyExistException(){}
}
