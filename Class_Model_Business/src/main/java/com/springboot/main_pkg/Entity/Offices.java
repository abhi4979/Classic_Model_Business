package com.springboot.main_pkg.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Offices {
	@Id
	@Column(length=10)
     private String officeCode;
	@Column(length=50)
     private String city;
	@Column(length=50)
     private String phone;
	@Column(length=50)
     private String addressLine1;
	@Column(length=50)
     private String addressLine2;
	@Column(length=50)
     private String state;
	@Column(length=50)
     private String country;
	@Column(length=15)
     private String postalCode;
	@Column(length=10)
     private String territory;
     
}
