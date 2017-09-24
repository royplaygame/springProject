package com.hy.ly.autowire;

public class Student {
	
	private String name;
	private Address address;
	private Car car;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", car=" + car + "]";
	}
	
}
