package com.bit.day08;

import java.util.Random;

public class Ex15 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		System.out.println(ran.nextBoolean());
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt(45));
	}

}
