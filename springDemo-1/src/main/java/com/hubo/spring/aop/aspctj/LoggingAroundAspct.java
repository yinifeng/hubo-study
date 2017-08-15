package com.hubo.spring.aop.aspctj;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 环绕切面：整个动态代理方法执行过程
 * 也就是包含了前置通知，后置通知，返回通知，异常通知
 * 
 * @Order 设置切面的优先级 越小优先级越高
 * 
 * @author hubo
 *
 */
@Order(2)
@Aspect
@Component
public class LoggingAroundAspct {
	
	@Around("execution(* com.hubo.spring.aop.aspctj.*.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		try {
			//前置通知
			System.out.println("Around The method "+methodName+" begins "+Arrays.asList(pjd.getArgs()));
			result=pjd.proceed();
			//返回通知
			System.out.println("Around The method "+methodName+" end with "+result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//异常通知
			System.out.println("Around The method "+methodName+" error exception: "+e);
		}
		//后置通知
		System.out.println("Around The method "+methodName+" end ");
		return result;
	}
}
