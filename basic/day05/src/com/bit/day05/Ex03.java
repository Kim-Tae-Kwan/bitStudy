package com.bit.day05;

public class Ex03 {
	public static void main(String[] args) {
		/*
		 * 유니코드 2byte
		 * 메모리 가변형
		 */
		
		char[] arr1 = new char[] { 'A', 'B', 'C', 'D'};
		String st1 = new String(arr1);
		System.out.println(st1);
		
		byte[] arr2 = new byte[] {-100, -22, -72, -128};
		String st2 = new String(arr2);
		System.out.println(st2);
	}
}
