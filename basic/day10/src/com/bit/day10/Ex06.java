package com.bit.day10;

import java.util.*;

public class Ex06 {

	public static void main(String[] args) {
		// Map은 key와 value의 싸으로 관리하는 자료구조
		// 입력시 반드시 key, value쌍으로 입력한다
		// key 순서에 의해 value값 순서 결정
		// value -> 중복 허용
		// key   -> 중복 불가
		// 동일 key ->   수정
		
		Map map = new HashMap();
		map.put("첫번째", 1);
		map.put("두번째", 2);
		map.put("세번째", 3);
		map.put("네번째", 4);
		map.put("세번째", 30);
		
		String[] msg = {"첫번째","두번째","세번째","네번째"};
		for (int i = 0; i < msg.length; i++) {
			System.out.println(map.get(msg[i]));
		}
		
//		System.out.println(map.get("첫번째"));
//		System.out.println(map.get("두번째"));
//		System.out.println(map.get("세번째"));
//		System.out.println(map.get("네번째"));
	}

}
