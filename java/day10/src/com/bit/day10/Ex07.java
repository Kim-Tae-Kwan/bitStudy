package com.bit.day10;

import java.util.*;
import java.util.Map.Entry;

public class Ex07 {

	public static void main(String[] args) {
		Map map = new HashMap();
		
		Ex07 me1 = new Ex07();
		Ex07 me2 = new Ex07();
		map.put(1111, 1000);
		map.put(3.14, "실수");
		map.put(me1, "불린");
		map.put(me2, "value");
		
//		Set keys = map.keySet();
//		Iterator ite = keys.iterator();
//		while(ite.hasNext()) {
//			Object key = ite.next();
//			System.out.println(key + " : " + map.get(key));
//		}
		
		Set entrySet = map.entrySet();
		Iterator ite = entrySet.iterator();
		while(ite.hasNext()) {
			Map.Entry entry = (Entry)ite.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}

}
