package com.hubo.servlet.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("submit.....");
		
		//获取请求参数的值
		String user = request.getParameter("username");
		System.out.println(user);
		
		//获取复选框
		String[] values = request.getParameterValues("interesting");
		for(String value:values){
			System.out.println("interesting: "+value);
		}
		
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value=request.getParameter(name);
			System.out.println("~~"+name+","+value);
			
		}
		
		Map<String, String[]> paramMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entry:paramMap.entrySet()){
			System.out.println("-->"+entry.getKey()+":"+Arrays.asList(entry.getValue()));
		}
		
		//强转HttpServletRequest
		HttpServletRequest hRequest= (HttpServletRequest) request;
		
		//获取请求地址
		String requestURI = hRequest.getRequestURI();
		System.out.println(requestURI);
		
		//获取请求方式
		String method = hRequest.getMethod();
		System.out.println(method);
		
		//获取请求参数 若是POST方式为空  若是GET请求 则为？后面的参数
		String queryString = hRequest.getQueryString();
		System.out.println(queryString);
		
		//设置响应数据类型
		response.setContentType("application/msword");
		PrintWriter writer = response.getWriter();
		writer.println("helloworld....");
		
	}

}
