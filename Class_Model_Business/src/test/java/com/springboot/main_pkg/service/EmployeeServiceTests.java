package com.springboot.main_pkg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.main_pkg.repo.EmployeeRepo;

@SpringBootTest
@TestInstance(value =Lifecycle.PER_CLASS)
class EmployeeServiceTests {
   
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Disabled
	//@Test
	@ParameterizedTest
	@ValueSource(ints={
		102,3,5,3
	})
	 void testgetEmployee(int id) {
		 assertNotNull(employeeRepository.findByEmployeeNumber(id));
	}
	
	@ParameterizedTest
	@CsvSource({
		"a,b"
			
	})
	void getAdd(String a,String b) {
		assertNotEquals(a, b);
	}
	
	//@BeforeEach
	@BeforeAll
	void xz() {
		System.out.println("Nope");
	}
	@ParameterizedTest
	@CsvSource({
		"a,a",
		"b,b",
		"c,d"	
	})
	void getAdd1(String a,String b) {
		System.out.println("A");
		assertEquals(a, b);
	}
}
