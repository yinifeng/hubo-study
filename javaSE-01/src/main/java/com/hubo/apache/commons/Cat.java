package com.hubo.apache.commons;

public class Cat {
	private String name;
	private int age;
	private String foot;
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(String name, int age, String foot) {
		super();
		this.name = name;
		this.age = age;
		this.foot = foot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", foot=" + foot + "]";
	}
	
	
}
