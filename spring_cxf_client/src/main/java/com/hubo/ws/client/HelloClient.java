package com.hubo.ws.client;

import com.hubo.ws.hello.impl.HelloWSImpl;
import com.hubo.ws.hello.impl.HelloWSImplService;

public class HelloClient {
	public static void main(String[] args) {
		//创建生成代理类的工厂
		HelloWSImplService factory=new HelloWSImplService();
		//获取代理发布的Webserveice对象
		HelloWSImpl helloWSImpl=factory.getHelloWSImplPort();
		
		System.out.println(helloWSImpl.getClass().toString());
		//调用方法
		String str = helloWSImpl.sayHello("tom");
		System.out.println(str);
	}
}
