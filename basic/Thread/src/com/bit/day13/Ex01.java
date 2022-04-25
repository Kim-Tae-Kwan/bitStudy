package com.bit.day13;

class Lec01 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}

public class Ex01 {
	// Thread
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		
		for (int i = 0; i < 10; i++) {
			Lec01 thread2 = new Lec01();
			thread2.start();
		}
	}
}