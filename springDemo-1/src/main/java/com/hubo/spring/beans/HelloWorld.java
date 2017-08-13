package com.hubo.spring.beans;

public class HelloWorld {
	private String name;

	public void setName(String name) {
		System.out.println("实例化bean后设置name属性。。。。");
		this.name = name;
	}
	
	public void hello(){
		System.out.println("Hello "+name);
	}
	
	public HelloWorld(){
		System.out.println("ioc容器启动，实例化bean。。。。。");
	}
	
}
