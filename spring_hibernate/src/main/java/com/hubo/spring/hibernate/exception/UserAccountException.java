package com.hubo.spring.hibernate.exception;

@SuppressWarnings("serial")
public class UserAccountException extends RuntimeException{
	public UserAccountException(){
		
	}
	
	public UserAccountException(String desc){
		super(desc);
	}
}
