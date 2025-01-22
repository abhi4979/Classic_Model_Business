package com.springboot.main_pkg.controller;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Service.CustomerService;
import com.springboot.main_pkg.dto.CustomerDTO;

@RestController
@RequestMapping("/api/v1/customer")
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
    
    @GetMapping("/all")
    public ResponseEntity<List<Customers>> getAllCustomers(){
    	   List<Customers> customer= customerService.getAll();
    	   return ResponseEntity.ok(customer);
    }
    
    @GetMapping("/less_than/{creditlimit}")
    public ResponseEntity<List<Customers>> getLessCreditLimit(@PathVariable BigDecimal creditlimit){
    	   List<Customers> list=customerService.getLessCreditLimit(creditlimit);
    	   return ResponseEntity.ok(list);
    }
    @GetMapping("/More_than/{creditlimit}")
    public ResponseEntity<List<Customers>> getMoreCreditLimit(@PathVariable BigDecimal creditlimit){
    	   List<Customers> list=customerService.getMoreCreditLimit(creditlimit);
    	   return ResponseEntity.ok(list);
    }
    @GetMapping("/customer_firstname/{firstname}")
    public ResponseEntity<List<Customers>> getFirstName(@PathVariable String firstname){
    	List<Customers> firstnamelist=customerService.getFirstName(firstname);
    	return ResponseEntity.ok(firstnamelist);
    }
    @GetMapping("/customer_lastname/{lastname}")
    public ResponseEntity<List<Customers>> getLastName(@PathVariable String lastname){
    	List<Customers> lastnamelist=customerService.getLastName(lastname);
    	return ResponseEntity.ok(lastnamelist);
    }
    @GetMapping("/credit_range/{minlimit}/{maxlimit}")
    public ResponseEntity<List<Customers>> getBetweenLimit(@PathVariable BigDecimal minlimit,@PathVariable BigDecimal maxlimit){
    	List<Customers> range=customerService.getBetweenLimit(minlimit, maxlimit);
    	return ResponseEntity.ok(range);
    }
    @GetMapping("/postal_code/{postalcode}")
    public ResponseEntity<List<Customers>> getInfoByPostalCode(@PathVariable String postalcode){
    	List<Customers> customerinfo=customerService.getInfoByPostal(postalcode);
    	return ResponseEntity.ok(customerinfo);
    }
    @GetMapping("/office/{office_code}")
    public ResponseEntity<List<Customers>> getCustomerByOfficeCode(@PathVariable String office_code){
    	List<Customers> customerlist=customerService.getOfficeCode(office_code);
    	return ResponseEntity.ok(customerlist);
    }
    
    @PutMapping("/update/{customer_number}")
    public ResponseEntity<HashMap<String, String>> updateCustomer(@PathVariable Integer customer_number,@RequestBody CustomerDTO custdto){
    	        customerService.updateCustomer(customer_number, custdto);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    @PutMapping("/updateFirstName/{customer_number}/{contact_lastname}")
    public ResponseEntity<HashMap<String, String>> updateCustomerLastName(@PathVariable Integer customer_number,@PathVariable String contact_lastname){
    	        customerService.updateCustomerLastName(customer_number, contact_lastname);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    @PutMapping("updateLastName/{customer_number}/{contact_firstname}")
    public ResponseEntity<HashMap<String, String>> updateCustomerFirstName(@PathVariable Integer customer_number,@PathVariable String contact_firstname){
    	        customerService.updateCustomerFirstName(customer_number, contact_firstname);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    @PutMapping("updateAddress/{customer_number}")
    public ResponseEntity<HashMap<String, String>> updateCustomerAddress(@PathVariable Integer customer_number,@RequestBody CustomerDTO dto){
    	        customerService.updateCustomerAdress(customer_number, dto);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    
    
}
