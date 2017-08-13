package com.hubo.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		//long start=System.currentTimeMillis();
		System.out.println("Thred Start!!!!");
		System.out.println(Thread.currentThread().getName());
		System.out.println(start(20));
		System.out.println("Thred End!!!!");
	}
	
	private static int start(int a){
		int b=10;
		test();
		
		return a+b;
		
		
	}
	
	
	private static void test(){
		
		new Thread(new Runnable() {
			
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			}
		}).start();
		
	}

}
