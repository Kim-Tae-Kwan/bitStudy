package com.bit.day13;

//Thread 이름 부여.
public class Ex06 extends Thread{

	public Ex06(String name) {
		super(name);
	}
	
	public static void main(String[] args) {
		Runnable work = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		Thread th1 = new Thread(work, "ㅁㄴㅇㄹ");
//		th1.setName("스레드1");
		th1.start();
		
		Ex06 me = new Ex06("asdf");
//		me.setName("스레드2");
		me.start();
	}
	
	@Override
	public void run() {
		System.out.println(this.getName());
	}

}
