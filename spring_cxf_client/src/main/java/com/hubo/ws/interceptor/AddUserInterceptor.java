package com.hubo.ws.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.xml.utils.DOMHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * 1、客户端的自定义拦截器，对应客户端的出拦截器
 * 2、继承AbstractPhaseInterceptor拦截器
 * @author hubo
 *
 */
public class AddUserInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	private String name;
	private String password;
	public AddUserInterceptor(String name,String password) {
		super(Phase.PRE_PROTOCOL);//准备协议化时拦截
		// TODO Auto-generated constructor stub
		this.name=name;
		this.password=password;
	}

	@Override
	public void handleMessage(SoapMessage arg0) throws Fault {
		// TODO Auto-generated method stub
		List<Header> headers=arg0.getHeaders();
		/**
		 * <accout>
		 *		<name>hubo</name>
		 *		<password>123456</password>
		 * </accout>
		 */
		Document document=DOMHelper.createDocument();
		Element rootElement = document.createElement("accout");
		Element nameEle = document.createElement("name");
		nameEle.setTextContent(name);
		rootElement.appendChild(nameEle);
		Element passwordEle = document.createElement("password");
		passwordEle.setTextContent(password);
		rootElement.appendChild(passwordEle);
		
		headers.add(new Header(new QName("accout"), rootElement));
		
		System.out.println("client  HeaderMessage.....");
		
		
		
	}

}
