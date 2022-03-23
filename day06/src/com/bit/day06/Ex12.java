package com.bit.day06;

abstract class Lec12{ //추상 클래스 : 추상메서드를 0개 이상 갖는 클래스
	int su = 1111;
	void func01() {}
	abstract void func02(); // 추상메서드 : 메서드의 선언만 갖음
}

public class Ex12 extends Lec12{
	public static void main(String[] args) {
		Lec12 me = new Ex12();
		me.func01();
		me.func02();
	}
	
	@Override
	void func02() {
		System.out.println("자식에서 부여한 기능2");
	}
	
	
}
