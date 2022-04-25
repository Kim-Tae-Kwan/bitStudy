package com.bit.day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ex03 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);
		
		Set set = new HashSet(list);
		System.out.println(list);
		
//		set.addAll(list);
//		set.clear();
		System.out.println(set);
		System.out.println(set.contains(0));
		set.add(5);
		System.out.println(set.containsAll(list));
		

	}

}
