package com.hubo.ws.client;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;

import com.hubo.ws.hello.impl.HelloWSImpl;
import com.hubo.ws.hello.impl.HelloWSImplService;
import com.hubo.ws.interceptor.AddUserInterceptor;

public class HelloClientInterceptor {
	public static void main(String[] args) {
		HelloWSImplService factory=new HelloWSImplService();
		HelloWSImpl helloWS = factory.getHelloWSImplPort();
		System.out.println(helloWS.toString());
		//发送请求客户端对象
		Client client=ClientProxy.getClient(helloWS);
		//客户端自定义拦截器
		List<Interceptor<? extends Message>> outInterceptors = client.getOutInterceptors();
		outInterceptors.add(new AddUserInterceptor("hubo", "1234567"));
		
		String result=helloWS.sayHello("tom");
		System.out.println("Client_"+result);
		
	}
}
