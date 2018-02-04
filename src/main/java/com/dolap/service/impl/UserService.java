package com.dolap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolap.entity.User;
import com.dolap.repository.IUserDao;
import com.dolap.service.IUserService;

/**
 * @author umutates
 *2 Şub 2018
 */
@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	IUserDao userDao;
	
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

}
