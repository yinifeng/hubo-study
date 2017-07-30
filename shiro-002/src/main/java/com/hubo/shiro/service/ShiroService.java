package com.hubo.shiro.service;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;

public class ShiroService {
	
	//必须是admin角色才能访问，否则抛出异常
	@RequiresRoles(value={"admin"})
	public void testMethod(){
		//测试获取session
		Session session=SecurityUtils.getSubject().getSession();
		System.out.println(session.getAttribute("key"));
		System.out.println("testMethod...."+new Date());		
	}
}
