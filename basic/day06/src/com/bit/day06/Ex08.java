package com.bit.day06;
//final
// class : 클래스의 상속거부
// method : 오버라이드의 거부
// 변수 : 상수형 변수


class Lec08{
	static Lec08 obj = new Lec08();
	
	private Lec08() {}
	
	public void func01() {
		System.out.println("기능");
	}
	
}

public class Ex08 {

	public static void main(String[] args) {
		Lec08 you1 = Lec08.obj;
		you1.func01();
		
		Lec08 you2 = Lec08.obj;
		you2.func01();
		
		System.out.println(you1 == you2);
	}

}
