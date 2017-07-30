package com.hubo.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
	
	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		System.out.println("IOC容器工厂类调用此方法.....");
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
//	<property name="filterChainDefinitions">
//        <value>
//            /login.jsp = anon
//            /shiro/login = anon
//            /shiro/logout = logout
//            /user.jsp=roles[user]
//            /admin.jsp=roles[admin]
//            # everything else requires authentication:
//            /** = authc
//        </value>
//    </property>			
		//其实这个地方可以通过数据库查询出来
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/user.jsp", "authc,roles[user]");//记住密码也，需要认证
		map.put("/admin.jsp", "authc,roles[admin]");//记住密码也，需要认证
		map.put("/list.jsp", "user");//记住密码就能使用
		map.put("/**", "authc");

		return map;
		
	}
}
