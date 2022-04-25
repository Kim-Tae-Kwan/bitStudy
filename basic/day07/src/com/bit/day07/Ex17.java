package com.bit.day07;

interface Inter{
	void func();
}

class Lec17{
	Inter func01(){
		
		//익명 인터페이스
		class Local implements Inter{
			public void func() {
				System.out.println("local run...");
			}
		}
		
		return new Local();
	}
	
	Inter func02(){
		return new Inter(){
			public void func() {
				System.out.println("익명 인터페이스");
			}
		};
	}
}

public class Ex17 {

	public static void main(String[] args) {
		Lec17 lec17 = new Lec17();
		Inter obj = lec17.func01();
		Inter obj2 = lec17.func02();
		obj.func();
		obj2.func();
	}

}
