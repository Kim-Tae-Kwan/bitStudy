package com.bit.Thread2;

class Lec04 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(getName().equals("Thread-0") && i > 5) {
				yield(); // 스레드 양보
			}else {
				System.out.println(getName() + " : " + i);
			}
		}
	}
}

public class ThreadYield {

	public static void main(String[] args) {	
		Lec04 thr1 = new Lec04();
		Lec04 thr2 = new Lec04();
		thr1.start();
		thr2.start();
	}

}
