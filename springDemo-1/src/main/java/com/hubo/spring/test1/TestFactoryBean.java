package com.hubo.spring.test1;

import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean<Integer>{

	@Override
	public Integer getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Integer(100);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Integer.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
