package com.springboot.main_pkg.Entity;

import java.time.LocalDate;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employees {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int employeeNumber;
	@Column(length=50)
   private String lastName;
	@Column(length=50,nullable=false)
   private String firstName;
	@Column(length=10,nullable=false)
   private String extension;
	@Column(length=100,nullable=false)
   private String email;
	@ManyToOne
	@JoinColumn(name="office_code",nullable=false)
	private Offices office;
	@ManyToOne
	@JoinColumn(name="Manager_Id",nullable=true)
   private Employees manager;
   @Column(length=50,nullable=false)
   private String jobTitle;
}
