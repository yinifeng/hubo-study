package com.hubo.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * 处理异常的解析器
 * @author hubo
 *
 */
@ControllerAdvice
public class SpringMVCTestHandle {
	
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleRuntimeException(Exception ex){
//		System.out.println("--->出异常了： "+ex);
//		ModelAndView mv=new ModelAndView("error");		
//		mv.addObject("exception", ex);
//		return mv;
//	}
}
