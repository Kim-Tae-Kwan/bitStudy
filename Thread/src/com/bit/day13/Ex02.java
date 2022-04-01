package com.bit.day13;

public class Ex02 extends Thread{

	public static void main(String[] args) {
		Ex02 me = new Ex02();
		me.start();
		
		Thread th1 = Thread.currentThread();
		System.out.println(th1.getName());
	}
	
	@Override
	public void run() {
//		Thread th2 = this.currentThread();
		System.out.println(this.getName());
	}

}
