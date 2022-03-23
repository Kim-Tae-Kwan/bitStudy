package com.bit.day06;
import com.bit.day05.*;
//접근제한자
//상속제한

//public : 모두 접근 허용
//protected : default와 동일, 단 다른 패키지 일지라도 상속을 통한 접근 허용
//default : 동일패키지만 접근허용
//private : 클래스 내부에서만 접근 허용
class Lec07{
	public static int su1 = 1111;
	static int su2 = 2222;
	private static int su3 = 3333;
	
	public void func01() {
		System.out.println(su3);
	}
}

public class Ex07 extends Lec01{

	public Ex07() {}
	Ex07(int a) {}
	private Ex07(int a, int b) {}
	public static void main(String[] args) {
		Ex07 me = new Ex07();
		
//		System.out.println(Lec01.su1);
//		System.out.println(Lec01.su2);
//		System.out.println(me.su4);

	}

}
