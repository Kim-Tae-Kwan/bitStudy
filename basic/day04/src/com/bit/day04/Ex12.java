package com.bit.day04;

public class Ex12 {
	public int su = 1111;
	
	public static void main(String[] args) {
		Ex12 me = new Ex12();
		me.su++;
		System.out.println("main su=" + me.su);
		me.func01().func01();
	}
	
	public void func02(int su) {
	}
	
	public Ex12 func01() {
		int su = 2222;
		Ex12 me = this;
		System.out.println("func01 su=" + me.su);
		System.out.println("func01 su=" + su);
		System.out.println("func01 su=" + this.su);
		return this;
	}

}