package com.springboot.main_pkg.Service;


import com.springboot.main_pkg.Entity.Employees;
import com.springboot.main_pkg.Entity.Offices;
import com.springboot.main_pkg.dto.EmployeeDTO;
import com.springboot.main_pkg.repo.EmployeeRepo;
import com.springboot.main_pkg.repo.OfficeRepo;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service

public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    
    @Autowired
    private OfficeRepo officeRepository;

    public Employees addEmployee(EmployeeDTO employeeDTO) {
        Employees employee = new Employees();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setExtension(employeeDTO.getExtension());
        employee.setEmail(employeeDTO.getEmail());
        employee.setJobTitle(employeeDTO.getJobTitle());

 
        Offices offices = officeRepository.findById(employeeDTO.getOfficeCode())
            .orElseThrow(() -> new RuntimeException("Office not found"));
        employee.setOffice(offices);

 
        if (employeeDTO.getReportsTo() != null) {
            Optional<Employees> managerOptional = employeeRepository.findById(employeeDTO.getReportsTo());
            if (managerOptional.isPresent()) {
                Employees manager = managerOptional.get();
                employee.setManager(manager);
            } else {
                throw new RuntimeException("Manager not found for ID: " + employeeDTO.getReportsTo());
            }
        } else {
            employee.setManager(null); 
        }

        employeeRepository.save(employee);
        return employee;
    }
    
  
    public List<Employees> getAllEmployees(){
 	   return employeeRepository.findAll();
    }
    
  
    public Employees getEmployee(Integer employeeNumber) {
 	   return employeeRepository.findByEmployeeNumber(employeeNumber);
    }
    
    public List<Employees> getEmployeesByOfficeCode(String officecode){
    	 Offices office = new Offices();
         office.setOfficeCode(officecode);
         return employeeRepository.findByOffice(office);
    }
    
    public List<Employees> findEmployeesByCity(String city){
    	    return  employeeRepository.findByOffice_City(city);
    }
    public Employees updateEmployee(Integer EmployeeNumber,EmployeeDTO empdto) {
    	   Employees emp= employeeRepository.findByEmployeeNumber(EmployeeNumber);
    	   if(emp==null) {
    		   throw new RuntimeException("Please provide correct EmployeeNumber");
    	   }
    	   emp.setFirstName(empdto.getFirstName());
           emp.setLastName(empdto.getLastName());
           emp.setExtension(empdto.getExtension());
           emp.setEmail(empdto.getEmail());
           emp.setJobTitle(empdto.getJobTitle());

    
           Offices offices = officeRepository.findById(empdto.getOfficeCode())
               .orElseThrow(() -> new RuntimeException("Office not found"));
           emp.setOffice(offices);

    
           if (empdto.getReportsTo() != null) {
               Optional<Employees> managerOptional = employeeRepository.findById(empdto.getReportsTo());
               if (managerOptional.isPresent()) {
                   Employees manager = managerOptional.get();
                   emp.setManager(manager);
               } else {
                   throw new RuntimeException("Manager not found for ID: " + empdto.getReportsTo());
               }
           } else {
               emp.setManager(null); 
           }

           employeeRepository.save(emp);
           return emp;
       }
   
    public Employees updateEmployeeReportingManager(Integer employeeNumber,Integer newemployeenumber) {
    	 Employees employee1=employeeRepository.findByEmployeeNumber(employeeNumber);
    	 Optional<Employees> manager=employeeRepository.findById(newemployeenumber);
    	     if(employee1!=null) {
    	    	 if(manager!=null) {
    	    		 Employees manager1=manager.get();
    	    		 employee1.setManager(manager1);
    	    		 employeeRepository.save(employee1);
    	    	 }
    	    	 else {
    	    		 throw new RuntimeException("Manager not found for ID: " +newemployeenumber);
    	    	 }
    	    	
    	     }else {
    	    	 throw new RuntimeException("Employee not found for ID: " +employeeNumber);
    	     }
    	     return employee1;
    }
    
    public Employees updateRole(Integer employeeNumber,String role) {
    	Employees emp=employeeRepository.findByEmployeeNumber(employeeNumber);
    	if(emp!=null) {
    		emp.setJobTitle(role);
    		employeeRepository.save(emp);
    	}else {
    		throw new RuntimeException("Employee not found for Id:"+employeeNumber);
    	}
    	return emp;
    }
    @Transactional
    public void updateAllRoles(String jobtitle) {
        int updatedRows = employeeRepository.updateAllEmployeesRoles(jobtitle);
        System.out.println(updatedRows + " employees updated with new role: " + jobtitle);
    }

} 