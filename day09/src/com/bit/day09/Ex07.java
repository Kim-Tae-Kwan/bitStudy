package com.bit.day09;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex07 {

	public static void main(String[] args) {
		java.util.List list = new LinkedList();
		list.add(1111);
		list.add(2222);
		list.add(3333);
		list.add(4444);
		list.add(5555);
		list.set(2, 3000);
		list.remove(1);
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
