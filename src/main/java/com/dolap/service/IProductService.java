package com.dolap.service;

import java.util.List;

import com.dolap.entity.Product;

public interface IProductService {

	public void insert(Product product);
	
	public List<Product> findAll();

}
