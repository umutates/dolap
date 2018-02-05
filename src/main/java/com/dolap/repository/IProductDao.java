/**

 */
package com.dolap.repository;

import java.util.List;

import com.dolap.entity.Product;

/**
 * @author umutates
 *2 Şub 2018
 */
public interface IProductDao extends IBaseDao<Product,Long>{

	public List<Product> findAll();

}
