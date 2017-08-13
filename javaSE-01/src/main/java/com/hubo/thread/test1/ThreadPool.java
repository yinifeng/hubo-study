package com.hubo.thread.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	private static boolean running=true;
	//private static ExecutorService pool=Executors.newCachedThreadPool();
	
	private static ExecutorService pool=Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) {
		
		System.out.println("start!!!");
		
		pool.execute(new MyThread());
		
//		while(running){
//			pool.execute(new MyThread());
//		}
		
		
		System.out.println("end!!!");
		pool.shutdown();
		
		
	}
	
	private static class MyThread implements Runnable{

		public void run() {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
		
	}
	
}
