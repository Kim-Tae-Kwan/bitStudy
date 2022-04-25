package com.bit.Thread2;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println("main stsat...");
		
		try {
			Thread.sleep(1000); //1초간 멈춤.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main finish...");
	}

}
