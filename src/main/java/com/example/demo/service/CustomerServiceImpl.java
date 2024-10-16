package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerAlreadyExistException;
import com.example.demo.exception.CustomerNotFound;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addCustomerDetails(Customer customer) throws CustomerAlreadyExistException {
        if(customerRepository.getCustomerByFirstName(customer.getFirstName()) != null){
            throw new CustomerAlreadyExistException();
        }
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerDetails(String firstName) throws CustomerNotFound {
        if(customerRepository.getCustomerByFirstName(firstName) == null){
            throw new CustomerNotFound();
        }
        return customerRepository.getCustomerByFirstName(firstName);
    }
}
