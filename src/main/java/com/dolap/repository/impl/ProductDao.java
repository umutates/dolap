package com.dolap.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dolap.entity.Product;
import com.dolap.repository.IProductDao;

@Repository
public class ProductDao extends BaseDao<Product,Long> implements IProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Product");
		return query.list();
	}

}
