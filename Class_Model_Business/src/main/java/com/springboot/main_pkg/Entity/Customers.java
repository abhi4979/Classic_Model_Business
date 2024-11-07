package com.springboot.main_pkg.Entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerNumber;

    @Column(name = "customername", length = 50, nullable = false)
    private String customerName;

    @Column(length = 50, nullable = false)
    private String contactLastName;

    @Column(length = 50, nullable = false)
    private String contactFirstName;

    @Column(length = 50, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String addressLine1;

    @Column(length = 50)
    private String addressLine2;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 50)
    private String postalcode;

    @Column(length = 50, nullable = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "sales_rep_employee_number", nullable = true) 
    private Employees salesRepEmployeeNumber;

    @OneToMany(mappedBy = "customer") 
    private List<Orders> orders;

    @OneToMany(mappedBy = "customer") 
    private List<Payments> payments;

    @Column(precision = 10, scale = 2)
    private BigDecimal creditLimit;
}
