package com.bit.day07;
//입력을 받아서 주민번호 검사기
// 주민번호 입력 > 991231-1234567
// 22세 남성입니다

// 주민번호 입력 > 001231-4234567
// 1세 여성입니다

// 주민번호 입력 > 0012314234567
// - 를 생략하지 마시고 입력바랍니다.
// 1세 여성입니다

// 주민번호 입력 > 001231-423456
// 입력을 다시 확인하시고 입력하세요

import java.util.*;
public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("주민번호 입력 > ");
			String input = sc.nextLine();
			String gender = "";
			
			if(input.length() < 14) {
				if(input.indexOf("-") == -1) System.out.println("- 를 생략하지 마시고 입력바랍니다.");
				else System.out.println("입력을 다시 확인하시고 입력하세요");
				continue;
			}
			
			if(input.charAt(7) == '1' || input.charAt(7) == '3') {
				gender = "남성";
			}else gender = "여성";
			
			byte[] arr = input.getBytes();
			
			int first = (arr[0] - 48) * 10;
			int second = arr[1] - 48;
			int year = first + second;
			
			int age = 23 - year;
			if(age < 0) {
				age += 100;
			}
			
			System.out.println(age + "세 " + gender + "입니다.");
			
		}
	}
}