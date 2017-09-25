package com.hy.ly.factorybean;

import org.springframework.beans.factory.FactoryBean;


//自定义的FactoryBean要实现Spring提供的接口：FactoryBean
public class CarFactoryBean implements FactoryBean<Car> {
	
	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}

	//返回 一个Car实例
	@Override
	public Car getObject() throws Exception {
		return new Car(brand,300000);
	}

	//返回的bean的类型
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	//是否是单实例的
	@Override
	public boolean isSingleton() {
		return true;
	}

}
