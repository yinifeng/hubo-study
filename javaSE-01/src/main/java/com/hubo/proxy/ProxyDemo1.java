package com.hubo.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyDemo1 {
	public static void main(String[] args) throws Exception {
		
		//Class<?> proxyClzz = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class.getInterfaces());
		Class<?> proxyClzz = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		
		System.out.println(proxyClzz.getName());
		
		Constructor<?>[] constructors = proxyClzz.getConstructors();
		lookConstructor(constructors);
		
		lookMethod(proxyClzz.getMethods());
		
		System.out.println("-------proxy1 constructor-------");
		//1.通过代理字节码 获取的
		Constructor con=proxyClzz.getDeclaredConstructor(InvocationHandler.class);
		Collection proxy1=(Collection)con.newInstance(new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		System.out.println(proxy1.toString());
		proxy1.clear();
		//System.out.println(c.size());
		
		
		System.out.println("2-------proxy2 constructor-------");
		//2.一步到位写法
		Collection proxy2=(Collection)Proxy.newProxyInstance(Collection.class.getClassLoader(),
				new Class[]{Collection.class},
				new InvocationHandler() {
					ArrayList  arr=new ArrayList();
					//每次调用代理对象的方法都会执行InvocationHandler 的invoke方法
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						// TODO Auto-generated method stub
						System.out.println(method.getName());					
						Object returnValue=method.invoke(arr, args);
						return returnValue;
					}
				});
		proxy2.add("zxy");
		proxy2.add("ldh");
		proxy2.add("hbb");
		System.out.println(proxy2.size());
		
	}

	private static void lookConstructor(Constructor<?>[] constructors) {
		for(Constructor<?> constructor:constructors){
			StringBuilder sb=new StringBuilder(constructor.getName());
			sb.append("(");
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for(Class<?> parameterType:parameterTypes){
				sb.append(parameterType.getName()+",");
			}
			if(parameterTypes !=null && parameterTypes.length>0){
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(")");
			System.out.println(sb.toString());
		}
	}
	
	private static void lookMethod(Method [] methods) {
		for(Method method:methods){
			StringBuilder sb=new StringBuilder(method.getName());
			sb.append("(");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for(Class<?> parameterType:parameterTypes){
				sb.append(parameterType.getName()+",");
			}
			if(parameterTypes !=null && parameterTypes.length>0){
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(")");
			System.out.println(sb.toString());
		}
	}
}
