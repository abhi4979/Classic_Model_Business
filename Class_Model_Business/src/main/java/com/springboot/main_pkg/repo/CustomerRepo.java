package com.springboot.main_pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.main_pkg.Entity.Customers;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customers, Integer>{
      public Customers findByCustomerNumber(Integer customerNumber);
}
