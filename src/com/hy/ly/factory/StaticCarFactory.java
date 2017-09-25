package com.hy.ly.factory;

import java.util.HashMap;
import java.util.Map;

//静态工厂方法：直接调用某一个类的静态方法，就可以返回类的实例
public class StaticCarFactory {
	
	private static Map<String,Car> cars=new HashMap<>();
	
	static{
		cars.put("bmw", new Car("BMW",300000));
		cars.put("3w", new Car("3W",100000));
		cars.put("ford", new Car("FORD",150000));
		cars.put("audi", new Car("Audi",200000));
	}
	//静态工厂方法
	public static Car getCar(String brand){
		return cars.get(brand);
	}
}
