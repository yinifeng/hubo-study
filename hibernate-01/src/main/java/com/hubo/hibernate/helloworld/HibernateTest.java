package com.hubo.hibernate.helloworld;

import static org.junit.Assert.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		//1.创建一个sessionFactory
		SessionFactory sessionFactory=null;
		//1)创建Configuration 对象：对应hibernate的基本信息和对象关系信息
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry=
				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
											.buildServiceRegistry();
		//hibernate 4.0后
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		//2.创建一个session对象
		Session session=sessionFactory.openSession();
		
		//3.开启事物
		Transaction transaction = session.beginTransaction();
		
		//4.执行保存操作
		News news=new News("java", "hubo", new Date(new java.util.Date().getTime()));
		session.save(news);
		
		//5.提交事物
		transaction.commit();
		
		//6.关闭session
		session.close();
		
		//7.关闭sessionFactory
		sessionFactory.close();
		
	}

}
