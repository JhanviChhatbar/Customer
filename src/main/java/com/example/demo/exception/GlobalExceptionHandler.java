package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity handleCustomerAlreadyExist(CustomerAlreadyExistException cae){
        return new ResponseEntity("Customer Already Exist for given Name", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity handleCustomerNotFound(){
        return new ResponseEntity("Customer Not Found", HttpStatus.NOT_FOUND);
    }
}
