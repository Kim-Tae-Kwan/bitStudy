package com.bit.day04;

public class Ex09 {
	public int su = 1111;
	//생성자
	//객체 생성시점에 하고자 하는 일을 작성.
	//대표적으로 멤버 필드 초기화
	//한객체에서 생성자의 호출은 객체 생성시점에 단 한번 이루어짐.
	// default 생성자 -> public 클래스명(){}
	// default 생성자는 다른 생성자가 존재하지 않을 시 생략가능
//	public Ex09() {
//		System.out.println("객체생성");
//	}
	
	public Ex09(int a) {
		System.out.println("매개변수값으로 " + a + "값을 받는 생성자 호출");
	}
	
	public static void main(String[] args) {
		//클래스 기본 구성요소
		//1.메소드 - 객체기능
		//2.변수 - 객체속성, 멤버필드
		//3.생성자.
		Ex09 me;
		me = new Ex09(15);
		
	}

}
