package com.hubo.system;

public class RunTest {

	
	public static void main(String[] args) {
		System.out.println(toMemoryInfo());
	}
	
	/**
	 * 计算JVM的内存
	 * @return
	 */
	public static String toMemoryInfo(){
		Runtime runtime=Runtime.getRuntime();
		
		int nFreeMemory=(int) (runtime.freeMemory()/1024/1024);
		int nTotalMemory=(int) (runtime.totalMemory()/1024/1024);
		return "空闲内存:"+nFreeMemory+"M,总内存:"+nTotalMemory+"M";
		
	}
}


