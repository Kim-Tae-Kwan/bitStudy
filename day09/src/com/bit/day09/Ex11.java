package com.bit.day09;

import java.util.StringTokenizer;

public class Ex11 {

	public static void main(String[] args) {
		String msg = "java,web,,db,spring";
		String[] arr1 = msg.split(",");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		System.out.println("-----------------------------");
		StringTokenizer token = new StringTokenizer(msg, ",");
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
	}
}
