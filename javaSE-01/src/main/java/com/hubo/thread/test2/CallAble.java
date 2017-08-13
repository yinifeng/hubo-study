package com.hubo.thread.test2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallAble {
	
	//private static ExecutorService pool=Executors.newSingleThreadExecutor();
	private static ExecutorService pool=Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) throws Exception{
		System.out.println("sart!!!!");
		Future<Integer> f = pool.submit(new MyCallable());
		if(f.isDone()){
			Integer num = f.get();
			System.out.println("~~~~~~~~~~~~~~~~"+num);
		}
		
		System.out.println("end!!!");
		
	}
	
	private static class MyCallable implements Callable<Integer>{

		public Integer call() throws Exception {
			
			Thread.sleep(3000);
			// TODO Auto-generated method stub
			int num=0;
			for(int i=1;i<100;i++){
				System.out.println(Thread.currentThread().getName()+":"+i);
				num=num+i;
			}
			
			return num;
		}
		
		
	}
}
