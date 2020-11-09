package com.cts.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.cts.employee.service,com.cts.employee.dao,com.cts.product")
public class Application2 {
	public static void main(String[] args) {

		System.out.println("===>  Hello <===");
		
		SpringApplication.run(Application2.class, args);
		
		
		

	}

}
