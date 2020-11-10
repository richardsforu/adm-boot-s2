package com.cts.product.dao;

import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository("cartDao")
public class CartDaoImpl implements ProductDao {

	@Override
	public void saveProduct(Product product) {
		System.out.println("-- Cart Dao ....");

	}

}
