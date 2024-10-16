package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerAlreadyExistException;
import com.example.demo.exception.CustomerNotFound;
import org.springframework.stereotype.Service;


public interface CustomerService {

    void addCustomerDetails(Customer customer) throws CustomerAlreadyExistException;

    Customer getCustomerDetails(String firstName) throws CustomerNotFound;
}
