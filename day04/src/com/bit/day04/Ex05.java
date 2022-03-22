package com.bit.day04;

public class Ex05 {
	//public static int su1 = 1111;
	public int su1 = 1111;
	
	public static void main(String[] args) {
		Ex05 me = new Ex05();
		System.out.println("1.su1=" + me.su1);
		func1();
		System.out.println("4.su1=" + me.su1);
	}
	
	public static void func1() {
		Ex05 me = new Ex05();
		System.out.println("2.su1=" + me.su1);
		me.su1++;
		System.out.println("3.su1=" + me.su1);
	}
}
