package com.hubo.ws.hello.impl;

import javax.jws.WebService;

import com.hubo.ws.hello.HelloWS;
@WebService
public class HelloWSImpl implements HelloWS{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("WS server......"+name);
		
		return "hello "+name;
	}

}
