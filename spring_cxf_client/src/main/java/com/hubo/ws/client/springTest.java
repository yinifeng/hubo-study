package com.hubo.ws.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hubo.ws.spring.Order;
import com.hubo.ws.spring.impl.OrderWS;
import com.hubo.ws.spring.impl.OrderWSImplService;

public class springTest {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"client-beans.xml"});
		OrderWS orderWS =  (OrderWS) ctx.getBean("orderClient");
		Order order = orderWS.getById(88);
		System.out.println(order);
	}
}
