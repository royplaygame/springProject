package com.hy.ly.aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationXML {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		ArithmeticCalculator arithmeticCalculatorImpl = (ArithmeticCalculator) ctx
				.getBean("arithmeticCalculatorImpl");
		int result =arithmeticCalculatorImpl.add(10, 20);
		System.out.println("result: "+result);
		
		result =arithmeticCalculatorImpl.sub(100, 20);
		System.out.println("result: "+result);
		
		result =arithmeticCalculatorImpl.mul(10, 20);
		System.out.println("result: "+result);
		
		result =arithmeticCalculatorImpl.div(100, 10);
		System.out.println("result: "+result);
		
		ctx.close();
	}
}
