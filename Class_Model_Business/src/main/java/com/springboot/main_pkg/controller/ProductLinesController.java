package com.springboot.main_pkg.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.ProductLines;
import com.springboot.main_pkg.Service.Product_Lines_Service;
import com.springboot.main_pkg.dto.ProductLinesDTO;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/productlines")
@Tag(name="ProductLines API")
public class ProductLinesController {
	   @Autowired
	   private Product_Lines_Service service;
	   
	   @PostMapping("/add")
       public ResponseEntity<ProductLines> addProductLines(@RequestBody ProductLinesDTO dto) throws IOException{
    	        ProductLines pr=service.addProductLines(dto);
    	        return new ResponseEntity<>(pr, HttpStatus.CREATED);
       }
	   @GetMapping("/all")
	   public ResponseEntity<List<ProductLines>> getAllProductLines(){
		        List<ProductLines> pr=service.getAllProductLines();
		        return ResponseEntity.ok(pr);
	   }
}
