package com.springboot.main_pkg.dto;

import lombok.Data;


import java.math.BigDecimal;
import lombok.Data;

@Data
public class CustomerDTO {
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalcode;
    private String country;
    private Integer salesRepEmployeeNumber; 
    private BigDecimal creditLimit;
}
