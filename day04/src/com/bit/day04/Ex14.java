package com.bit.day04;

public class Ex14 {

	public static void main(String[] args) {
		// 배열
		// 자료형[] 변수명 = new 자료형[길이];
		// 변수명[인덱스]
		// 인덱스 - 0 부터 시작하고 연속됨, max = 길이 - 1
		
		int[] arr = new int[5];
		
		for(int i = 0; i < 5; i++) {
			arr[i] = 2*(i+1);
		}
		
		for(int ar : arr) {
			System.out.println(ar);
		}
	}

}
