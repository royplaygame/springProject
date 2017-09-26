package com.hy.ly.calculator;

public class  ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("the method add begins with [" + i + "," + j + "]");
		int result = i + j;
		System.out.println("the method add ends with " + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("the method sub begins with [" + i + "," + j + "]");
		int result = i - j;
		System.out.println("the method sub ends with " + result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("the method mul begins with [" + i + "," + j + "]");
		int result = i * j;
		System.out.println("the method mul ends with " + result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("the method div begins with [" + i + "," + j + "]");
		int result = i / j;
		System.out.println("the method div ends with " + result);
		return result;
	}

}
