package com.hubo.spring.test1;

import org.springframework.beans.factory.DisposableBean;

public class TestDestroy implements DisposableBean{

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestDestroy destroy....");
	}

}
