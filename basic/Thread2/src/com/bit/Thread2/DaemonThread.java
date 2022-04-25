package com.bit.Thread2;
//데몬 스레드

class Lec08 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("thread working...");
			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {
		System.out.println("me start...");
		Lec08 thr = new Lec08();
		thr.setDaemon(true);
		thr.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("me end...");
	}

}
