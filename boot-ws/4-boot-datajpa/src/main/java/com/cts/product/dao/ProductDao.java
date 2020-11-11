package com.cts.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.product.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	//------- custom query // DSL -> domain-specific language 
	List<Product> findProductByNameLike(String name);
	List<Product> findProductByPriceGreaterThan(double price);
	List<Product> findByPriceBetween(double start,double end);
	List<Product> findProductByNameLikeAndPriceGreaterThan(String name,double price);
	
	

	
	//------- stored procs
	// ------ triggers
	
	
	
	
	
}
