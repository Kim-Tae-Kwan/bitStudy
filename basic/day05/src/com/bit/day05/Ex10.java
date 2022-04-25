package com.bit.day05;

import java.util.*;
public class Ex10 {

	public static void main(String[] args) {
		// 문자열입력받기
		
		//객체 준비
		Scanner sc = new Scanner(System.in);
		
		// sc.nextLine() <- 입력받기
		String msg = sc.nextLine();
		System.out.println("1입력받은 내용은  " + msg);
		
		String msg2 = sc.nextLine();
		System.out.println("1입력받은 내용은  " + msg2);
		
		sc.close();
	}

}
