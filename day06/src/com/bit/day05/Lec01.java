package com.bit.day05;

public class Lec01 {
	public static int su1 = 1111;
	static int su2 = 2222;
	private static int su3 = 3333;
	protected int su4 = 4444;
	
	protected Lec01() {}
	Lec01(int a) {}
	private Lec01(int a, int b) {}
	
	
	
	public void func01() {
		System.out.println(su3);
	}
}
