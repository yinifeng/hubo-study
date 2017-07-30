package com.hubo.ws.endpoint;

import java.util.List;

import javax.xml.ws.Endpoint;






import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import com.hubo.ws.hello.HelloWS;
import com.hubo.ws.hello.impl.HelloWSImpl;

public class HelloWSMain {
	public static void main(String[] args) {
		//客户端发送请求 的url
		String address="http://192.168.1.23/services/helloWs";
		//处理请求的SEI对象
		HelloWS helloWS=new HelloWSImpl();
		Endpoint endpoint = Endpoint.publish(address, helloWS);
		System.out.println(endpoint);
		EndpointImpl endpointImpl=(EndpointImpl) endpoint;
		//服务端的日志入拦截器
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new LoggingInInterceptor());
		
		//服务端出日志拦截器
		List<Interceptor<? extends Message>> outInterceptors = endpointImpl.getOutInterceptors();
		outInterceptors.add(new LoggingInInterceptor());
		
		
		System.out.println("发布web service 成功");
		
		
	}
}
