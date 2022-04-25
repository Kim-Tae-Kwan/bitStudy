package com.bit.day08;

public class Ex01 {

	public static void main(String[] args) {
		String st1 = "java";
//		String st2 = new String("java");
		String st2 = st1;
		st2 = st2.concat("Edit");
		
		System.out.println(st1);
		System.out.println(st2);
		
		//객체 하나로 String 처리.
		StringBuffer st3 = new StringBuffer("java");
//		StringBuffer st4 = "java";
		StringBuffer st4 = st3;
		st4 = st4.append("Edit");
		
		
		System.out.println(st3);
		System.out.println(st4);
	}

}
