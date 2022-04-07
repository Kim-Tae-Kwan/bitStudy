package com.bit.Thread2;

//Thread 동기화.
//synchronized 메소드

public class ThreadSynch extends Thread{
	int su1;
	int su2;
	static int sum;
	
	public static void func02(int i) {
		int temp = sum + i;
		sum = temp;
		System.out.println(Thread.currentThread().getName());
	}
	
	public synchronized static void func01(int su1, int su2) {
		for (int i = su1; i <= su2; i++) {
			int temp = sum + i;
			sum = temp;
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	static Object key = new Object();
	@Override
	public void run() {
//		for (int i = su1; i <= su2; i++) {
//			func02(i);
//		}
		
//		func01(su1, su2);
		
		for (int i = su1; i <= su2; i++) {
			synchronized (key) { //mutex 
				int temp = sum + i;
				sum = temp;
			}
			
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String[] args) {
		//sum = 4950
		ThreadSynch me1 = new ThreadSynch();
		ThreadSynch me2 = new ThreadSynch();
		
		me1.su1 = 1;
		me1.su2 = 5000;
		me2.su1 = 5001;
		me2.su2 = 10000;
		
		me1.start();
		me2.start();
		
		try {
			me1.join();
			me2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sum = " + ThreadSynch.sum);
	}

}
