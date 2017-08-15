package com.hubo.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.hubo.spring.aop.Calculation;

public class CalculationLoggingProxy {
	private Calculation target;
	
	public CalculationLoggingProxy(Calculation target){
		this.target=target;
	}
	
	public Object getProxy(){
		Object objProxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("-->The method "+method.getName()+" begin with "+Arrays.asList(args));
				Object result = method.invoke(target, args);
				System.out.println("-->The method "+method.getName()+" end with "+result);
				return result;
			}
		});
		
		return objProxy;
	}
}
