package com.bit.day07;

public class Ex06 {

	public static void main(String[] args) {
		int su1 = 5;
		int su2 = 2;
		System.out.println(su1 + "+" + su2 + "=" + (su1 + su2));
		System.out.println(su1 + "-" + su2 + "=" + (su1 - su2));
		System.out.println(su1 + "*" + su2 + "=" + (su1 * su2));
		System.out.println(su1 + "/" + su2 + "=" + func(su1, su2));
	}
	
	public static Object func(int a, int b) {
		if(a%b==0) {
			return a/b;
		}else {
			return a*1.0/b;
		}
	}

}
