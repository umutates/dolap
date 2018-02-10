/**

 */
package com.dolap.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	
    private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	IProductDao productDao;
	
	@CacheEvict(value = "products", allEntries = true)
	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}
	
	@Cacheable(value="products")
	@Override
	public List<Product> findAll() {
		LOG.info("products were taken to cache");
		return   productDao.getAll();
	}
	
	@CacheEvict(value = "products", allEntries = true)
	@Override
	public void delete(Integer productId) {
		Product product=productDao.byId(productId);
		productDao.delete(product);
	}

}
