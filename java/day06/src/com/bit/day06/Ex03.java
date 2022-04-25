package com.bit.day06;

class Lec03{
	public int su1 = 1111;
	public void func01() {
		System.out.println("부모클래스의 기능");
	}
}


public class Ex03 extends Lec03{

	public static void main(String[] args) {
		Ex03 me = new Ex03();
		System.out.println(me.su1);
		me.func01();
	}
	
	//메서드 오버라이드
	//부모클래스의 메서드와 구조가 동일
	public void func01() {
		System.out.println("자식클래스의 기능");
	}

}
