package com.hubo.innerclass.test1;

/**
 * 在成员内部类中要注意两点，
 * 第一：成员内部类中不能存在任何static的变量和方法；
 * 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
 * @author hubo
 *
 */
public class OuterClass {
	private String str;
	
	public void outerDisplay(){
		System.out.println("outerClass...");
	}
	
	public class InnerClass{
		
		public InnerClass() {
			// TODO Auto-generated constructor stub
		}
		
		//如何外部成员属性
		public InnerClass(String aa) {
			str=aa;
		}
		
		public void innerDisplay(){
			
			System.out.println(str);
			
			outerDisplay();
		}
	}
	
	public InnerClass getInnerClass(){
		return new InnerClass();
	}
	
	public InnerClass getInnerClass(String aa){
		return new InnerClass(aa);
	}
	
	public static void main(String[] args) {
		OuterClass outerClass=new OuterClass();
		InnerClass innerClass = outerClass.getInnerClass("tom");
		innerClass.innerDisplay();
	}
}
