package com.springboot.main_pkg.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Entity.Employees;
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
}
