package com.bit.day06;
import java.util.*;

//성적 관리 프로그램 과제 풀이
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 성적관리 프로그램(ver 0.2.0)");
		int num = 0;
		String table = "학번\t|국어\t|영어\t수학";
		
		while(true) {
			System.out.print("1.입력 2.결과 0.종료 > ");
			String input = sc.nextLine();
			if(input.equals("0")) break;
			else if(input.equals("1")) {
				table += "\n" + (++num);
//				System.out.print(num + "학번 국어 > ");
//				table +="\t|" + sc.nextLine();
//				System.out.print(num + "학번 영어 > ");
//				table +="\t|" + sc.nextLine();
//				System.out.print(num + "학번 수학 > ");
//				table +="\t|" + sc.nextLine();
				
				String[] sub = {"국어", "영어", "수학"};
//				for(int i = 0; i< 3; i++) {
//					System.out.print(num + "학번 " + sub[i] + " > ");
//					table +="\t|" + sc.nextLine();
//				}
				
				for(int i = 0; i< 3; i++) {
					table += func01(num, sc, sub[i]);
				}
				
			}else if(input.equals("2")) {
				System.out.println("------------------------");
				System.out.println(table);
				System.out.println("------------------------");
			}else System.out.println("다시 입력하세요.");
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
	
	public static String func01(int num, Scanner sc, String sub) {
		System.out.print(num + "학번 " + sub + " > ");
		return "\t|" + sc.nextLine();
	}

}
