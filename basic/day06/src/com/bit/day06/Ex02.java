package com.bit.day06;
class Lec02{
	public static int su1 = 1111;
	public int su2 = 2222;
	
	public static void func01() {
		System.out.println("부모 f1...");
	}
	
	public void func02() {
		System.out.println("부모 f2...");
	}
}

public class Ex02 extends Lec02{

	public static void main(String[] args) {
		System.out.println(su1);
		func01();
		System.out.println("------------------------");
		Lec02 you = new Lec02();
		System.out.println(you.su2);
		you.func02();
		System.out.println("------------------------");
		Ex02 me = new Ex02();
		System.out.println(me.su2);
		me.func02();
	}

}
