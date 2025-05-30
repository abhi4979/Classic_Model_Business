package com.springboot.main_pkg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.main_pkg.Entity.Employees;
import com.springboot.main_pkg.Entity.Offices;


public interface EmployeeRepo extends JpaRepository<Employees, Integer>{

	public Employees findByEmployeeNumber(Integer employeeNumber);
    
	public List<Employees> findByOffice(Offices office);
	
  
    public List<Employees> findByOffice_City(String city);
    @Modifying
    @Query(value = "UPDATE employees SET job_title = :jobtitle", nativeQuery = true)
    int updateAllEmployeesRoles(@Param("jobtitle") String jobtitle);

    public void deleteByEmployeeNumber(int employeeNumber);
    
    
    
    @Modifying
    @Query("UPDATE Employees e SET e.manager = null WHERE e.manager.employeeNumber = :empNo")
    void detachManagerFromEmployees(@Param("empNo") Integer empNo);
}
