package com.bit.day04;

public class Ex11 {
	public final int su;
	
	public Ex11() {
		this(0);
	}
	public Ex11(int a) {
		this(a, 0);
	}
	public Ex11(int a, int b) {
		System.out.println("객체 생성");
		su = a + b;
	}
	
	public static void main(String[] args) {
		Ex11 me1 = new Ex11();
		//Ex11 me2 = new Ex11(1111);
		//Ex11 me3 = new Ex11(1111, 2222);
	}

}
