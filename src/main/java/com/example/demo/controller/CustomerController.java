package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerAlreadyExistException;
import com.example.demo.exception.CustomerNotFound;
import com.example.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity saveCustomerDetails(@RequestBody Customer customer) throws CustomerAlreadyExistException {
        customerService.addCustomerDetails(customer);
        return new ResponseEntity("Customer created", HttpStatus.CREATED);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable("firstName") String firstName) throws CustomerNotFound {

        logger.info("Getting Customer with name {}", firstName);
        return new ResponseEntity<>(customerService.getCustomerDetails(firstName), HttpStatus.OK);
    }
}
