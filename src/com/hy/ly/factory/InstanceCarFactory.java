package com.hy.ly.factory;

import java.util.HashMap;
import java.util.Map;
//实例工厂方法：实例工厂的方法，即先得到工厂本身，再调用用工厂的实例方法，再返回bean的实例。
public class InstanceCarFactory {

	private Map<String, Car> cars = null;

	public InstanceCarFactory() {
		cars = new HashMap<>();
		cars.put("bmw", new Car("BMW", 300000));
		cars.put("3w", new Car("3W", 100000));
		cars.put("ford", new Car("FORD", 150000));
		cars.put("audi", new Car("Audi", 200000));
	}

	public Car getCar(String brand) {
		return cars.get(brand);
	}
}
