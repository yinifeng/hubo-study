package com.hubo.spring.hibernate.exception;


@SuppressWarnings("serial")
public class BookStockException extends RuntimeException{
	public BookStockException() {
		// TODO Auto-generated constructor stub
	}
	
	public BookStockException(String desc) {
		super(desc);
	}
}
