package com.bit.day10;

import java.util.*;

public class Ex02 {

	public static void main(String[] args) {
		// 로또 번호 생성기 (ver 0.2.0)
//		Set set = new HashSet();
//		int[] lotto = new int[6];
//		
//		while(set.size() != 6) {
//			int a = (int)(Math.random() * 45);
//			set.add(a);
//		}
//		
//		Iterator ite = set.iterator();
//		while(ite.hasNext()) {
//			System.out.println(ite.next());
//		}
		
		Random random = new Random();
		Set lotto = new TreeSet();
		
		
		
		while(lotto.size() != 6) {
			lotto.add(random.nextInt(45) + 1);
		}
		
		System.out.println(lotto);
		
		Iterator ite = lotto.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}