package com.springboot.main_pkg.controller;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
@CrossOrigin(origins="https://classicalmodelbusiness.netlify.app/")
@RestController
@RequestMapping("/api/v1/customer")
@Tag(name="Customer-API",description = "Update and save customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    @Operation(summary = "Add All The Customers")
    public ResponseEntity<Customers> addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customers customer = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @GetMapping("/{customerNumber}")
    @Operation(summary="Get the customer By Id", description="This end point will return the customers by their id"
    , responses= {
    		@ApiResponse(
    				responseCode ="200",
    				description="Success"
    				),
    		@ApiResponse(
    				responseCode = "500",
    				description="Internal Server Error"
    				),
    		@ApiResponse(
    				responseCode = "400",
    				description="Url not Found"
    				)
    		
    }
    )
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
    @GetMapping("/office/{officeCode}")
    public ResponseEntity<List<Customers>> getCustomerByOfficeCode(@PathVariable String officeCode){
    	List<Customers> customerlist=customerService.getOfficeCode(officeCode);
    	return ResponseEntity.ok(customerlist);
    }
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Customers>> getCustomerByCity(String city){
    	List<Customers> custlist=customerService.getCustomerCity(city);
    	return ResponseEntity.ok(custlist);
    }
    @PutMapping("/update/{customerNumber}")
    public ResponseEntity<HashMap<String, String>> updateCustomer(@PathVariable Integer customerNumber,@RequestBody CustomerDTO custdto){
    	        customerService.updateCustomer(customerNumber, custdto);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    @PutMapping("/updateLastName/{customerNumber}/{contactLastName}")
    public ResponseEntity<HashMap<String, String>> updateCustomerLastName(@PathVariable Integer customerNumber,@PathVariable String contactLastName){
    	        customerService.updateCustomerLastName(customerNumber, contactLastName);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    @PutMapping("updateFirstName/{customerNumber}/{contactFirstName}")
    public ResponseEntity<HashMap<String, String>> updateCustomerFirstName(@PathVariable Integer customerNumber,@PathVariable String contactFirstName){
    	        customerService.updateCustomerFirstName(customerNumber, contactFirstName);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
  //  @Hidden - use to hide this handler in Swagger
    @PutMapping("updateAddress/{customerNumber}")
    public ResponseEntity<HashMap<String, String>> updateCustomerAddress(@PathVariable Integer customerNumber,@RequestBody CustomerDTO dto){
    	        customerService.updateCustomerAdress(customerNumber, dto);
    	        HashMap<String, String> hash=new HashMap<>();
    	        hash.put("timestamp",LocalTime.now().toString());
    	        hash.put("message", "Customer information updated successfully");
    	        return ResponseEntity.ok(hash);
    }
    
    
    
}
