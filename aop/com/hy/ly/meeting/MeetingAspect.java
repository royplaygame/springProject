package com.hy.ly.meeting;

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
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeetingAspect {

	@Before("execution(* com.hy.ly.meeting.MeetingPlaceImpl.*(..))")
	public void beforeMethod(JoinPoint joinpoint) {
		String name = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println(name + " 开幕式开始。。。。。" + args);
	}

	@AfterReturning("execution(* com.hy.ly.meeting.MeetingPlaceImpl.*(..))")
	public void afterReturning() {
		System.out.println(" 完美闭幕。。。。。");
	}

	@AfterThrowing("execution(* com.hy.ly.meeting.MeetingPlaceImpl.*(..))")
	public void afterThrowing() {
		System.out.println(" 场子演砸了,进行善后处理吧......");
	}

	@After("execution(* com.hy.ly.meeting.MeetingPlaceImpl.*(..))")
	public void afterMethod() {
		System.out.println("  观众开始退场......");
	}

	@Around("execution(* com.hy.ly.meeting.MeetingPlaceImpl.*(..))")
	public void aroundMethod(ProceedingJoinPoint pJoinPoint) {
		String name = pJoinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(pJoinPoint.getArgs());
		try {
			System.out.println(name + " 开幕式开始。。。。。" + args);
			pJoinPoint.proceed();
			System.out.println(" 完美闭幕。。。。。");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(" 场子演砸了,进行善后处理吧......");
		} finally {
			System.out.println(" 观众开始退场......");
		}
	}
}
