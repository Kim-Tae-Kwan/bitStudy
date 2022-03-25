package com.bit.day08;

import java.util.Arrays;
import java.util.Random;


public class Teacher {
	public static void main(String[] args) {
		// 로또 번호생성기(ver 0.1.0)
		// 4,44,23,33,12,2
		// sort -> 2,4,12,23,33,44 + 보너스번호
		///////////////////////////////////////
		// Arrays.sort() X
		///////////////////////////////////////
		//1. 전형
		//2. 객체지향
		//3. 아이디어
		///////////////////////////////////////
		
		///////////////////////////////////////
		//1. 랜덤(1~45)
		//2. 중복값 검출
		//3. 정렬
		///////////////////////////////////////
		
//		int ran = -1;
//		while(true) { // 1 ~ 45 사이 수.
//			ran = (int)Math.random() * 100;
//			if(ran > 0 || ran <=45) {
//				break;
//			}
//		}
		
		//1. 랜덤 (1 ~ 45)
		int[] lotto = new int[7]; // 보너스 번호 포함으로 배열크기 7.
		for(int i = 0; i < lotto.length; i++) {
			int ran = (int)(Math.random() * 45) + 1;
			lotto[i] = ran;
			
			//2. 중복 체크.
			for(int j = 0; j < i; j++ ) {
				if(lotto[i] == lotto[j]) {
					i --;
					break;
				}
			}
		}
		
		//2. 정렬
		for(int i = 0; i < 6; i++) { // i < 6 -> 보너스 번호로 배열의 크기가 7이기 때문.
			for(int j = i + 1; j < 6; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = 0;
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(lotto));
		
		
	}
}
