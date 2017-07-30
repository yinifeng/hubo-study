package com.hubo.mybatis.dao;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hubo.mybatis.pojo.User;

public class UserDaoImplTest {
	private static Logger logger=LoggerFactory.getLogger(UserDaoImplTest.class);
	
	private UserDao userDao;
	
	@Before
	public void init() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		userDao=new UserDaoImpl(sqlSessionFactory);
	}
	
	@Test
	public void testFindUserById() {
		User user = userDao.findUserById(8);
		logger.info("testFindUserById:{}",user);
		
		try {
			int i=1/0;
		} catch (Exception e) {
			//logger.info("出错了{}", e.getMessage(), e);
			//logger.error("出错了{}", e.getMessage(), e);
			logger.error("出错了!!", e);
		}
		
		logger.info("###########我在执行");
	}

	@Test
	public void testFindUserByName() {
		List<User> users = userDao.findUserByName("小明");
		logger.info("用户列表:{}", users);
	}

	@Test
	public void testInsertUser() {
		User user=new User();
		user.setUsername("古天乐");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setAddress("中国香港");
		Integer seq = userDao.insertUser(user);
		logger.info("序列:{}", seq);
	}

	@Test
	public void testDeleteUser() {
		userDao.deleteUser(9);
	}

	@Test
	public void testUpdateUser() {
		User user=new User();
		user.setUsername("黎明");
		user.setId(7);
		user.setBirthday(new Date());
		user.setSex("0");
		
		userDao.updateUser(user);
	}

}
