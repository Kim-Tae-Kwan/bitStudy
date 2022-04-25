package com.bit.day04;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(10);
		queue.offer(2);
		queue.offer(3);
		
		Object item = queue.peek();
		System.out.println(item);
		Object item2 = queue.peek();
		System.out.println(item2);
		
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new LinkedList<>();
		
		
	}

}
