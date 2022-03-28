package com.bit.day09;

import java.util.*;

public class Ex08 {

	public static void main(String[] args) {
		Queue que = new LinkedList();
		que.offer("첫번째");
		que.offer("두번째");
		que.offer("세번째");
		que.offer("네번째");
		
		for(Object obj : que) {
			System.out.println(obj);
		}
		
		
//		while(true) {
//			Object object = que.poll();
//			if(object == null) break;
//			System.out.println(object);
//		}
	}

}
