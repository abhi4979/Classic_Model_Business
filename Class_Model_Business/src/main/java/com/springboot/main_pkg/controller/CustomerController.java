package com.springboot.main_pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Service.CustomerService;
import com.springboot.main_pkg.dto.CustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customers> addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customers customer = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @GetMapping("/{customerNumber}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer customerNumber) {
    	Customers customer=customerService.getCustomerById(customerNumber);
    	if(customer!=null) {
    		return  ResponseEntity.ok(customer);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
}
