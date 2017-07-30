package com.hubo.ws.endpoint;

import javax.xml.ws.Endpoint;

import com.hubo.ws.hello.HelloWS;
import com.hubo.ws.hello.impl.HelloWSImpl;

public class HelloWSMain {
	public static void main(String[] args) {
		//客户端发送请求 的url
		String address="http://192.168.1.23/services/helloWs";
		//处理请求的SEI对象
		HelloWS helloWS=new HelloWSImpl();
		Endpoint.publish(address, helloWS);
		System.out.println("发布web service 成功");
	}
}
