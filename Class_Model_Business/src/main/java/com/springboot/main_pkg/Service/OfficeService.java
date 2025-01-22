package com.springboot.main_pkg.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.main_pkg.Entity.Offices;
import com.springboot.main_pkg.dto.OfficeDTO;
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
   
   public Offices getOffice(String officecode) {
	  return officeRepo.findByOfficeCode(officecode); 
   }
   
   public Offices updatePhoneNumber(String officecode,String phoneno) {
	   Offices offices=officeRepo.findByOfficeCode(officecode);
	   if(offices!=null) {
		   offices.setPhone(phoneno);
		   officeRepo.save(offices);
	   }
	   else {
		   throw new IllegalArgumentException("Office not found");
	   }
	   return offices;
   }
   public Offices updateOfficeDetails(String officecode, @RequestBody OfficeDTO offices) {
	    Offices off= officeRepo.findByOfficeCode(officecode);
	    if(offices!=null) {
	    	off.setCity(offices.getCity());
	    	off.setPhone(offices.getPhone());
	    	off.setAddressLine1(offices.getAddressLine1());
	    	off.setAddressLine2(offices.getAddressLine2());
	    	off.setState(offices.getState());
	    	off.setCountry(offices.getCountry());
	    	off.setPostalCode(offices.getPostalCode());
	    	off.setTerritory(offices.getTerritory());
	    	officeRepo.save(off);
	    }else {
	    	throw new IllegalArgumentException("Office not Found");
	    }
	    return off;
   }
}
