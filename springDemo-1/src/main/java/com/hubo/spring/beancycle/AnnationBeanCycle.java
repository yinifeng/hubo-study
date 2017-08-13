package com.hubo.spring.beancycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * JavaEE 注解 来管理bean的生命周期
 * @author hubo
 *
 */
public class AnnationBeanCycle {
	
	public AnnationBeanCycle() {
		// TODO Auto-generated constructor stub
		System.out.println("Constructor AnnationBeanCycle....");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("PostConstruct init....");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("PreDestroy destroy....");
	}
}
