package com.springboot.main_pkg.Entity;

import java.math.BigDecimal;

import com.springboot.main_pkg.another.OrderDetailsId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
public class OrderDetails {
	@EmbeddedId
    private OrderDetailsId id; 
	@Column(nullable=false)
   private int quantityOrdered;
   @Column(precision = 10,scale = 2,nullable=false)
   private BigDecimal priceEach;
   @Column(columnDefinition = "SMALLINT",nullable=false)
   private short orderLineNumber;
   
}
