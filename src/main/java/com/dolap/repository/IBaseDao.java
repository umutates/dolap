package com.dolap.repository;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, K extends Serializable> {
	
	T byId(K id);

	List<T> getAll();
	 
	void insert(T dto);

	void update(T dto);
	
	void updateNoFlush(T dto);

	void delete(T dto);

	void insertNoFlush(T dto);

	void flush();

	/**
	 * removes the proxy and returns the native object
	 * @param dto
	 * @return
	 */
	T unProxy(T dto);

}