package com.dolap.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dolap.entity.User;
import com.dolap.repository.IUserDao;

/**
 * @author umutates
 *3 Şub 2018
 */
@Repository
public class UserDao extends BaseDao<User,Long> implements IUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByEmail(String email) {
		Query query=sessionFactory.getCurrentSession().createQuery("from User where email=:email");
		query.setParameter("email", email);
		User user=(User) query.uniqueResult();
		return user;
	}

}
