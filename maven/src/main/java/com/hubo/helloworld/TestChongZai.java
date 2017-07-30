package com.hubo.helloworld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestChongZai {
	
	
	public String say(int a,long b){
		
		return null;
	}
	
	public String say(long b,int a){
		
		return null;
	}
	
	public static void main(String[] args) {
		Map<String, String> m=new HashMap<String, String>();
		m.put("abc", "bbb");
		String str = m.put("abc", "aaa");
		System.out.println(str);
		
		Set<String> s=new HashSet<String>();
		s.add("AAA");
		System.out.println(s.add("ccc"));
	}
}
