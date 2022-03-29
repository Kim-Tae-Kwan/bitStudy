package com.bit.day10;

import java.util.*;

public class Ex05 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(1);
		list.add(2);
		list.add(4);
		
		System.out.println(list);
		list.sort(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
//				return (int)o1 - (int)o2;
				return (int)o2 - (int)o1;
			}
			
		});
		
		System.out.println(list);
		
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
