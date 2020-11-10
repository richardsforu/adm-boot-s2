package com.cts.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@Service(value = "prodService")
@PropertySource(value = "db.properties")
public class ProductServiceImpl implements ProductService {

	// @Autowired
	// private Environment env;

	@Value("${pname}")
	private String productName;

	public ProductServiceImpl() {
		System.out.println("-- ProductServiceImpl object created...");
	}

	@Autowired
	@Qualifier("cartDao")
	private ProductDao prodDao;

	@Override
	public void save(Product product) {
		System.out.println("Product Name: " + productName);
		// System.out.println("Name: "+env.getProperty("name"));
		System.out.println("-- ProductService: ");
		prodDao.saveProduct(product);
	}

}
