package com.example.demo.exception;

public class CustomerNotFound extends Exception {
    private String message;

    public CustomerNotFound(String message) {
        this.message = message;
    }
    public CustomerNotFound(){}
}
