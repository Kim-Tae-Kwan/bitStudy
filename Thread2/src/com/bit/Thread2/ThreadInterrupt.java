package com.bit.Thread2;

class Lec03 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 500000; i++) {
			System.out.println(getName() + " : " + i);
		}
	}
}

public class ThreadInterrupt {

	public static void main(String[] args) {
		Thread thr0 = Thread.currentThread();
		System.out.println("main stsat...");
		Lec03 thr1 = new Lec03();
//		Lec03 thr2 = new Lec03();
		
		Thread thr3 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				thr0.interrupt(); //인터럽트.
			}
		};
		thr1.start();
//		thr2.start();
		thr3.start();
		

		try {
			thr1.join();
//			thr2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("main finish...");
	}

}
