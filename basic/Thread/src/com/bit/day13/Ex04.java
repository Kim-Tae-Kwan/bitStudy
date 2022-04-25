package com.bit.day13;

//익명 클래스 사용.
public class Ex04 {
	static Runnable obj = new Runnable() {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	};

	public static void main(String[] args) {
		
		Thread th = new Thread(obj);
		th.start();
		
		Thread th2 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		th2.start();
		
		Thread th3 = new Thread(obj);
		th3.start();
	}

}
