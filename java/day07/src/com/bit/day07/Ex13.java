package com.bit.day07;

public class Ex13 {
	//내부클래스
	// 클래스 내부의 또 다른 클래스
	// 1. static 내부클래스
	// 2. non-static 내부클래스, 인스턴스 클래스
	// 3. local 클래스
	// 4. 익명 클래스
	
	static class Inner1{}

	class Inner2{}
	
	public void func() {
		class Inner3{}
	}
	
	public static void main(String[] args) {

	}

}
