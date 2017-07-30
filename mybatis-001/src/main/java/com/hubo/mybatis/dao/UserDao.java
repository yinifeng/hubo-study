package com.hubo.mybatis.dao;

import java.util.List;

import com.hubo.mybatis.pojo.User;

public interface UserDao {
	//按用户id查询
	public User findUserById(int id);
	
	//按用户名称模糊查询
	public List<User> findUserByName(String name);
	
	//增加用户
	public Integer insertUser(User user);
	
	//删除用户
	public void deleteUser(int id);
	
	//修改用户
	public void updateUser(User user);
}
