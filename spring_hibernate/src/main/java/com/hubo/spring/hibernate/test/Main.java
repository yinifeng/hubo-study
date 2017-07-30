package com.hubo.spring.hibernate.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hubo.spring.hibernate.service.BookShopService;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookShopService bookShopService=(BookShopService) ctx.getBean("bookShopServiceImpl");
		
		bookShopService.purchase("tom", "1001");
	}
}
