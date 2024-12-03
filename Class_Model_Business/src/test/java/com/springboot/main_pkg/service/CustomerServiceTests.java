package com.springboot.main_pkg.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Service.CustomerService;
import com.springboot.main_pkg.repo.CustomerRepo;


public class CustomerServiceTests {
      @InjectMocks
      private CustomerService customerservice;
      
      @Mock
      private CustomerRepo customerrepository;
      
      @BeforeEach
      void setUp() {
    	  MockitoAnnotations.initMocks(this);
      }
      @Test
      void getCustomerByIdTest() {
    	  when(customerrepository.findByCustomerNumber(ArgumentMatchers.anyInt())).thenReturn(Customers.builder().contactFirstName("Abhisek").contactLastName("Pradhan").build());
         Customers customer=customerservice.getCustomerById(5);
         Assertions.assertNotNull(customer);
      }
}
