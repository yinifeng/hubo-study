package com.hubo.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWS {
	@WebMethod
	public String sayHello(String name);
}
