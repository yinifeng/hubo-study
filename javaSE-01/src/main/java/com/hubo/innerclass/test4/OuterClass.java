package com.hubo.innerclass.test4;

/**
 * 静态内部类
 * @author hubo
 * 1、 它的创建是不需要依赖于外围类的。

   2、 它不能使用任何外围类的非static成员变量和方法。
 *
 */
public class OuterClass {
	private String sex="女";
	public static String name="tom";
	
	public OuterClass(String sex) {
		this.sex=sex;
	}
	
	public OuterClass() {
	}
	
	//静态内部类
	static class InnerClass1{
		public static String _name1="tom_static";
		public void display(){
			//System.out.println(sex);  静态内部类不能访问外部类的非静态属性
			System.out.println("OuterClass name:"+name);
		}
	}
	
	class InnerClass2{
		public String _name2="tom_inner";
		public void display(){
			System.out.println(sex);
			System.out.println("OuterClass name:"+name);
		}
	}
	
	public void display(){
		/* 外围类访问静态内部类：内部类. */
		System.out.println(InnerClass1._name1);
		 /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
		new InnerClass1().display();
		/* 非静态内部的创建需要依赖于外围类 */
		OuterClass.InnerClass2 inner2=new OuterClass().new InnerClass2();
		/* 访问非静态内部类的成员需要使用非静态内部类的实例 */
		System.out.println(inner2._name2);
		inner2.display();
	}
	
	public static void main(String[] args) {
		OuterClass oc=new OuterClass("男");
		oc.display();
	}
}
