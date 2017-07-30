package com.hubo.mybatis.mapper;

import java.util.List;

import com.hubo.mybatis.pojo.Orders;
import com.hubo.mybatis.pojo.OrdersCustomer;
import com.hubo.mybatis.pojo.User;

public interface OrdersCustomerMapper {
	
	public List<OrdersCustomer> findOrders();
	
	public List<Orders> findOrdersResultMap();
	
	public List<Orders> findOdersUserAndDetail();
	
	public List<User> findUserAndItems();
}
