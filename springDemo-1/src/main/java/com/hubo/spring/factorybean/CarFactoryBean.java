package com.hubo.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义 FactoryBean 实现Spring 的 FactoryBean<T> 接口
 * @author hubo
 *
 */
public class CarFactoryBean implements FactoryBean<Car>{

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Car(name, "yellow", 300000.0);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
