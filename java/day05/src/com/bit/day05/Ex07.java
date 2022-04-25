package com.bit.day05;

public class Ex07 {

	public static void main(String[] args) {
		String msg1 = "java";
		String msg2 = "javas";
		String msg3 = "ABCDE";
		
		System.out.println(msg1.compareTo(msg2));
		
		char[] arr1 = new char[5];
		msg3.getChars(1, 4, arr1, 0);
		
		for(char ar: arr1) {
			System.out.println(ar);
		}
	}

}
