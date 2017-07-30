<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="springMvc/testRedirect">Test Redirect</a>
	<br /><br />
	
	<a href="springMvc/testView">Test View</a>
	<br /><br />

	<a href="springMvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
	<br /><br />
	
	<form action="springMvc/testModelAttributes" method="post">
		<input type="hidden" name="id" value="1" />
		username:<input type="text" name="username" value="tom" />
		<br />
		email:<input type="text" name="email" value="tom@qq.com" />
		<br />
		age:<input type="text" name="age" value="12" />
		<br />
		<input type="submit" value="Submit" />
	</form>
	<br />
	
	<a href="springMvc/testSessionAttributes">Test SessionAttributes</a>
	<br /><br />
	
	<a href="springMvc/testMap">Test Map</a>
	<br /><br />
	
	<a href="springMvc/testModelAndView">Test ModelAndView</a>
	<br /><br />
	
	<a href="springMvc/testServletApi">Test ServletApi</a>
	<br /><br />
	
	<form action="springMvc/testPojo" method="post">
		username:<input type="text" name="username" />
		<br />
		password:<input type="password" name="password" />
		<br />
		email:<input type="text" name="email" />
		<br />
		age:<input type="text" name="age" />
		<br />
		city:<input type="text" name="address.city" />
		<br />
		province:<input type="text" name="address.province" />
		<br />
		<input type="submit" value="Submit" />	
	</form>	
	<br />
	
	<a href="springMvc/testCookieValue">Test CookieValue</a>
	<br /><br />
	
	<a href="springMvc/testRequestHeader">Test RequestHeader</a>
	<br /><br />
	
	<a href="springMvc/testRequestParam?username=tom&age=11">Test RequestParam</a>
	<br /><br />
	
	<form action="springMvc/testRestPut/1" method="post">
		<input type="hidden" name="_method" value="PUT" />
		<input type="submit" value="test RestPut" />
	</form>
	<br />

	<form action="springMvc/testRestDelete/1" method="post">
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="test RestDelete" />
	</form>
	<br />
	
	<form action="springMvc/testRestPost" method="post">
		<input type="submit" value="test RestPost" />
	</form>
	<br />
	
	<a href="springMvc/testRestGet/1">Test RestGet</a>
	<br /><br />
	
	<a href="springMvc/testPathVariable/1">Test PathVariable</a>
	<br /><br />
	
	<a href="springMvc/testAnt/sdfsdfs/abc">Test Ant</a>
	<br /><br />
	
	<a href="springMvc/testParamsAndHeaders?username=tom&age=11">Test ParamsAndHeaders</a>
	<br /><br />
	
	<form action="springMvc/testMethod" method="post">
		<input type="submit" value="submit" />
	</form>
	<br /><br />
	
	<a href="springMvc/testMethod">test Method</a>
	<br /><br />
	
	<a href="springMvc/testRequestMapping">test RequestMapping</a>
	<br /><br />
	
	<a href="helloworld">hello world</a>
</body>
</html>