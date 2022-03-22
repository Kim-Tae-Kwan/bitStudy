package com.bit.day05;

import java.util.Scanner;

class GradesManager{
	public int studentNum;
	public Scanner sc;
	public Grades[] grades;
	
	public GradesManager() {
		this.studentNum = 0;
		this.sc = new Scanner(System.in);
		this.grades = new Grades[5];
	}
	public void printTitle() {
		System.out.println("학생 성적관리 프로그램(ver 0.2.0)");
		System.out.println("---------------------------------");
	}
	public void enterGrades() {
		int num = studentNum + 1;
		
		System.out.print(num + "학번 국어 > ");
		String kor = sc.nextLine();
		
		System.out.print(num + "학번 영어 > ");
		String eng = sc.nextLine();
		
		System.out.print(num + "학번 수학 > ");
		String math = sc.nextLine();
		
		this.grades[studentNum++] = new Grades(kor, eng, math);
	}
	public void resultPrint() {
		System.out.println("---------------------------------");
		System.out.println("학번\t|국어\t|영어\t|수학");
		
		for(int i = 0; i < studentNum; i++) {
			Grades exam = grades[i];
			System.out.println((i+1) + "\t|" + exam.getKor() + "\t|" + exam.getEng() + "\t|" + exam.getMath());
		}
		
		System.out.println("---------------------------------");
	}
	public void exit() {
		System.out.println("이용해주셔서 감사합니다.");
		sc.close();
	}
	public void paly() {
		printTitle();
		
		while(true) {
			System.out.print("1.입력 2.결과 0.종류 > ");
			String input = sc.nextLine();
			
			if(input.equals("1")) enterGrades();
			else if(input.equals("2")) resultPrint();
			else if(input.equals("0")) {
				exit();
				break;
			}
		}
	}
}

class Grades{
	public String kor;
	public String eng;
	public String math;
	
	public Grades(String kor, String eng, String math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getKor() {
		return kor;
	}
	
	public String getEng() {
		return eng;
	}
	
	public String getMath() {
		return math;
	}
}

public class Ex11 {

	public static void main(String[] agrs) {
		GradesManager gm = new GradesManager();
		gm.paly();
	}
}
