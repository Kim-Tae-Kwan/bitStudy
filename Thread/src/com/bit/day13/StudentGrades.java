package com.bit.day13;

import java.util.ArrayList;
import java.util.Scanner;

//전형적인 패턴
//쓰레기....
public class StudentGrades {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생성적관리 프로그램(ver 0.5.0)");
		ArrayList<String> data = new ArrayList<String>();
		int num = 0;
		while(true) {
			System.out.print("1.입력 2.보기 3.수정 4.삭제 0.종료 > ");
			int input = Integer.parseInt(sc.nextLine());
			if(input == 0) break;
			else if(input == 1) {
				num ++;
				data.add(num + "");
				System.out.print(num + "번 이름>");
				data.add(sc.nextLine());
				System.out.print(num + "번 국어>");
				data.add(sc.nextLine());
				System.out.print(num + "번 영어>");
				data.add(sc.nextLine());
				System.out.print(num + "번 수학>");
				data.add(sc.nextLine());
			}else if(input == 2) {
				System.out.println("----------------------------------------------");
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("----------------------------------------------");
				for (int i = 0; i < data.size(); i++) {
					double avg = (Integer.parseInt(data.get(i+2).toString())
							     + Integer.parseInt(data.get(i+3).toString())
							     + Integer.parseInt(data.get(i+4).toString())
							     )*100/3/100.0;
					System.out.println(data.get(i++) + "\t" + data.get(i++) + "\t" + data.get(i++) + "\t" + data.get(i++) + "\t" + data.get(i) + "\t" + avg);
				}
				System.out.println("----------------------------------------------");
			}else if(input == 3) {
				System.out.print("수정할 학번 > ");
				String msg = sc.nextLine();
				int i;
				for (i = 0; i < data.size(); i+=5) {
					if(msg.equals(data.get(i))) {
						break;
					}
				}
				if(i < data.size()) {
					System.out.print(i+1 + "번 국어>");
					data.set(i+2, sc.nextLine());
					System.out.print(i+1 + "번 영어>");
					data.set(i+3, sc.nextLine());
					System.out.print(i+1 + "번 수학>");
					data.set(i+4, sc.nextLine());
				}else {
					System.out.println("없음");
				}
				
			}else if(input == 4) {
				
			}
			
			
		}
		
	}

}
