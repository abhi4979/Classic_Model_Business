package com.springboot.main_pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Service.CustomerService;
import com.springboot.main_pkg.dto.CustomerDTO;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/add")
    public ResponseEntity<Customers> addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customers customer = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
