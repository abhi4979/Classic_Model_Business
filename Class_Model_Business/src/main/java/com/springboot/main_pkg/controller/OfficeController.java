package com.springboot.main_pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main_pkg.Entity.Offices;
import com.springboot.main_pkg.Service.OfficeService;
import com.springboot.main_pkg.dto.OfficeDTO;

import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins="https://classicalmodelbusiness.netlify.app")
@RestController
@RequestMapping("/api/v1/offices/")
@Tag(name="Office API")
public class OfficeController {
	@Autowired
     OfficeService service;
	
	@PostMapping("/office/add")
	public ResponseEntity<Offices> addOffice(@RequestBody OfficeDTO office){
		Offices off=service.addOffice(office);
		return new ResponseEntity<Offices>(off,HttpStatus.CREATED );
	}
	@GetMapping("/get")
	public ResponseEntity<List<Offices>> getAllOffice(){
		List<Offices> off=service.getAllOffices();
		if(off!=null) {
			return ResponseEntity.ok(off);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/office/{officecode}")
	public ResponseEntity<Offices> getOfficeDetails(@PathVariable String officecode){
		Offices office = service.getOffice(officecode);
		if(office!=null) {
			return ResponseEntity.ok(office);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/office/{office_code}/{phone_number}")
	public ResponseEntity<Offices> updatePhoneNumber(@PathVariable String office_code,@PathVariable String phone_number){
		 Offices off= service.updatePhoneNumber(office_code, phone_number);
		 if(off!=null) {
			 return ResponseEntity.ok(off);
		 }else {
				return ResponseEntity.notFound().build();
			}
	}
	@PutMapping("/office/update/{office_code}")
	public ResponseEntity<Offices> updateOffice(@PathVariable String office_code,@RequestBody OfficeDTO offices){
		 Offices off= service.updateOfficeDetails(office_code, offices);
		 if(off!=null) {
			 return ResponseEntity.ok(off);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}
}
