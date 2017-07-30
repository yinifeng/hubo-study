package com.hubo.mybatis.pojo;

import java.util.List;

/**
 * 用户组合查询 包装对象
 * @author hubo
 *
 */
public class UserQueryVo {
	
	private List<Integer> ids;
	//当然可以 组合很多其他的类
	//user的扩展类
	private UserCustomer userCustomer;

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
	
	
	
	
}
