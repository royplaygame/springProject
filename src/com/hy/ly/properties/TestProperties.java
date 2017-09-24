package com.hy.ly.properties;

import javax.sql.DataSource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProperties {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
		
		DataSource dataSource=(DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
		ctx.close();
	}
}
