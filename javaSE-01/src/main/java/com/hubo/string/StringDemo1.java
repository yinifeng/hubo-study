package com.hubo.string;

import java.io.UnsupportedEncodingException;

public class StringDemo1 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="中国人";
		System.out.println(str.getBytes().length);
		System.out.println(str.getBytes("gbk").length);
		
		byte[] bytes = str.getBytes();
		System.out.println("---------------");
		
		for(byte b:bytes){
			Byte a = Byte.valueOf(b);
			int intValue = a.intValue();
			//Integer i=Integer.valueOf(intValue);

			System.out.println(Integer.toHexString(intValue));
		}
		
		
		System.out.println(Integer.MAX_VALUE);
		
		
		
	}
}
