<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="emps">List Employee</a>
	<br><br>
	
	<a href="testJson" id="testJson">Test Json</a>
	<br><br>
	
	<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file" />
		Desc:<input type="text" name="desc" />
		<input type="submit" value="Submit" />
	</form>
	<br><br>
	
	<a href="testResponseEntity">Test ResponseEntity</a>
	<br><br>
	
	<a href="i18n">I18n Page</a>
	<br><br>
	
	<form action="testUploadFile" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file" />
		Desc:<input type="text" name="desc" />
		<input type="submit" value="Submit" />
	</form>
	<br><br>
	
	<a href="testExceptionHandlerExceptionResovler?i=0">Test ExceptionHandlerExceptionResovler</a>
	<br><br>
	
	<a href="testResponseStatusExceptionResolver?i=13">Test ResponseStatusExceptionResolver</a>
	<br><br>
	
	<a href="testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
	<br><br>
	
	<a href="testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
	
	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#testJson").click(function(){
				var url=this.href;
				var args={};
				$.post(url,args,function(data){
					for(int i=0;i<data.length;i++){
						var id=data[i].id;
						var lastName=data[i].lastName;
						console.log(id+","+lastName);
					}
				});	
				return false;
			});	
		})
	
	</script>
	
</body>
</html>