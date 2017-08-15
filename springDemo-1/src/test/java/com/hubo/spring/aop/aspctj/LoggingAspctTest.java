package com.hubo.spring.aop.aspctj;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hubo.spring.aop.Calculation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:aop-applicationContext.xml"})
public class LoggingAspctTest {
	
	@Autowired
	private Calculation calculation;
	
	@Test
	public void testBefore() {
		calculation.add(3, 3);
		
		//抛出了异常，但是会执行后置通知
		calculation.div(3, 0);
	}

}
