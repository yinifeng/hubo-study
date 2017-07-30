package com.hubo.ws.spring;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface OrderWS {
	@WebMethod
	Order getById(int id);
}
