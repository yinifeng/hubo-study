package com.hubo.mybatis.mapper;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hubo.mybatis.pojo.User;
import com.hubo.mybatis.pojo.UserCustomer;
import com.hubo.mybatis.pojo.UserQueryVo;

public class UserMapperTest {
	private static Logger logger=LoggerFactory.getLogger(UserMapperTest.class);
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

	}
	
	
	/**
	 * 测试动态sql拼接
	 */
	@Test
	public void testFindUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo=new UserQueryVo();
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(8);
		userQueryVo.setIds(ids);
		
		UserCustomer userCustomer=new UserCustomer();
		userCustomer.setUsername("");
		userCustomer.setSex("1");
		userQueryVo.setUserCustomer(userCustomer);
		int count = mapper.findUser(userQueryVo);
		logger.info("总数:{}", count);
		
		sqlSession.close();
	}
	
	/**
	 * 测试resultMap
	 */
	@Test
	public void testFindUserMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserMap(12);
		logger.info("{}", user);
		
		sqlSession.close();
	}
	
	/**
	 * 统计求和 resultType
	 */
	@Test
	public void testFindUserCount(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustomer userCustomer=new UserCustomer();
		userCustomer.setUsername("学友");
		userCustomer.setSex("1");
		userQueryVo.setUserCustomer(userCustomer);
		int count = mapper.findUserCount(userQueryVo);
		logger.info("总数:{}", count);
		
		sqlSession.close();
	}
	
	/**
	 * 用户综合查询 使用包装类型
	 */
	@Test
	public void testFindUserList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustomer userCustomer=new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("学友");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> users = mapper.findUserList(userQueryVo);
		logger.info("用户综合查询:{}", users);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(12);
		logger.info(user.toString());
		sqlSession.close();
	}

	@Test
	public void testFindUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.findUserByName("学友");
		logger.info("users:{}", users);
		sqlSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setUsername("吴彦祖");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("中国北京");
		Integer seq = mapper.insertUser(user);
		logger.info(user.getId()+"!!!!######");
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.deleteUser(15);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setId(14);
		user.setUsername("吴彦祖444");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setAddress("中国北京5555");
		mapper.updateUser(user);
		logger.info(user.toString()+"!!!!######");
		sqlSession.commit();
		sqlSession.close();
	}

}
