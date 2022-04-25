package com.bit.day08;

public class Ex02 {

	public static void main(String[] args) {
		StringBuffer st1 = new StringBuffer(1);
		st1.append("1");
		System.out.println(st1.capacity());
		st1.append("2");
		st1.trimToSize();
		System.out.println(st1.capacity());
		
//		for(int i = 0; i < 100; i++) {
//			st1.append("a");
//			System.out.println(st1.capacity() + ">>" + st1);
//		}
	}
}
