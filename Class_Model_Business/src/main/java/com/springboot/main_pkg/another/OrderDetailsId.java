package com.springboot.main_pkg.another;

import java.io.Serializable;

import com.springboot.main_pkg.Entity.Orders;
import com.springboot.main_pkg.Entity.Products;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Embeddable
public class OrderDetailsId implements Serializable{
	 @ManyToOne
	   @JoinColumn(name="ordernumber")
	   private Orders orderNumber;
	   
	   @ManyToOne
	   @JoinColumn(name="productcode")
	   private Products productCode;
}
