package com.bit.day04;

public class Ex01 {

	public static void main(String[] args) {
		func1();
		com.bit.day04.Ex01.func1(); //컴파일후 생략된 패키지 붙음.
		Ex01 me = new Ex01();
		me.func2();
	}
	
	public static void func1() {
		System.out.println("static method");
	}
	
	public void func2() {
		System.out.println("non-static method");
	}
}