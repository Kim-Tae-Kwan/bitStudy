package com.bit.day05;

public class Ex05 {

	public static void main(String[] args) {
		// 주민번호 확인
		// 주민번호를 입력하세요
		// String input = "991231-1234567";
		// 당신은 24살입니다. 남성입니다.
		// input = "220101-4123456";
		// 당신은 1세 여성입니다.
		
		String input = "991231-1234567";
		//String input = "220101-4123456";
		String gender = "";
		
		byte[] arr1 = input.getBytes();
		
		int first = (arr1[0] - 48) * 10;
		int second = arr1[1] - 48;
		int year = first + second;
		
		int age = 23 - year;
		if(age < 0) {
			age += 100;
		}
		
		if(arr1[7] == 49 || arr1[7] == 51) gender = "남성";
		else gender = "여성";
		
		System.out.println("당신은 " + age +"세 " + gender +"입니다.");
	}

}
