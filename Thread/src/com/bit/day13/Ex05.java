package com.bit.day13;
//sleep
public class Ex05 {

	public static void main(String[] args) {
		System.out.println("main start...");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main end...");
	}

}
