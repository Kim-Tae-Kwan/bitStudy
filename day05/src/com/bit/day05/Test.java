package com.bit.day05;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[][] grades = new String[100][3];
		int nextIndex = 0;
		
		System.out.println("학생 성적관리 프로그램(ver 0.2.0)");
		System.out.println("---------------------------------");
		
		while(true) {
			System.out.print("1.입력 2. 결과 0.종류 > ");
			String input = sc.nextLine();
			
			if(input.equals("1")) {
				int num = nextIndex + 1;
				System.out.print(num + "학번 국어 > ");
				String kor = sc.nextLine();
				System.out.print(num+ "학번 영어 > ");
				String eng = sc.nextLine();
				System.out.print(num + "학번 수학 > ");
				String math = sc.nextLine();
				
				grades[nextIndex][0] = kor;
				grades[nextIndex][1] = eng;
				grades[nextIndex][2] = math;
				nextIndex++;
				
			}else if(input.equals("2")) {
				System.out.println("---------------------------------");
				System.out.println("학번\t|국어\t|영어\t|수학");
				
				for(int i = 0; i < nextIndex; i++) {
					System.out.println((i+1) + "\t|" + grades[i][0] + "\t|" + grades[i][1] +"\t|" + grades[i][2]);
				}
				
				System.out.println("---------------------------------");
			}else if(input.equals("0")) {
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
		}
		
	}

}
