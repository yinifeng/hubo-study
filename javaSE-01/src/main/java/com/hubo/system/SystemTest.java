package com.hubo.system;

import java.util.Properties;
import java.util.Set;

public class SystemTest {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		
		for(Object obj: properties.keySet()){
			
			String key=(String) obj;
			Object value = properties.get(key);
			
			System.out.println(key+" --- "+value);
			
		}
		
	}
}
