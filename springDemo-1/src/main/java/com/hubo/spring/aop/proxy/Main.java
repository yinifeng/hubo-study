package com.hubo.spring.aop.proxy;

import com.hubo.spring.aop.Calculation;

public class Main {
	public static void main(String[] args) {
		Calculation calProxy = (Calculation)new CalculationLoggingProxy(
				new CalculationImpl()).getProxy();
		calProxy.add(1, 2);
		calProxy.sub(8, 3);
		
	}
}
