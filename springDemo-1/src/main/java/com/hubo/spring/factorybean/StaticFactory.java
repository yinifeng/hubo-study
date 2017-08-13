package com.hubo.spring.factorybean;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法就可以返回Bean的实例
 * @author hubo
 *
 */
public class StaticFactory {
	private static Map<String, Car> cars=new HashMap<String, Car>();
	
	static{
		cars.put("audi", new Car("audi", "blank", 200000.0));
		cars.put("bmw", new Car("bmw", "red", 500000.0));
		System.out.println("init StaticFactory success....");
	}
	
	public static Car getObject(String name){
		return cars.get(name);
	}
	
}
