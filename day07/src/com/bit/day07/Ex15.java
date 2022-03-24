package com.bit.day07;

class Outter15{
	static int su1 = 1111;
	int su2 = 2222;
	
	class Inner15{
//		static int su3 = 3333;
		int su4 = 4444;

		public Inner15() {
		}
		
		void func04() {
			System.out.println(su1);
			System.out.println(su2);
		}
	}
	
	public Outter15() {
		
	}
	
	public static void func01() {
		Outter15 outt = new Outter15();
		Inner15 inn = outt.new Inner15();
		System.out.println(inn.su4);
	}
	public void func02() {
		Inner15 inn = new Inner15();
		System.out.println(inn.su4);
	}
}

public class Ex15 {

	public static void main(String[] args) {
		Outter15 outt = new Outter15();
		Outter15.Inner15 inn = outt.new Inner15();
		System.out.println(inn.su4);
	}
}
