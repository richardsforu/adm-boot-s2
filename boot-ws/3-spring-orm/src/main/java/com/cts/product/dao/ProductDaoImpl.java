package com.cts.product.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sf;

	// save product
	public Product save(Product product) {
		sf.getCurrentSession().save(product);
		return product;
	}
	
	// fetch all records of product table
	public List<Product> findAll(){
		return sf.getCurrentSession().createQuery("from Product").getResultList();
	}
	
	// find product by product if (int)
	public Product findById(int id) {
		return sf.getCurrentSession().get(Product.class, id);
	}
	
	
	
	
	

}
