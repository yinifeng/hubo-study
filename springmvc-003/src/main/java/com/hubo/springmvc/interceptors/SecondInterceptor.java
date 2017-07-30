package com.hubo.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * @author hubo
 *
 */
public class SecondInterceptor implements HandlerInterceptor{
	
	/**
	 * 该方法在调用目标方法之前被调用
	 * 若返回值为true，则继续调用后续的拦截器和目标方法
	 * 若返回值为false，则不会再调用后续的拦截器和目标方法
	 * 
	 * 可以考虑做权限 ，日志，事物
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("[SecondInterceptor] preHandle");
		return true;
	}
	
	/**
	 * 调用目标方法之后 渲染视图之前调用
	 * 
	 * 修改请求域里的属性 或 修改 视图
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[SecondInterceptor] postHandle");
		
	}

	/**
	 * 渲染视图之后调用
	 * 
	 * 释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[SecondInterceptor] afterCompletion");
		
	}

}
