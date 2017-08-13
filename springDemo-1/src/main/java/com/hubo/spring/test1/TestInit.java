package com.hubo.spring.test1;

import org.springframework.beans.factory.InitializingBean;

/**
 * 初始化某个bean
 * @author hubo
 *
 */
public class TestInit implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInit afterPropertiesSet...");
	}

}
