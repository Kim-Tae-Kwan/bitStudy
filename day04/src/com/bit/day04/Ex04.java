package com.bit.day04;

public class Ex04 {
	public static int su = 1111;
	
	public static void main(String[] args) {
		//우선순위 : 지역 > 전역
		int su = 2222;
		System.out.println("su=" + su);
		System.out.println("Ex04.su=" + Ex04.su);
	}

}
