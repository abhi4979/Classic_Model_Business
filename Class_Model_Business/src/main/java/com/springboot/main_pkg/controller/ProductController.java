package com.springboot.main_pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Products;
import com.springboot.main_pkg.Service.ProductService;
import com.springboot.main_pkg.dto.ProductDTO;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name="Product API")
public class ProductController {
     
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	public ResponseEntity<Products> addProduct(@RequestBody ProductDTO dto){
		Products pr=service.addProduct(dto);
		return new ResponseEntity<Products>(pr,HttpStatus.CREATED);
	}
	
}
