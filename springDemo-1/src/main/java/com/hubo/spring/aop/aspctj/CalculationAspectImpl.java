package com.hubo.spring.aop.aspctj;

import org.springframework.stereotype.Component;

import com.hubo.spring.aop.Calculation;


@Component
public class CalculationAspectImpl implements Calculation {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
