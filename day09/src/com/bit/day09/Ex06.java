package com.bit.day09;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex06 {

	public static void main(String[] args) {
		int cnt = 1000000;
		
		ArrayList list1 = new ArrayList();
		LinkedList list2 = new LinkedList();
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			list1.add(i);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			list2.add(i);
		}
		long time3 = System.currentTimeMillis();
		
		System.out.println("ArrayList add: " + (time2 - time1));
		System.out.println("LinkedList add: " + (time3 - time2));
		
		Object su = null;
		long time4 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			su = list1.get(i);
		}
		long time5 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			su = list2.get(i);
		}
		long time6 = System.currentTimeMillis();
		
		System.out.println("ArrayList read: " + (time5 - time4));
		System.out.println("LinkedList read: " + (time6 - time5));
 	}

}
