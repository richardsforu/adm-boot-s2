package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;
import com.cts.product.service.ProductServiceImpl;

@SpringBootApplication
public class Application {
	
	

	public static void main(String[] args) {
		System.out.println(">>>> Welcome <<<<");

		ApplicationContext ac = SpringApplication.run(Application.class, args);

		ProductService ps = ac.getBean(ProductServiceImpl.class);

		Product product = new Product();
		product.setId(10);
		product.setName("Book");
		product.setPrice(653);

		ps.save(product);
		
	

	}

}
