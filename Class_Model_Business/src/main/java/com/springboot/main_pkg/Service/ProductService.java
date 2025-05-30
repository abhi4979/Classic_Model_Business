package com.springboot.main_pkg.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main_pkg.Entity.ProductLines;
import com.springboot.main_pkg.Entity.Products;
import com.springboot.main_pkg.dto.ProductDTO;
import com.springboot.main_pkg.repo.ProductRepo;
import com.springboot.main_pkg.repo.Product_Lines_Repo;

@Service
public class ProductService {
      @Autowired
      private ProductRepo repo;
      
      @Autowired
      private Product_Lines_Repo prodrepo;
      
      public Products addProduct(ProductDTO dto) {
    	   Products pr=new Products();
    	   Optional<Products> pro=repo.findById(dto.getProductCode());
    	   if(pro.isPresent()) {
    		   throw new IllegalArgumentException("Product code already exist.Please add different product code");
    	   }
    	   Products prd=new Products();
    	   prd.setProductCode(dto.getProductCode());
    	   prd.setProductName(dto.getProductName());
    	   
    	   
    	   Optional<ProductLines>  lines=prodrepo.findById(dto.getProductLine());
    	   if(lines.isPresent()) {
    		   ProductLines prodinfo=lines.get();
    		   prd.setProductLine(prodinfo);
    	   }else {
    		   throw new IllegalArgumentException("ProductLine not exist.Please add different product code");
    	   }
    	   prd.setProductScale(dto.getProductScale());
    	   prd.setProductVender(dto.getProductVender());
    	   prd.setProductDescription(dto.getProductDescription());
    	   prd.setQuantityInStock(dto.getQuantityInStock());
    	   prd.setBuyPrice(dto.getBuyPrice());
    	   prd.setMSRP(dto.getMSRP());
    	   
    	   repo.save(prd);
    	   return prd;
      }
      
      
      
      
      
}
