package com.hy.ly.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.ly.annotation.TestDBUtils;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired(required=false)
	private TestDBUtils testDBUtils;
	
	@Override
	public void save() {
		System.out.println("UserDao's save()......");
		System.out.println(testDBUtils);
	}

}
