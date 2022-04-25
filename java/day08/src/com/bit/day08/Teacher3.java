package com.bit.day08;

import java.util.Arrays;

public class Teacher3 {

	public static void main(String[] args) {
		//3. 아이디어
		/////////////////////////////////////
		// 로또 추첨 과정
		// 1. 1 ~ 45번호 공.
		// 2. 셔플.
		// 3. 6개 공 뽑기.
		// 4. 보너스 번호 뽑기.
		
		// 1. 1 ~ 45번호 공.
		int[] lotto = new int[45];
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}
//		System.out.println(Arrays.toString(lotto));

		// 2. 셔플.
		int temp = -1;
		for (int i = 0; i < 1000; i++) {
			int su = (int)(Math.random() * 45);
			temp = lotto[0];
			lotto[0] = lotto[su];
			lotto[su] = temp;
		}
		
		// 3. 6개 공 뽑기.
		for (int i = 0; i < 6; i++) {
			if(i!=0) System.out.print(',');
			System.out.print(lotto[i]);
		}
		
		// 4. 보너스 번호 뽑기.
		System.out.println("\t보너스번호:" + lotto[6]);
	}

}
