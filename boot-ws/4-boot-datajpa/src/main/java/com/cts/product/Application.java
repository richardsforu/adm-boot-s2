package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@SpringBootApplication
public class Application {
	
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	void processDbOps() {
		// method 1 for save
		// method 2 for edit
		// method 3 for copy into another table .. etc
	}

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		ProductDao prodDao = ac.getBean(ProductDao.class);
		
		
		prodDao.findProductByNameLikeAndPriceGreaterThan("%a%",70000).forEach(prod->{
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getPrice());
			System.out.println(prod.getDescription());
			System.out.println("---------------------------------");
		});
		
		
		
		/*
		Product product=prodDao.findById(18).orElse(null);
		
		if(product!=null) {
			product.setName("New Name");
		}
		
		prodDao.save(product);
		
		*/
		

	/*
		Product product = new Product();
		product.setId(18);
		product.setName("Cup");
		product.setDescription("Cofee Cup");
		product.setPrice(250);
		
	*/

		
		/*
		prodDao.findAll().forEach(prod->{
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getPrice());
			System.out.println(prod.getDescription());
			System.out.println("---------------------------------");
		});
		
		*/
		
		
		/*
		Product prod=prodDao.findById(21).orElse(null);
		
		if(prod!=null) {
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getPrice());
			System.out.println(prod.getDescription());
			System.out.println("---------------------------------");
		}else {
			System.out.println("Product not found with given id");
		}
		*/
		
		

	}

}
