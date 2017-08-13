package com.hubo.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		
		/*交给spring完成
		 * //创建对象
		HelloWorld helloWorld=new HelloWorld();
		
		//设置name属性
		helloWorld.setName("hubo");
		*/
		//1.获取IOC容器
		//ApplicationContext 代表IOC容器
		//ClassPathXmlApplicationContext： 是ApplicationContext 接口的实现类。该实现类从类路劲下来加载xml配置文件
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");//获取类路劲下的Ioc容器
		//2.获取bean
		//HelloWorld helloWorld= (HelloWorld) ctx.getBean("helloWorld");
		//3.调用方法
		//helloWorld.hello();
	}
}
