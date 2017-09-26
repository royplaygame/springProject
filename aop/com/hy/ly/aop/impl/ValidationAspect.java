package com.hy.ly.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {

	@Before("com.hy.ly.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validationArgs(JoinPoint joinPoint) {
		System.out.println("validation----->"+Arrays.asList(joinPoint.getArgs()));
	}

}
