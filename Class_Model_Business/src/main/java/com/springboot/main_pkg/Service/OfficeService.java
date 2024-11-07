package com.springboot.main_pkg.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.main_pkg.Entity.Offices;
import com.springboot.main_pkg.repo.OfficeRepo;

import lombok.Data;

@Service
public class OfficeService {
   @Autowired
   private OfficeRepo officeRepo;
   
   public Offices addOffice(@RequestBody Offices office) {
	   Offices offices=new Offices();
	   offices.setOfficeCode(office.getOfficeCode());
	   offices.setCity(office.getCity());
	   offices.setPhone(office.getPhone());
	   offices.setAddressLine1(office.getAddressLine1());
	   offices.setAddressLine2(office.getAddressLine2());
	   offices.setState(office.getState());
	   offices.setCountry(office.getCountry());
	   offices.setPostalCode(office.getPostalCode());
	   offices.setTerritory(office.getTerritory());
	   
	   officeRepo.save(offices);
	   return offices;
   }
}
