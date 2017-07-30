package com.hubo.ws.endpoint;

import javax.xml.ws.Endpoint;

import com.hubo.ws.student.StudentWS;
import com.hubo.ws.student.impl.StudentWSImpl;

public class StudentWSMain {
	public static void main(String[] args) {
		String address="http://127.0.0.1/service/studentWs";
		StudentWS studentWS=new StudentWSImpl();
		
		Endpoint.publish(address, studentWS);
		
		System.out.println("student webservice 发布成功.....");
		
	}
}	
