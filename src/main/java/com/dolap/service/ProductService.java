/**

 */
package com.dolap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolap.entity.Product;
import com.dolap.repository.IProductDao;

/**
 * @author umutates
 *2 Şub 2018
 */
@Service
@Transactional
public class ProductService {
	
	@Autowired
	IProductDao productDao;
	
	public void insertProduct(Product product) {
		productDao.insert(product);
	}

}
