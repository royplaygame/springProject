package com.hy.ly.collections;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person) ctx.getBean("person3");
		System.out.println(person);
		Person person4=(Person) ctx.getBean("person4");
		System.out.println(person4);
		Person person5=(Person) ctx.getBean("person5");
		System.out.println(person5);
		ctx.close();
	}
	
	@Test
	public void testTeacher(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher teacher=(Teacher) ctx.getBean("teacher");
		System.out.println(teacher);
		ctx.close();
	}
	@Test
	public void testDataSource(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource=(DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
		ctx.close();
	}
}
