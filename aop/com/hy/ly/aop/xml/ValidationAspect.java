package com.hy.ly.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidationAspect {

	public void validationArgs(JoinPoint joinPoint) {
		System.out.println("validation----->" + Arrays.asList(joinPoint.getArgs()));
	}

}
