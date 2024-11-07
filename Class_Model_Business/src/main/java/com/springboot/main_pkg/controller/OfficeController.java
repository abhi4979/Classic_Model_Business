package com.springboot.main_pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Offices;
import com.springboot.main_pkg.Service.OfficeService;



@RestController
public class OfficeController {
	@Autowired
     OfficeService service;
	
	@PostMapping("/office/add")
	public ResponseEntity<Offices> addOffice(@RequestBody Offices office){
		Offices off=service.addOffice(office);
		return new ResponseEntity<Offices>(off,HttpStatus.CREATED );
	}
}
