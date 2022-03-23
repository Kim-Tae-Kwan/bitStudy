package com.bit.day06;

class Lec06{
	
	public int su1 = 1111;
	
	public Lec06(int a) {
		
	}
	
	public void func01() {
		System.out.println("자식클래스의 기능");
	}
}

public class Ex06 extends Lec06{
//	public int su1 = 2222;
	
	public Ex06() {
		super(1111);
		System.out.println(this.su1);
		System.out.println(super.su1);
	}

	public Ex06(int a) {
		this(a, 0);
	}
	
	public Ex06(int a, int b) {
		super(a);
	}
	
	public static void main(String[] args) {
		Ex06 me = new Ex06();
		me.func01();
		
		
	}

}
