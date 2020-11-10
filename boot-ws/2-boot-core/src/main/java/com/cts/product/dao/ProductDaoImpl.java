package com.cts.product.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository("prodDao")
public class ProductDaoImpl implements ProductDao {

	public ProductDaoImpl() {
		System.out.println("-- ProductDaoImpl object created...");
	}

	@Override
	public void saveProduct(Product product) {
		System.out.println("-- Dao:  Product is saved..");
	}

}
