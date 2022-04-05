package com.bit.Thread2;

import java.lang.Thread.State;
import java.util.Date;

//스레드 상태.

class Lec05 extends Thread{
	@Override
	public void run() {
		System.out.println(getName() + " start ...");
		int sum = 0;
		for (int i = 0; i < 2000000000; i++) {
			new Date();
		}
		System.out.println(getName() + " end ...");
	}
}

public class ThreadState {

	public static void main(String[] args) {
		Lec05 target = new Lec05();
//		target.start();
		while(true) {
			State state = target.getState();
			System.out.println(state.toString());
			if(state ==  State.NEW) target.start();
			else if(state ==  State.TERMINATED) break;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
