package com.hubo.spring.factorybean;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例的工厂方法
 * @author hubo
 *
 */
public class InstanceFactory {
	private Map<String, Car> cars;
	
	public InstanceFactory() {
		// TODO Auto-generated constructor stub
		cars=new HashMap<String, Car>();
		cars.put("audi", new Car("audi", "blank", 200000.0));
		cars.put("bmw", new Car("bmw", "red", 500000.0));
		System.out.println("init InstanceFactory success....");
	}
	
	public Car getObject(String name){
		return cars.get(name);
	}
}
