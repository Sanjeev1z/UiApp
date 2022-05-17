package com.advancejava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.advancejava.dao.UserDao;
import com.advancejava.entity.User;
import com.advancejava.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDao userDao;
	
	@Override
	public String validateUser(String username, String password) {
		User user= userDao.validateUser(username, password);
		if(user.getUsername() !=null && user.getPassword().equals(password)) {
			return user.getUsername();
		}
		else {
			return null;
		}
	}
	
}
