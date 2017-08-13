package com.hubo.spring.testutil;


import org.springframework.util.ClassUtils;

public class Main {
	public static void main(String[] args) {
		String shortName = ClassUtils.getShortName(Main.class);
		System.out.println(shortName);
	}
}
