package com.hubo.spring.beancycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 接口 Bean后置处理器
 * 对IOC容器所有的bean（包括自己） 执行的方法
 * postProcessBeforeInitialization init-method 之前被调用
 * postProcessAfterInitialization  init-method 之后被调用
 * @author hubo
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeforeInitialization..........");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessAfterInitialization..........");
		return bean;
	}

}
