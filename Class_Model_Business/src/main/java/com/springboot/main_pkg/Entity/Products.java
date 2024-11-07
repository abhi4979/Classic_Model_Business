package com.springboot.main_pkg.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Products {
	@Id
	@Column(length=15)
    private String productCode;
	@Column(length=70,nullable=false)
	private String productName;
	@ManyToOne
	private ProductLines productLine;
	
	@Column(length=10,nullable=false)
	private String productScale;
	@Column(length=50,nullable=false)
	private String productVender;
	@Column(name="productscription",columnDefinition = "TEXT")
	private String productDescription;
	@Column(columnDefinition = "SMALLINT")
	private short quantityInStock;
	@Column(precision = 10,scale=2)
	private BigDecimal buyPrice;
	@Column(precision=10,scale=2)
	private BigDecimal MSRP;
}
