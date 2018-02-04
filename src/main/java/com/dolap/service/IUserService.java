package com.dolap.service;

import com.dolap.entity.User;

public interface IUserService {

	public void insert(User user);

	public User findByEmail(String email);

}
