package com.cts.product.dao;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductDao {

	// save product
	Product save(Product product);

	// fetch all records of product table
	List<Product> findAll();

	// find product by product if (int)
	Product findById(int id);

}