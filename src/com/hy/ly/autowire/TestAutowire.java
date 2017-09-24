package com.hy.ly.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans-autowire.xml");
		Student stu=(Student) ctx.getBean("student");
		System.out.println(stu);
		ctx.close();
	}
}
