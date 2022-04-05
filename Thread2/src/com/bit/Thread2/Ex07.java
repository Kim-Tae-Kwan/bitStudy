package com.bit.Thread2;

class Lec07 extends Thread{
	
	public synchronized void func01() {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		func01();
		System.out.println("스레드 종료");
	}
}

public class Ex07 {

	public static void main(String[] args) {
		Lec07 thr = new Lec07();
		Lec07 thr2 = new Lec07();
		thr.start();
		thr2.start();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		synchronized (thr) {
			thr.notify();
		}
		
		
	}

}
