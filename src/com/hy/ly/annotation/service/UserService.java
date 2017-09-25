package com.hy.ly.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hy.ly.annotation.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userInfoDaoImpl")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(){
		System.out.println("UserService's add().......");
		userDao.save();
	}
}
