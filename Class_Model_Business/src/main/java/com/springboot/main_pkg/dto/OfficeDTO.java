package com.springboot.main_pkg.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OfficeDTO {
	 private String officeCode;
	     private String city;
		  private String phone;
		
	     private String addressLine1;
		
	     private String addressLine2;
	
	     private String state;
	
	     private String country;
	
	     private String postalCode;
	     private String territory;
}
