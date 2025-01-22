package com.springboot.main_pkg.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Entity.Employees;
import com.springboot.main_pkg.Entity.Offices;
import com.springboot.main_pkg.dto.CustomerDTO;
import com.springboot.main_pkg.repo.CustomerRepo;
import com.springboot.main_pkg.repo.EmployeeRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Customers addCustomer(CustomerDTO customerDTO) {
        Customers customer = new Customers();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setContactLastName(customerDTO.getContactLastName());
        customer.setContactFirstName(customerDTO.getContactFirstName());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddressLine1(customerDTO.getAddressLine1());
        customer.setAddressLine2(customerDTO.getAddressLine2());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());
        customer.setPostalcode(customerDTO.getPostalcode());
        customer.setCountry(customerDTO.getCountry());
        customer.setCreditLimit(customerDTO.getCreditLimit());

        
        if (customerDTO.getSalesRepEmployeeNumber() != null) {
            Employees salesRep = employeeRepo.findById(customerDTO.getSalesRepEmployeeNumber())
                    .orElseThrow(() -> new RuntimeException("Sales Representative not found"));
            customer.setSalesRepEmployeeNumber(salesRep);
        }

        
        return customerRepo.save(customer);
    }
    public Customers getCustomerById(Integer customerNumber ) {
    	return customerRepo.findByCustomerNumber(customerNumber);
    }
    public List<Customers> getAll(){
    	 return customerRepo.findAll();
    }
    
    public List<Customers> getLessCreditLimit(BigDecimal creditLimit){
    	List<Customers> cusm=customerRepo.findAll();
    	return cusm.stream().filter(x->x.getCreditLimit().compareTo(creditLimit)<0).collect(Collectors.toList());
    }
    public List<Customers> getMoreCreditLimit(BigDecimal creditLimit){
    	List<Customers> cusm=customerRepo.findAll();
    	return cusm.stream().filter(x->x.getCreditLimit().compareTo(creditLimit)> 0).toList();
    }
    
    public List<Customers> getFirstName(String firstname){
    	return customerRepo.findByContactFirstName(firstname);
    }
    public List<Customers> getLastName(String firstname){
    	return customerRepo.findByContactLastName(firstname);
    }
    public List<Customers> getBetweenLimit(BigDecimal minlimit,BigDecimal maxlimit){
    	return customerRepo.getCreditLimit(minlimit, maxlimit);
    }
    public List<Customers> getInfoByPostal(String postalcode){
    	return customerRepo.findByPostalcode(postalcode);
    }
    
    public List<Customers> getOfficeCode(String office_code){
    	return customerRepo.findCustomersByOfficeCode(office_code);
    }
    
    public Customers updateCustomer(Integer customerid,CustomerDTO customerDTO) {
    	   Customers customer=customerRepo.findByCustomerNumber(customerid);
    	   if(customer!=null) {
    		   
    		   customer.setCustomerName(customerDTO.getCustomerName());
    	        customer.setContactLastName(customerDTO.getContactLastName());
    	        customer.setContactFirstName(customerDTO.getContactFirstName());
    	        customer.setPhone(customerDTO.getPhone());
    	        customer.setAddressLine1(customerDTO.getAddressLine1());
    	        customer.setAddressLine2(customerDTO.getAddressLine2());
    	        customer.setCity(customerDTO.getCity());
    	        customer.setState(customerDTO.getState());
    	        customer.setPostalcode(customerDTO.getPostalcode());
    	        customer.setCountry(customerDTO.getCountry());
    	        customer.setCreditLimit(customerDTO.getCreditLimit());

    	        
    	        if (customerDTO.getSalesRepEmployeeNumber() != null) {
    	            Employees salesRep = employeeRepo.findById(customerDTO.getSalesRepEmployeeNumber())
    	                    .orElseThrow(() -> new RuntimeException("Sales Representative not found"));
    	            customer.setSalesRepEmployeeNumber(salesRep);
    	        }
    	        customerRepo.save(customer);
    	   }else {
    		   throw new IllegalArgumentException("Customer not found for id :"+customerid);
    	   }
    	        
    	  return customer;
    }
    public Customers updateCustomerLastName(Integer customerid,String lastname) {
    	    Customers customerinfo=customerRepo.findByCustomerNumber(customerid);
    	    if(customerinfo!=null) {
    	    	customerinfo.setContactLastName(lastname);
    	    	customerRepo.save(customerinfo);
    	    } else {
	    		 throw new IllegalArgumentException("Customer not found for ID: " +customerid);
	    	 }
    	    return customerinfo;
    }
    public Customers updateCustomerFirstName(Integer customerid,String firstname) {
	    Customers customerinfo=customerRepo.findByCustomerNumber(customerid);
	    if(customerinfo!=null) {
	    	customerinfo.setContactFirstName(firstname);
	    	customerRepo.save(customerinfo);
	    } else {
    		 throw new IllegalArgumentException("Customer not found for ID: " +customerid);
    	 }
	    return customerinfo;
}
    public Customers updateCustomerAdress(Integer customerid,CustomerDTO dto) {
	    Customers customerinfo=customerRepo.findByCustomerNumber(customerid);
	    if(customerinfo!=null) {
	    	customerinfo.setAddressLine1(dto.getAddressLine1());
	    	customerinfo.setAddressLine2(dto.getAddressLine2());
	    	customerRepo.save(customerinfo);
	    } else {
    		 throw new IllegalArgumentException("Customer not found for ID: " +customerid);
    	 }
	    return customerinfo;
}
    
    
}

