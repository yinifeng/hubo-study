package com.hubo.string;

import org.apache.commons.lang.StringUtils;

/**
 * 某个字符串中间插入字符串
 * @author hubo
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		
		
		System.out.println(test1("20170401"));
		//System.out.println(test1(""));
		System.out.println(test2(test2("20170401",4,"/"),7,"/"));
		
		System.out
				.println(StringUtils.abbreviateMiddle("20170401", "/", 4));
	}

	private static String test1(String str) {
		StringBuilder sb=new StringBuilder(str);
		
		sb.insert(4, '/').insert(7, "/");
		//sb.insert(7, "/");
		
		return sb.toString();
	}
	
	
	private static String test2(String str,int index,String chr) {
		StringBuilder sb=new StringBuilder(str);
		
		sb.insert(index, chr);
		//sb.insert(7, "/");
		
		return sb.toString();
	}
}
