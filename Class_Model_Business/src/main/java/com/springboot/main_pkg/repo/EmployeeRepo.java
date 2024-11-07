package com.springboot.main_pkg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main_pkg.Entity.Employees;
import com.springboot.main_pkg.Entity.Offices;


public interface EmployeeRepo extends JpaRepository<Employees, Integer>{

	public Employees findByEmployeeNumber(Integer employeeNumber);
    
	public List<Employees> findByOffice(Offices office);
	
  
    public List<Employees> findByOffice_City(String city);
}
