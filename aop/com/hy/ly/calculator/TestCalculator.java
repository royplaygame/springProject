package com.hy.ly.calculator;

public class TestCalculator {

	public static void main(String[] args) {
		//带日志的
		//ArithmeticCalculator cal = new ArithmeticCalculatorLoggingImpl();
		
		//不带日志的
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator cal=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		int result = cal.add(10, 20);
		System.out.println("---->" + result);
		result = cal.sub(100, 20);
		System.out.println("---->" + result);
		result = cal.mul(10, 20);
		System.out.println("---->" + result);
		result = cal.div(100, 20);
		System.out.println("---->" + result);
	}
}
