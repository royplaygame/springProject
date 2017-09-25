package com.hy.ly.cycle;

public class Car {
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("setBrand......");
		this.brand = brand;
	}

	public Car() {
		super();
		System.out.println("Car's Constructor......");
	}

	public void init() {
		System.out.println("init......");
	}

	public void destory() {
		System.out.println("destory......");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

}
