package com.springboot.main_pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.main_pkg.Entity.ProductLines;

@RepositoryRestResource
public interface Product_Lines_Repo extends JpaRepository<ProductLines, String>{

}
