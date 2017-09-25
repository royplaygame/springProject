package com.hy.ly.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	// 1. 定义一个要代理的对象
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;
		// 代理对象由哪一个类加载器来加载
		// ClassLoader loader=this.target.getClass().getClassLoader();

		// 代理对象的类型，即其中有哪些方法
		// Class []interfaces=new Class[]{ArithmeticCalculator.class};

		// 调用代理对象其中的方法时，执行该方法中的代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:正在返回的那个代理对象，一般情况下不使用，在invoke中都不使用该方法。 
			 * method:正在被调用的方法
			 * args:调用的方法时，传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				// 打印开始日志
				System.out.println("the method " + methodName + " begins with " + Arrays.asList(args));
				// 执行方法
				Object result = method.invoke(target, args);
				// 打印结束日志
				System.out.println("the method " + methodName + " begins with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
				this.target.getClass().getInterfaces(), h);
		return proxy;
	}

}
