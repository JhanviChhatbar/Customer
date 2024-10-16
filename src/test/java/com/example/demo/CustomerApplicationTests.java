package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerAlreadyExistException;
import com.example.demo.exception.CustomerNotFound;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@SpringBootTest
class CustomerApplicationTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

		customer = new Customer();
		customer.setFirstName("Jhanvi");
		customer.setLastName("Chhatbar");
    }


    @Test
    void addCustomerDetails_WhenCustomerDoesNotExist_ShouldSaveCustomer() throws CustomerAlreadyExistException {
        when(customerRepository.getCustomerByFirstName(customer.getFirstName())).thenReturn(null);
        customerService.addCustomerDetails(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void addCustomerDetails_WhenCustomerAlreadyExists_ShouldThrowException() {
        when(customerRepository.getCustomerByFirstName(customer.getFirstName())).thenReturn(customer);
        Assertions.assertThrows(CustomerAlreadyExistException.class, () -> {
            customerService.addCustomerDetails(customer);
        });
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void getCustomerDetails_WhenCustomerDoesNotExist_ShouldThrowException() {
        when(customerRepository.getCustomerByFirstName(customer.getFirstName())).thenReturn(null);
        Assertions.assertThrows(CustomerNotFound.class, () -> {
            customerService.getCustomerDetails(customer.getFirstName());
        });
        verify(customerRepository, times(1)).getCustomerByFirstName(customer.getFirstName());
    }


}
