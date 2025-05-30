package com.springboot.main_pkg.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.main_pkg.Entity.Customers;
import com.springboot.main_pkg.Entity.Employees;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customers, Integer>{
      public Customers findByCustomerNumber(Integer customerNumber);
      public List<Customers> findByContactFirstName(String contactFirstName);
      public List<Customers> findByContactLastName(String contactLastName);
      
      public List<Customers> findByCity(String city);
     public List<Customers> findBySalesRepEmployeeNumber_EmployeeNumber(Integer employeeNumber);

      
      @Query("select c from Customers c where c.creditLimit between :minlimit and :maxlimit")
       List<Customers> getCreditLimit(
    	  @Param("minlimit") BigDecimal  minlimit,
    	  @Param("maxlimit") BigDecimal maxlimit
    	  );
      public List<Customers> findByPostalcode(String postalcode);
      
      @Query("SELECT c FROM Customers c " +
    	       "JOIN c.salesRepEmployeeNumber e " +
    	       "JOIN e.office o " +
    	       "WHERE o.officeCode = :officeCode")
    	List<Customers> findCustomersByOfficeCode(@Param("officeCode") String officeCode);
      
      
    

      @Modifying
      @Query("UPDATE Customers c SET c.salesRepEmployeeNumber = null WHERE c.salesRepEmployeeNumber.employeeNumber = :empNo")
      void detachSalesRepFromCustomers(@Param("empNo") Integer empNo);

}
