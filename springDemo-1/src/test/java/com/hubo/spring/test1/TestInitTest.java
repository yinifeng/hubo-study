package com.hubo.spring.test1;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestInitTest {
	
	@Autowired
	private TestFactoryBean testFactoryBean;
	
	@Test
	public void test() throws Exception {
		
		//System.in.read();
		Integer int1 = testFactoryBean.getObject();
		Integer int2 = testFactoryBean.getObject();
		System.out.println(int1==int2);
		System.out.println(int1);
		System.out.println(int2);
		
	}

}
