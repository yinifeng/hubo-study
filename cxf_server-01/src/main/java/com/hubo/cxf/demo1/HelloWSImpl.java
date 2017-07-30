package com.hubo.cxf.demo1;

import javax.jws.WebService;

@WebService
public class HelloWSImpl implements HelloWS{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		return "hello,"+name;
	}

}
