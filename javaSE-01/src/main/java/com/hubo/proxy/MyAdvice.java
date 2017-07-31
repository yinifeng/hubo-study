package com.hubo.proxy;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

	public void beforeMethod(Method method) {
		System.out.println("目标方法执行之前。。。");

	}

	public void afterMethod(Method method,Object obj) {
		// TODO Auto-generated method stub
		System.out.println("获取返回值类型: "+obj.getClass().getName());
		System.out.println("目标方法执行之后。。。");
	}

}
