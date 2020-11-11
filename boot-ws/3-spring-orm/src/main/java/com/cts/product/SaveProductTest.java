package com.cts.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

public class SaveProductTest {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		Product product = new Product();

		product.setId(20);
		product.setName("Toy");
		product.setPrice(12000);
		product.setDescription("BMW Remote Car");

		ProductService ps = ac.getBean(ProductService.class);
		ps.save(product);

	}

}
