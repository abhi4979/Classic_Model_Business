package com.springboot.main_pkg.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class ProductLines {
	@Id
	@Column(length=50)
	private String productLine;
	private String textDescription;
	@Column(name="htmldescription",columnDefinition = "TEXT")
	private String htmlDescription;
	@Column(name = "image")
	private String image;  // Store the URL or file path as a string
}
