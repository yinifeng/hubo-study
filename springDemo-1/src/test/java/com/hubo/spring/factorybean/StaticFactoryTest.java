package com.hubo.spring.factorybean;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:factorybean-applicationContext.xml"})
public class StaticFactoryTest {
	@Autowired
	@Qualifier("staticCar")
	private Car staticCar;
	
	@Autowired
	@Qualifier("instanceCar")
	private Car instanceCar;
	
	@Autowired
	@Qualifier("carFactoryBean")
	private Car carFactoryBean1;
	
	@Autowired
	@Qualifier("carFactoryBean")
	private Car carFactoryBean2;
	
	@Test
	public void testGetObject() {
		System.out.println(staticCar);
		System.out.println(instanceCar);
		
		System.out.println(carFactoryBean1);
		
		//单例
		System.out.println(carFactoryBean1==carFactoryBean2);
	}

}
