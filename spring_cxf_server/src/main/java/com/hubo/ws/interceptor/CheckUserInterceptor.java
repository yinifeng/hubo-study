package com.hubo.ws.interceptor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;


/**
 * 检查用户的拦截器
 * @author hubo
 *
 */
public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	public CheckUserInterceptor() {
		super(Phase.PRE_PROTOCOL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(SoapMessage arg0) throws Fault {
		// TODO Auto-generated method stub
		Header header = arg0.getHeader(new QName("accout"));
		if(header!=null){
			Element rootElement= (Element) header.getObject();
			String name = rootElement.getElementsByTagName("name").item(0).getTextContent();
			String password = rootElement.getElementsByTagName("password").item(0).getTextContent();
			System.out.println(name+"....."+password);
			if("hubo".equals(name)&&"123456".equals(password)){
				System.out.println("server端通过验证");
				return;
			}
		}
		System.out.println("验证不通过，用户名或密码错误");
		throw new Fault(new RuntimeException("用户名或密码错误"));
		
	}

}
