package com.bit.day05;

public class Ex04 {

	public static void main(String[] args) {
		String msg = "한글";
		
//		char[] arr1 = msg.toCharArray();
//		for(char item : arr1) {
//			System.out.println(item);
//		}
		
		byte[] arr2 = msg.getBytes();
		for(byte item : arr2) {
			System.out.println(item);
		}
	}

}
