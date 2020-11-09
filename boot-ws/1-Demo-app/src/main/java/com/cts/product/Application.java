package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.cts.employee.service,com.cts.employee.dao,com.cts.product")
public class Application {
	public static void main(String[] args) {

		System.out.println("===>  Hello <===");
		
		SpringApplication.run(Application.class, args);
		
		
		

	}

}
