package com.bit.day09;

import java.util.*;

public class Ex04 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1111);
		list.add(2222);
		
		ArrayList list2 = new ArrayList(list);
		System.out.println(list == list2);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		System.out.println("------------------------------");
		
		//List
		//순서가 있는(중복가능) 자료구조, 동적할당
		//crud
		ArrayList list4 = new ArrayList();
		list4.add(1111);
		list4.add(2222);
		list4.add(2, 3000);
		list4.add(3333);
		list4.add(4444);
		list4.add(5555);
		
		list4.set(2, 30);
		list4.remove(2);
		
		ArrayList list5 = new ArrayList();
		list5.add(0);
		list5.addAll(0, list4);
		
//		list5.clear();
//		list5.removeAll(list);
		
		System.out.println("-------------------------------");
		Object[] arr7 = list5.toArray();
		System.out.println(Arrays.toString(arr7));
		int[] arr8 = new int[arr7.length];
		for (int i = 0; i < arr8.length; i++) {
			arr8[i] = (int)arr7[i];
		}
		
		System.out.println(Arrays.toString(arr8));
	}
}
