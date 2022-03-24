package com.bit.day07;

import java.util.*;
public class SocialNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 검사기(ver 0.2.0)");
		boolean boo = true;
		int age = 1;
		char gender = '남'; 
		while(boo) {
			System.out.print("주민번호 입력 > ");
			String input = sc.nextLine();
			
			boolean digit = false;
			for(int i= 0 ; i < input.length(); i++) {
				if(i==6) continue;
				if(!Character.isDigit(input.charAt(i))) digit = true;
			}
			
			if(!input.contains("-")) {
				System.out.println("-를 생략하지 마시고 입력바랍니다.");
				continue;
			}else if(input.length() != 14) {
				System.out.println("입력을 확인하시고 다시 입력하세요.");
				continue;
			}else if(digit) {
				System.out.println("입력을 확인하시고 다시 입력하세요.");
				continue;
			}
			
			
			age = 1 + 2022 - Integer.parseInt("19" + input.substring(0,2));
			if(input.charAt(7) % 2 == '2' % 2) gender = '여';
			
			boo = false;
		}
		
		System.out.println(age + "세 " + gender +"성입니다.");
	}

}
