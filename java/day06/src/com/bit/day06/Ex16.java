package com.bit.day06;
import java.util.*;

public class Ex16 {
	public static void main(String[] args) {
		long su = System.currentTimeMillis();
//		System.out.println(su);
//		System.gc();
//		System.exit(0);
		double su2 = 3.14;
//		System.out.println(Math.ceil(su2));
//		System.out.println(Math.round(su2));
//		System.out.println(Math.floor(su2));
		for(int i = 0; i < 5; i++) {
			System.out.println(Math.round(Math.random() * 10));
		}
	}
}
