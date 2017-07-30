package com.hubo.ws.spring.impl;

import com.hubo.ws.spring.Order;
import com.hubo.ws.spring.OrderWS;

public class OrderWSImpl implements OrderWS{
	
	public OrderWSImpl(){
		System.out.println("启动加载测试");
	}

	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
		System.out.println("getById():"+id);
		return new Order(1,"宝马", 500000);
	}

}
