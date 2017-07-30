package com.hubo.springmvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义带状态的异常
 * @ResponseStatus 这个注解还可以修饰方法
 * @author hubo
 *
 */

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="用户名不存在")
public class UserMatchsNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
