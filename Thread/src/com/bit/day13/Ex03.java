package com.bit.day13;

//Thread 상속하지 않고
class Lec03 implements Runnable{
	public void run() {
		Thread th1 = Thread.currentThread();
		System.out.println(th1.getName());
	}
}

public class Ex03 {

	public static void main(String[] args) {
		Lec03 obj = new Lec03();
		Thread th2 = new Thread(obj);
		Thread th3 = new Thread(obj);
		th2.start();
		th3.start();
		
		Thread th1 = Thread.currentThread();
		System.out.println(th1.getName());
	}

}
