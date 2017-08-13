package com.hubo.spring.annotationbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloSpring {
	@Value("#{testvalue['value.name']}")
	private String username;
	
	@Value("#{testvalue['value.age']}")
	private int age;
	
	@Value("${car.color}")
	private String color;
	@Value("${car.price}")
	private double price; 
	
	
	public HelloSpring() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello Spring !");
	}
	
	public void sayHello(){
		System.out.println("Hello "+username+","+age);
		System.out.println("--------------");
		System.out.println("BMW "+color+","+price);
	}
}
