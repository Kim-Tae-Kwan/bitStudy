package com.bit.day10;

import java.util.*;

public class Ex08 {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3.12);
		
//		list.add("3");
		
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
		}
		
		Map<String, Double> map = new HashMap<>();
		map.put("String", 3.14);
		
		Set<String> keys = map.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()) {
			String key = ite.next();
			Double val = map.get(key);
		}
	}
}