package com.bit.day09;

import java.util.Deque;
import java.util.LinkedList;

public class Ex12 {

	public static void main(String[] args) {
		Deque deq = new LinkedList();
		deq.offerLast(1111);
		deq.offerLast(2222);
		deq.offerLast(3333);
		deq.offerLast(4444);
//		deq.offerFirst(1111);
//		deq.offerFirst(2222);
//		deq.offerFirst(3333);
//		deq.offerFirst(4444);
		
//		while(true) {
//			if(deq.peekFirst() == null) break;
//			System.out.println(deq.pollFirst());
//		}
		while(true) {
			if(deq.peekLast() == null) break;
			System.out.println(deq.pollLast());
		}
	}

}
