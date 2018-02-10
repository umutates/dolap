package com.dolap.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dolap.entity.Product;
import com.dolap.repository.IProductDao;

@Repository
@Transactional
public class ProductDao extends BaseDao<Product,Integer> implements IProductDao {


}
