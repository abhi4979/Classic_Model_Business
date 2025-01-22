package com.springboot.main_pkg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.main_pkg.Entity.Offices;

@RepositoryRestResource
public interface OfficeRepo extends JpaRepository<Offices, String>{
    public Offices findByOfficeCode(String officeCode);
}
