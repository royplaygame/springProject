package com.hy.ly.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("UserInfoDaoImpl's save()......");
	}

}
