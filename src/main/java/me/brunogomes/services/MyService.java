package me.brunogomes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.brunogomes.daos.ProductDao;

@Service
public class MyService {
	
	private ProductDao productDao;
	
	@Autowired
	public MyService(final ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public String getProducts() {
		return productDao.findAll().toString();
	}
}