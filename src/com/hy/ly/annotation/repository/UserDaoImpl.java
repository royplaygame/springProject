package com.hy.ly.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("UserDao's save()......");
	}

}
