package com.hy.ly.annotation;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.annotation.controller.UserController;
import com.hy.ly.annotation.repository.UserDaoImpl;
import com.hy.ly.annotation.service.UserService;


public class TestAnnotation {

	/*
	 *  java.lang.NoClassDefFoundError: org/springframework/aop/TargetSource
	 *  是缺少aop的jar包
	 * 
	 */
	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans-annotation.xml");
		TestDBUtils testDBUtils=(TestDBUtils) ctx.getBean("testDBUtils");
		System.out.println(testDBUtils);
		
		UserController userController=(UserController) ctx.getBean("userController");
		System.out.println(userController);
		
		UserService userService=(UserService) ctx.getBean("userService");
		System.out.println(userService);
		
		UserDaoImpl userDaoImpl=(UserDaoImpl) ctx.getBean("userDaoImpl");
		System.out.println(userDaoImpl);
		
		ctx.close();
	}
	
	@Test
	public void testRelation(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans-annotation.xml");
		UserController userController=(UserController) ctx.getBean("userController");
		userController.execute();
		ctx.close();
	}
}
