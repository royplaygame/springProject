package com.hy.ly.beans;

public class HelloWord {
	
	private String name;
	
	public void setName(String name){
		System.out.println("setName: "+name);
		this.name=name;
	}
	
	public void showInfo(){
		System.out.println("Hello: "+name);
	}
	
	public  HelloWord(){
		System.out.println("HelloWord's Constructor");
	}

}
