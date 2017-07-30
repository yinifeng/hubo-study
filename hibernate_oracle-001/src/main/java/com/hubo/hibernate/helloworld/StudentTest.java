package com.hubo.hibernate.helloworld;



import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	
	@Before
	public void init(){
		
		Configuration configure = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configure.getProperties())
									.buildServiceRegistry();
		sessionFactory=configure.buildSessionFactory(serviceRegistry);
		
		session=sessionFactory.openSession();
		
		transaction=session.beginTransaction();
		
	}
	
	@After
	public void destroy(){
		//提交事物
		transaction.commit();
		//关闭session
		session.close();
		//关闭sessionFactory
		sessionFactory.close();
	}
	
	@Test
	public void test() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
//		long time=System.currentTimeMillis();
		String format = sdf.format(new Date());
		String format2=sdf2.format(new Date());
		System.out.println(format);
		System.out.println(format2);
		Date date=null;
		try {
			date= sdf.parse(format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Time time=new Time(System.currentTimeMillis());
		
		Student student=new Student("tom", timestamp,time,date);
		session.save(student);
		session.flush();
		//Student student = (Student) session.get(Student.class, 1);
		System.out.println(student);
		System.out.println(student);
	}

}
