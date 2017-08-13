package com.hubo.spring.beancycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 实现spring InitializingBean,DisposableBean 的接口
 * 查看bean的生命周期
 * @author hubo
 *
 */
public class SpringBeanCycle implements InitializingBean,DisposableBean{
	
	public SpringBeanCycle() {
		// TODO Auto-generated constructor stub
		System.out.println("SpringBeanCycle constructor...");
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SpringBeanCycle destroy...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SpringBeanCycle init...");
	}

}
