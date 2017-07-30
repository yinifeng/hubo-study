package com.hubo.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 测试appache commons-log
 * @author hubo
 *
 */
public class LogTest {
	private static Log logger=LogFactory.getLog(LogTest.class);
	
	public static void main(String[] args) {
		
		logger.info("hello commons-log");
		
		if(logger.isDebugEnabled()){
			logger.info("hello commons-log!!!!!");
		}
		
	}
}
