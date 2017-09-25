package com.hy.ly.generic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGeneric {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans-generic.xml");
		UserService userService=(UserService) ctx.getBean("userService");
		System.out.println(userService);
		userService.add();
		ctx.close();
	}
}
