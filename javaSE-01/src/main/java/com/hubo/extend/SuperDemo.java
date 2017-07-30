package com.hubo.extend;

public abstract class SuperDemo {
	private String name="tom";
	private static int age=21;
	
	protected String adress="上海";
	
	protected static String school="同济";
	
	protected abstract String sayString();
	
	public int sayAge(){
		return age;
	}
}
