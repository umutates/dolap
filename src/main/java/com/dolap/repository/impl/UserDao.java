package com.dolap.repository.impl;

import org.springframework.stereotype.Repository;

import com.dolap.entity.User;
import com.dolap.repository.IBaseDao;
import com.dolap.repository.IUserDao;

/**
 * @author umutates
 *3 Şub 2018
 */
@Repository
public class UserDao extends BaseDao<User,Long> implements IUserDao{

}
