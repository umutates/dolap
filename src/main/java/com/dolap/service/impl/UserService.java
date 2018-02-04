package com.dolap.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolap.entity.User;
import com.dolap.repository.IUserDao;
import com.dolap.service.IUserService;

/**
 * @author umutates 2 Şub 2018
 */
@Service
@Transactional
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	IUserDao userDao;

	@Override
	public void insert(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.insert(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
	
	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	

}
