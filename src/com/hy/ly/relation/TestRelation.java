package com.hy.ly.relation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.autowire.Address;
import com.hy.ly.autowire.Student;

public class TestRelation {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		address = (Address) ctx.getBean("address2");
		System.out.println(address);
		address = (Address) ctx.getBean("address3");
		System.out.println(address);
		
		Student stu = (Student) ctx.getBean("student");
		System.out.println(stu);
		ctx.close();
	}
}
