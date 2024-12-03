package com.springboot.main_pkg.controller;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
   
   @PutMapping("/{employeeNumber}/reports to/{newemployeenumber}")
   public ResponseEntity<Employees> updateEmployeeReportingManager(@PathVariable Integer employeeNumber,@PathVariable Integer newemployeenumber){
	      Employees emp=emp_service.updateEmployeeReportingManager(employeeNumber, newemployeenumber);
	      if(emp!=null) {
	    	  return ResponseEntity.ok(emp);
	      }else {
	    	  return ResponseEntity.notFound().build();
	      }
   }
   @PutMapping("/update/{employeeNumber}")
   public ResponseEntity<Employees> updateEmployee(@PathVariable Integer employeeNumber,@RequestBody EmployeeDTO empdto){
	      Employees emp=emp_service.updateEmployee(employeeNumber,empdto);
	      if(emp!=null) {
	    	  return ResponseEntity.ok(emp);
	      }else {
	    	  return ResponseEntity.notFound().build();
	      }
}
   @PutMapping("/update/role/{role}")
   public ResponseEntity<Map<String,String>> updateRole(@PathVariable String role){
	        emp_service.updateAllRoles(role);
	      Map<String,String> mp=new HashMap<>();
	      mp.put("timestamp", LocalTime.now().toString());
	      mp.put("message","Employee Role Updated Successfully");
	      return ResponseEntity.ok(mp);
   }
   
   
   
}
