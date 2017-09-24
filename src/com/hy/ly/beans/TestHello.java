package com.hy.ly.beans;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {

	public static void main(String[] args) {
		// 创建HelloWord对象
		HelloWord hello = new HelloWord();
		// 给name属性赋值
		hello.setName("HelloMyWord");
		// 调用showInfo()方法
		hello.showInfo();
		System.out.println("========================");
		
		//创建spring IOC容器
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取一个Bean,方式一
		//HelloWord hell=(HelloWord) ctx.getBean("helloWord");
		
		//获取一个Bean,方式二，要求这个类型的只有一个
		HelloWord hell=(HelloWord) ctx.getBean(HelloWord.class);
		//调用方法
		hell.showInfo();
		ctx.close();
		
	}
	
	@Test
	public void testApplicationContext(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car=(Car) ctx.getBean("car");
		System.out.println(car);
		Car car2=(Car) ctx.getBean("car2");
		System.out.println(car2);
		Car car3=(Car) ctx.getBean("car3");
		System.out.println(car3);
		Car car4=(Car) ctx.getBean("car4");
		System.out.println(car4);
		ctx.close();
	}
	@Test
	public void testPerson(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person) ctx.getBean("person");
		System.out.println(person);
		Person person1=(Person) ctx.getBean("person1");
		System.out.println(person1);
		Person person2=(Person) ctx.getBean("person2");
		System.out.println(person2);
		ctx.close();
	}

}
