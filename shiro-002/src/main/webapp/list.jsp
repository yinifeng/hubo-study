<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>List Page</h4>
	
	Welcome:<shiro:principal></shiro:principal>
	
	<br><br>
	<a href="shiro/testShiroAnnation">Test ShiroAnnation</a>
	
	<!-- 有user角色 -->
	<shiro:hasRole name="user">
		<br><br>
		<a href="user.jsp">User Page</a>
	</shiro:hasRole>
	
	<!-- 有admin角色 -->
	<shiro:hasRole name="admin">
		<br><br>
		<a href="admin.jsp">Admin Page</a>
	</shiro:hasRole>
	
	<br><br>
	<a href="shiro/logout">Logout</a>
</body>
</html>