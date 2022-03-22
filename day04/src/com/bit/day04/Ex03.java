package com.bit.day04;

public class Ex03 {
	//전역 변수
	public static int d = 4444;
	
	public static void main(String[] args) {
		System.out.println("d=" + d);
		
		//지역변수
		int a = 1111;
		func1(a);
		System.out.println("a=" + a);
		int b = func2();
		System.out.println("b=" + b);
		System.out.println("d=" + d);
		
	}
	
	public static void func1(int a) {
		System.out.println("func1 a=" + a);
		System.out.println("d=" + d);
	}
	
	public static int func2() {
		//지역변수
		int b = 2222;
		int c = 3333;
		d = c;
		return b;
	}

}
