package com.bit.day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {

	public static void main(String[] args) {
		// Set 타입의 자료구조 (순서가 없는 자료구조)
		// 이론적 : 순서(x), 중복(x) -> 실질적 : 순서(o), 중복(x)
		// 중복을 허용하지 않는 자료구조
		
//		Set set = new HashSet(); // Hash 함수 사용.
		Set set = new TreeSet(); // Tree 사용.
		System.out.println("1." + set.add("첫번째"));
		System.out.println("2." + set.add("두번째"));
		System.out.println("3." + set.add("세번째"));
		System.out.println("4." + set.add("두번째"));
		System.out.println("5." + set.add("첫번째"));
		Iterator ite = set.iterator();
		
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
