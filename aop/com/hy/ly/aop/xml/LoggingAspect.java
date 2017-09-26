package com.hy.ly.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("the method " + methodName + " begins with " + args);
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " ends ");
	}

	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " ends with " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " occurs Exception: " + ex);
	}

	public Object aroundMethod(ProceedingJoinPoint pjoinPoint) {
		// String methodName = pjoinPoint.getSignature().getName();
		// System.out.println("the method " + methodName + " ends with ");
		Object result = null;
		String methodName = pjoinPoint.getSignature().getName();
		// 执行目标方法
		try {
			// 前置通知
			System.out.println("the method " + methodName + " begins with " + Arrays.asList(pjoinPoint.getArgs()));
			// 执行目标方法
			result = pjoinPoint.proceed();
			// 返回通知
			System.out.println("the method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			e.printStackTrace();
			// 异常通知
			System.out.println("the method " + methodName + " occurs Exception:" + e);
			throw new RuntimeException(e);
		}

		// 后置通知
		System.out.println("the method " + methodName + " ends");

		return result;
	}
}
