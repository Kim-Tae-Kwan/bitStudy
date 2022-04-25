package com.bit.day06;

class Lec09{
	//싱글턴 패턴
	private static Lec09 obj = new Lec09();
	
	private Lec09() {
		//객체생성을 외부에서 못하게 막는 경우
		// 1. 클래스 내부가 모두 static
		// 2. 객체생성 제어권을 외부에 주지 않고 싶은 경우
		// 3. 기타
	}
	
	public void func01() {}
	public static Lec09 newInstance() {
		return obj;
	}
}

public class Ex09 {

	public static void main(String[] args) {
		Lec09 you = Lec09.newInstance();
		you = null;
		Lec09 you2 = Lec09.newInstance();
		System.out.println(you2 != null);
	}

}
