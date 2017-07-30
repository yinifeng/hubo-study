package com.hubo.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hubo.mybatis.pojo.Orders;
import com.hubo.mybatis.pojo.OrdersCustomer;
import com.hubo.mybatis.pojo.User;

public class OrdersCustomerMapperTest {
	private static Logger logger = LoggerFactory.getLogger(OrdersCustomerMapperTest.class);
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

	}

	@Test
	public void testFindUserAndItems() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomerMapper mapper = sqlSession.getMapper(OrdersCustomerMapper.class);
		List<User> users = mapper.findUserAndItems();

		logger.info("查询列表:{}", users);
	}

	@Test
	public void testFindOdersUserAndDetail() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomerMapper mapper = sqlSession.getMapper(OrdersCustomerMapper.class);
		List<Orders> orders = mapper.findOdersUserAndDetail();

		logger.info("查询列表:{}", orders);
	}

	@Test
	public void testFindOrders() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomerMapper mapper = sqlSession.getMapper(OrdersCustomerMapper.class);
		List<OrdersCustomer> oList = mapper.findOrders();

		logger.info("mapper代理类：{}", mapper);

		logger.info("查询列表:{}", oList);

		for (OrdersCustomer o : oList) {
			logger.info("查询列表:{},{},{},{}", o.getId(), o.getNumber(), o.getUsername(), o.getAddress());
		}

	}

	@Test
	public void testFindOrdersResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomerMapper mapper = sqlSession.getMapper(OrdersCustomerMapper.class);
		List<Orders> oList = mapper.findOrdersResultMap();

		logger.info("查询列表:{}", oList);

		for (Orders o : oList) {
			logger.info("查询列表:{},{},{},{}", o.getId(), o.getNumber(), o.getUser().getUsername(), o.getUser().getAddress());
		}
	}
}
