package com.hubo.spring.aop.aspctj;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面  @Order 设置切面的优先级 越小优先级越高
 * @author hubo
 *
 */

@Order(1)
@Aspect
@Component
public class LoggingAspct {
	
	/**
	 * 通用切面表达式
	 */
	@Pointcut("execution(* com.hubo.spring.aop.aspctj.*.*(int, int))")
	public void aspctjExpression(){}
	
	//前置通知，在目标方法执行之前调用
	@Before("aspctjExpression()")
	public void beforeMethod(JoinPoint joinpoint){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();
		//获取方法参数
		List<Object> list = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+methodName+" begins "+list);
	}
	
	//后置通知，在目标方法执行之后调用
	//不管方法是否抛出异常，都会调用
	@After("aspctjExpression()")
	public void afterMethod(JoinPoint joinpoint){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();
		System.out.println("The method "+methodName+" end ");
	}
	
	
	/**
	 * 结果返回通知，可以获取到目标方法的返回结果
	 * 但抛异常不执行
	 * @param joinpoint
	 * @param result
	 */
	@AfterReturning(value="aspctjExpression()",
			returning="result")
	public void returnMethod(JoinPoint joinpoint,Object result){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();
		System.out.println("The method "+methodName+" end with "+result);
	}
	
	/**
	 * 异常通知，目标方法抛出异常后执行
	 * 可以抓取异常，且可以指定特定异常执行该通知
	 * @param joinpoint
	 * @param e
	 */
	@AfterThrowing(value="aspctjExpression()",
			throwing="e")
	public void exceptionMethod(JoinPoint joinpoint,Exception e){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();
		System.out.println("The method "+methodName+" error exception: "+e);
	}
}
