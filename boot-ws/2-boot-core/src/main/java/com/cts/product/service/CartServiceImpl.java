package com.cts.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.product.entity.Product;

@Service(value = "cartService")
public class CartServiceImpl implements ProductService{

	public List<Product> addToCart(Product product) {
		System.out.println("-- CartServiceImpl class ");
		return null;
	}


	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

}
