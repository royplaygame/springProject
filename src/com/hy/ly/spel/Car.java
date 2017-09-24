package com.hy.ly.spel;

public class Car {
	private String brand;
	private double price;
	//轮胎周长
	private double tyerPerimeter;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getTyerPerimeter() {
		return tyerPerimeter;
	}
	public void setTyerPerimeter(double tyerPerimeter) {
		this.tyerPerimeter = tyerPerimeter;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyerPerimeter=" + tyerPerimeter + "]";
	}
	public Car() {
		super();
		System.out.println("Car's Constructor......");
	}
	
	
}
