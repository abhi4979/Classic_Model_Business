package com.springboot.main_pkg.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springboot.main_pkg.Entity.ProductLines;
import com.springboot.main_pkg.dto.ProductLinesDTO;
import com.springboot.main_pkg.repo.Product_Lines_Repo;


@Service
public class Product_Lines_Service {
    
	 @Autowired
	    private Product_Lines_Repo prodlinesrepo;

	 public ProductLines addProductLines(ProductLinesDTO dto) throws IOException {
		    // Validate input before proceeding
		    if (dto.getProductLine() == null || dto.getProductLine().trim().isEmpty()) {
		        throw new IllegalArgumentException("ProductLine ID must not be null or empty.");
		    }

		    // Check if product line already exists
		    Optional<ProductLines> existingProductLine = prodlinesrepo.findById(dto.getProductLine());
		    if (existingProductLine.isPresent()) {
		        throw new IllegalArgumentException("Product Line already exists! Please add another ProductLine Number.");
		    }

		    // Create new ProductLines object and populate fields
		    ProductLines pr = new ProductLines();
		    pr.setProductLine(dto.getProductLine());
		    pr.setTextDescription(dto.getTextDescription());
		    pr.setHtmlDescription(dto.getHtmlDescription());
		    pr.setImage(dto.getImage());
		    return prodlinesrepo.save(pr);
		}



		public List<ProductLines> getAllProductLines(){
			return prodlinesrepo.findAll();
		}

	
}
