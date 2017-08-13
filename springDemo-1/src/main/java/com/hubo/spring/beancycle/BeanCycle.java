package com.hubo.spring.beancycle;

/**
 * xml文件配置  bean 的生命周期
 * @author hubo
 *
 */
public class BeanCycle {
	private Person person;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeanCycle() {
		
		// TODO Auto-generated constructor stub
		System.out.println("Constractor......");
	}
	
	public void init(){
		this.person=new Person(name,22);
		System.out.println("Person:"+person);
		System.out.println("init.....");
	}
	
	public void destroy(){
		System.out.println("destroy....");
	}
}
