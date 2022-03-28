package com.bit.day09;

import java.util.Arrays;
public class Ex02 {

	public static void main(String[] args) {
		BitArray array = new BitArray();
		array.add(1111);
		array.add(1111);
		array.add(false);
		array.add(2131321L);
		array.add(0.3);
		array.add(0.3f);
		array.add("test");
		
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		
	}

}
