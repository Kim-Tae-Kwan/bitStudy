package com.bit.day13;

import java.util.ArrayList;
import java.util.Scanner;
//객체지향 패턴
class Student{
	static int cnt = 0;
	final int num;
	final String name;
	int kor,eng,math;
	
	public Student(String name) {
		num = ++cnt;
		this.name = name;
	}
}

public class StudentGrades2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생성적관리 프로그램(ver 0.5.1)");
		ArrayList<Student> list = new ArrayList<Student>();
		
		while(true) {
			System.out.print("1.입력 2.보기 3.수정 4.삭제 0.종료 > ");
			int input = Integer.parseInt(sc.nextLine());
			if(input == 0) break;
			else if(input == 1) {
				
				
				System.out.print("이름 > ");
				Student student = new Student(sc.nextLine());
				System.out.print("국어 > ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("영어 > ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학 > ");
				student.math = Integer.parseInt(sc.nextLine());
				
				list.add(student);
			}else if(input == 2) {
				System.out.println("----------------------------------------------");
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("----------------------------------------------");
				
				for (int i = 0; i < list.size(); i++) {
					Student stu = list.get(i);
					System.out.println(stu.num + "\t" + stu.name + "\t" + stu.kor + "\t" + stu.eng + "\t" + stu.math + "\t" + 
										(stu.kor + stu.eng + stu.math)*100/3/100.0);
				}
				
				System.out.println("----------------------------------------------");
			}else if(input == 3) {
				System.out.print("수정할 학번 > ");
				int temp = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < list.size(); i++) {
					Student student = list.get(i);
					if(temp == list.get(i).num) {
						System.out.print("국어 >");
						student.kor = Integer.parseInt(sc.nextLine());
						System.out.print("영어 >");
						student.eng = Integer.parseInt(sc.nextLine());
						System.out.print("수학 >");
						student.math = Integer.parseInt(sc.nextLine());
					}
				}
				
			}else if(input == 4) {
				System.out.print("삭제할 학번 > ");
				int temp = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < list.size(); i++) {
					Student student = list.get(i);
					if(temp == list.get(i).num) {
						list.remove(i);
					}
				}
			}
		}
	}
}
