package com.bit.day07;

interface Test{
	public static final int val = 0;
	public abstract void func();
}

class Kim implements Test{

	@Override
	public void func() {
		System.out.println("KIM override");
		
	}
	
}


public class InterfaceTest {

	public static void main(String[] args) {
//		Test kim = new Kim();
//		kim.func();
		
		Test test = new Test() {
			public void func() {
				System.out.println("익명 인터페이스");
			}
		};
		
		class A implements Test{

			@Override
			public void func() {
				System.out.println("익명 클래스");
			}
		}
		
		Test test2 = new A();
		test2.func();
		
	}

}
