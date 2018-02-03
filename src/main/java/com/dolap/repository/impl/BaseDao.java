package com.dolap.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dolap.repository.IBaseDao;
import com.dolap.util.DAOUtil;

/**
 * @author umutates
 *3 Şub 2018
 */
@Repository
public abstract class BaseDao<T, K extends Serializable> implements IBaseDao<T, K> {
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> persistentClass = (Class<T>) DAOUtil.getTypeArguments(BaseDao.class, this.getClass()).get(0);

	/**
	 * Return current session from session Factory
	 * 
	 * @return
	 */
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public T byId(K id) {
		return (T) sessionFactory.getCurrentSession().get(persistentClass, id);
	}

	@Override
	public List<T> getAll() {
		return (List<T>) sessionFactory.getCurrentSession().createQuery("from " + persistentClass.getName()).list();
	}

	@Override
	public void flush() {
		sessionFactory.getCurrentSession().flush();	
	}
	
	@Override
	public void insert(T dto) {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().persist(dto);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	// TODO remove flushing from default implementation because that breaks transaction logic
	public void update(T dto) {
		sessionFactory.getCurrentSession().update(dto);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void insertNoFlush(T dto) {
		sessionFactory.getCurrentSession().persist(dto);
		
	}

	@Override
	public void updateNoFlush(T dto) {
		sessionFactory.getCurrentSession().update(dto);
	}

	@Override
	public void delete(T dto) {
		sessionFactory.getCurrentSession().delete(dto);
	}
	
	@Override
	public T unProxy(T dto) {
		Session session = sessionFactory.getCurrentSession();
		Object unproxied = ((SessionImplementor)session).getPersistenceContext().unproxy(dto);
		
		return (T) unproxied;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}