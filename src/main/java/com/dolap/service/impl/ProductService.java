/**

 */
package com.dolap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolap.entity.Product;
import com.dolap.repository.IProductDao;
import com.dolap.service.IProductService;

/**
 * @author umutates
 *2 Şub 2018
 */
@Service
@Transactional
public class ProductService implements IProductService {
	
	@Autowired
	IProductDao productDao;
	
	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}

	@Override
	public List<Product> findAll() {
		return   productDao.findAll();
	}

}
