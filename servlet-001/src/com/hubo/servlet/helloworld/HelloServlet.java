package com.hubo.servlet.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 1、HelloServlet Constructor... 创建servlet对象
 * 2、init... 执行初始化方法
 * 3、service... 执行业务方法,再次访问 只执行业务方法
 * 4、destroy... 关闭服务器执行
 * @author hubo
 *
 */
public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo...");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init...");
		
		String user = servletConfig.getInitParameter("user");
		System.out.println("user: "+user);
		
		//获取servlet的初始化参数
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			String value=servletConfig.getInitParameter(name);
			System.out.println("name: "+name+",value: "+value);
		}
		
		System.out.println("~~~~~"+servletConfig.getServletName());
		System.out.println("--------------");
		
		//获取当前web应用的上下文对象
		ServletContext servletContext = servletConfig.getServletContext();
		//获取全局参数的值
		String driver = servletContext.getInitParameter("driver");
		System.out.println("driver: "+driver);
		
		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while(names2.hasMoreElements()){
			String name = names2.nextElement();
			String value=servletContext.getInitParameter(name);
			System.out.println("name: "+name+",value: "+value);
		}
		
		//获取当前web应用的资源文件
		//获取当前web应用的某一个文件所在服务器上的绝对路劲，而不是部署前的路径
		String realPath = servletContext.getRealPath("/abc.txt");
		System.out.println("realPath: "+realPath);
		
		//获取当前web应用的名称
		String contextPath = servletContext.getContextPath();
		System.out.println("contextPath: "+contextPath);
		
		//获取当前web应用的某一个文件对应的输入流
		InputStream is1 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
		System.out.println("1-->: "+is1);
		
		//通过类加载路劲获取文件输入流
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream is2 = classLoader.getResourceAsStream("/jdbc.properties");
		System.out.println("2-->: "+is2);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");
	}
	
	public HelloServlet(){
		System.out.println("HelloServlet Constructor...");
	}
}
