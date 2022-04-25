package com.bit.day05;

public class Ex06 {

	public static void main(String[] args) {
		String msg1 = "java world";
		String msg2 = new String(msg1);
		String msg3 = "java world";
		
//		System.out.println(msg1 == msg2);
//		System.out.println(msg1.equals(msg2));
//		System.out.println(msg1.equals(msg3));
//		System.out.println(msg1 == msg2);
		
		System.out.println(msg1.indexOf('j', 2));
	}

}