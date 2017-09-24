package com.hy.ly.spel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpel {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans-spel.xml");
		Address address=(Address) ctx.getBean("address");
		System.out.println(address);
		Car car=(Car) ctx.getBean("car");
		System.out.println(car);
		
		Student student=(Student) ctx.getBean("student");
		System.out.println(student);
		ctx.close();
	}
}
