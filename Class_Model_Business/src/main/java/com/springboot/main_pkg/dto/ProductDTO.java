package com.springboot.main_pkg.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVender;
	private String productDescription;
	private short quantityInStock;
	private BigDecimal buyPrice;
	private BigDecimal MSRP;
}
