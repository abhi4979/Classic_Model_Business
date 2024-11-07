package com.springboot.main_pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Employees;
import com.springboot.main_pkg.Service.EmployeeService;
import com.springboot.main_pkg.dto.EmployeeDTO;
import com.springboot.main_pkg.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
   @Autowired
   EmployeeService emp_service;
   
   
   @PostMapping("/add")
   public ResponseEntity<Employees> addEmployee(@RequestBody EmployeeDTO employee){
	  Employees emp= emp_service.addEmployee(employee);
	  return new ResponseEntity<Employees>(emp,HttpStatus.CREATED );
   }
   
   @GetMapping("/all")
   public ResponseEntity<List<Employees>> getAllEmployees(){
	   List<Employees>  employees= emp_service.getAllEmployees();
	   return ResponseEntity.ok(employees);
   }
   
   @GetMapping("/{employeeNumber}")
   public ResponseEntity<Employees> getEmployee(@PathVariable Integer employeeNumber){
	  Employees emp=emp_service.getEmployee(employeeNumber);
	  if(emp!=null) {
		  return ResponseEntity.ok(emp);
	  }else {
		  return ResponseEntity.notFound().build();
	  }
   }
   @GetMapping("/office/{officecode}")
   public ResponseEntity<List<Employees>> getEmployeeByOfficeCode(@PathVariable String officecode){
	 List<Employees> emp=emp_service.getEmployeesByOfficeCode(officecode);
	  if(emp!=null) {
		  return ResponseEntity.ok(emp);
	  }else {
		  return ResponseEntity.notFound().build();
	  }
   }
   
   @GetMapping("/city/{city}")
   public ResponseEntity<List<Employees>> getEmployeeByCity(@PathVariable String city){
	 List<Employees> emp=emp_service.findEmployeesByCity(city);
	  if(emp!=null) {
		  return ResponseEntity.ok(emp);
	  }else {
		  return ResponseEntity.notFound().build();
	  }
   }
}
