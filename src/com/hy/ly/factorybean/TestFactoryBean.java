package com.hy.ly.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.factorybean.Car;

public class TestFactoryBean {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans-beanfactory.xml");
		Car car=(Car) ctx.getBean("car");
		System.out.println(car);
		ctx.close();
	}
}
