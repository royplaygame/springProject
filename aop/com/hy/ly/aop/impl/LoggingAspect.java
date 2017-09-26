package com.hy.ly.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类声成一个切面：1. 把该类放到IOC容器中，2. 再声明成为一个切面。3.可以通过@Order(2)来指定多个切面的优先级，值越小优先级越高
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	/**
	 * 定义一个方法，用来声明切入点的表达式,一般的，该方法内不再需要添入其它的代码。 后面其它的通知直接使用方法名来引用当前切入点表达式。
	 * 
	 * @param joinPoint
	 */
	@Pointcut("execution(* com.hy.ly.aop.impl.*.*(int, int))")
	public void declareJoinPointExpression() {

	}

	// 声明该是方法是一个前置通知：在目标方法开始之前执行。
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("the method " + methodName + " begins with " + args);
	}

	// 后置通知：在目标方法执行之后（无论是否发生异常），执行的通知
	// 在后置通知中，还不能访问目标方法执行的结果。返回结果要在返回通知中获取。
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " ends ");
	}

	// 返回通知：在目标方法正常结束后的执行，可以获取到方法的返回值。
	@AfterReturning(value = "declareJoinPointExpression()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " ends with " + result);
	}

	// 异常通知:在目标方法出现异常时会执行到的代码，可以访问到异常对象，并且可以指定在出现特定异常时再执行的通知代码。
	@AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " occurs Exception: " + ex);
	}

	// 环绕通知,携带：ProceedingJoinPoint类型的参数
	// 环绕通知类似动态代理的全过程。ProceedingJoinPoint类型的参数可以决定是否执行目标方法。且环绕通知必须有返回值，返回值为目标方法的返回值。
	@Around("declareJoinPointExpression()")
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
