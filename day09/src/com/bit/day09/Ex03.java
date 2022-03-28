package com.bit.day09;

public class Ex03 {

	public static void main(String[] args) {
		BitStack queue = new BitArray();
		
		queue.add("첫번째");
		queue.add("두번째");
		queue.add("세번째");
		queue.add("네번째");
		
		while(true) {
			Object obj = queue.pop();
			if(obj == null) break;
			System.out.println(obj);
		}
	}

}
