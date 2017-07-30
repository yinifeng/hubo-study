<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="testConversionServiceConveter" method="post">
		<input type="text" name="employee"  />
		<input type="submit" value="Submit" />
	</form>
	<br><br>
	
	<!-- 使用spring 的form表单标签 -->
	<form:form action="${pageContext.request.contextPath }/emp" modelAttribute="employee" method="POST">
	
		<!--  错误消息显示
			<form:errors path="*"></form:errors>
			<br />
		-->
		<c:if test="${employee.id ==null }">
			LastName:<form:input path="lastName"/>
			<form:errors path="lastName"></form:errors>
			<br>
		</c:if>
		<c:if test="${employee.id !=null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"  />
		</c:if>
		
		Email:<form:input path="email"/>
		<form:errors path="email"></form:errors>
		<br>
		<%
			Map<Integer,String> genders=new HashMap<Integer,String>();
			genders.put(1, "Male");
			genders.put(0, "FeMale");
			request.setAttribute("genders", genders);
		%>
		Gender:
		<br>
		<form:radiobuttons path="gender" items="${genders }" delimiter="<br>" />
		<br>
		Department:<form:select path="department.id" items="${departments }"
		itemLabel="departmentName" itemValue="id"></form:select><br>
		<!-- 
			1.数据类型转换
			2.数据类型的格式化
			3.数据校验
				1）如何校验？注解？
					JSR303 验证标准处理 
					实现产品 Hibernate validator 的验证框架
					在SpringMVC 配置文件中添加 <mvc:annotation-driven />
					需要在bean属性上加入对应的注解
					在目标方法 bean 类型的前面添加@Valid 注解
				2）验证出错转向哪个页面
				3）错误消息？如何显示，如何把错误消息进行国际化
		
		 -->	
		Birth:<form:input path="birth"/>
		<form:errors path="birth"></form:errors>
		<br>
		Salary:<form:input path="salary"/><br>
		<input type="submit" value="Submit" />
	
	</form:form>
</body>
</html>