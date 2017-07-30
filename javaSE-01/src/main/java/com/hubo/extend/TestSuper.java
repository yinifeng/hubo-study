package com.hubo.extend;

public class TestSuper extends SuperDemo{
	protected String address="北京";
	//protected String address=super.adress;
	@Override
	protected String sayString() {
		// TODO Auto-generated method stub
		return adress;
	}
	
	@Override
	public int sayAge() {
		// TODO Auto-generated method stub
		return super.sayAge();
	}
	
	public static void main(String[] args) {
		TestSuper ts=new TestSuper();
		
		System.out.println(ts.sayString());
		
		System.out.println(ts.sayAge());
		
		
		System.out.println(ts.address);
		
		System.out.println(SuperDemo.school);
	}
	
}
