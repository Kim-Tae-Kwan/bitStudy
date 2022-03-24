package com.bit.day07;

class Outter16{
	static int su3 = 3333;
	int su4 = 4444;
	
	public void func01() {
		int su5 = 5555;
		class Local{
			static final int su1 = 1111;
			int su2 = 2222;
			
			public Local() {
			}
			
			void func2() {
				System.out.println(su3);
				System.out.println(su4);
				System.out.println(su5);
			}
		}
		Local local = new Local();
		local.func2();
	}
}

public class Ex16 {

	public static void main(String[] args) {
		
	}
}
