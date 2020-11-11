package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductService {
	// save product
	Product save(Product product);

	// fetch all records of product table
	List<Product> findAll();

	// find product by product if (int)
	Product findById(int id);
}
