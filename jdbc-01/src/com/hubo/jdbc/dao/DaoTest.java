package com.hubo.jdbc.dao;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.hubo.jdbc.demo1.Customers;

public class DaoTest {
	Dao dao=null;
	{
		dao=new Dao();
	}
	

	@Test
	public void testUpate() {
		String sql="insert into customers(name,email,birth) values(?,?,?);";
		dao.update(sql, "mick","mick@123.com",new Date(new java.util.Date().getTime()));
	}
	@Test
	public void testGet(){
		String sql="select id,name,email,birth from customers where id=?";
		Customers c = dao.get(Customers.class, sql, 5);
		System.out.println(c);
	}
	@Test
	public void testQuery(){
		String sql="select id,name,email,birth from customers where id>?";
		List<Customers> list = dao.query(Customers.class, sql, 1);
		System.out.println(list);
	}
	@Test
	public void tesCount(){
		String sql="select name from customers where id=?";
		String name = dao.count(sql, 5);
		System.out.println(name);
		
		String sql2="select count(1) from customers";
		System.out.println(dao.count(sql2, null));
		
	}
}
