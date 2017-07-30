package com.hubo.mybatis.hellworld;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hubo.mybatis.pojo.User;

public class HelloMybatisTest {
	
	private final static Logger logger=LoggerFactory.getLogger(HelloMybatisTest.class);

	@Test
	public void findUserById() throws IOException {
		
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		logger.info("hello########## {}",user.toString());
		
		logger.info("我要测试日志中文");
		sqlSession.close();
	
	}
	
	@Test
	public void findUserByName() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		
		logger.info("###list {}",list);
		
		sqlSession.close();
	}
	
	@Test
	public void insertUser() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user=new User();
		user.setUsername("张学友");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("湖南长沙");
		sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();
//		logger.info("id:{}",user.getId());
//		System.out.println(user.getId());
		sqlSession.close();
		
		logger.info("id:{}",user.getId());
		
	}
	
	@Test
	public void deleteUser() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("test.deleteUser", 12);
		sqlSession.commit();
		sqlSession.close();		
	}
	
	@Test
	public void updateUser() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user=new User();
		user.setId(8);
		user.setUsername("刘德华");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("香港");
		sqlSession.insert("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
}
