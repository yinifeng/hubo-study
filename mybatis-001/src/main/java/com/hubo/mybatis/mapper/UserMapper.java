package com.hubo.mybatis.mapper;

import java.util.List;

import com.hubo.mybatis.pojo.User;
import com.hubo.mybatis.pojo.UserCustomer;
import com.hubo.mybatis.pojo.UserQueryVo;

public interface UserMapper {
	
	public int findUser(UserQueryVo userQueryVo);
	
	public User findUserMap(int id);
	
	public int findUserCount(UserQueryVo userQueryVo);
	
	//用户综合查询
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo);
	
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
