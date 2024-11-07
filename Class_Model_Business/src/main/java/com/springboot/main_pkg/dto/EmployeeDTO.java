package com.springboot.main_pkg.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String jobTitle;
    private String officeCode; 
    private Integer reportsTo;
}
