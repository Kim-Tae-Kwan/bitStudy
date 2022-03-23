package com.bit.day06;

class Lec05{
	public void func01(){
		System.out.println("부모클래스의 기능");
	}
}

public class Ex05 extends Lec05{

	public static void main(String[] args) {
		Lec05 you1 = new Lec05();
		you1.func01();
		System.out.println("--------------------------");
		
		Ex05 me = new Ex05();
		me.func01();
		System.out.println("--------------------------");
		
		//다형성
		Lec05 you2 = new Ex05();
		you2.func01();
	}
	
	public void func01() {
		System.out.println("자식클래스의 기능");
	}

}
