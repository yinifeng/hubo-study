package com.hubo.apache.commons;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		
		Dog d=new Dog("tom", 12, "black");
		
		Cat c=new Cat();
		int i;
		Pig p;
		//按属性名称拷贝 值
		BeanUtils.copyProperties(c, d);
		
		
		System.out.println(c);
	}
}
