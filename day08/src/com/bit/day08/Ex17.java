package com.bit.day08;

import java.util.Scanner;

class Grades {
	public int kor;
	public int eng;
	public int math;

	public Grades(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void update(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void delete() {
		kor = 0;
		eng = 0;
		math = 0;
	}
}

class GradesService{
	Scanner sc;
	Grades[] gradesArray;
	boolean exit;
	int nextIndex;
	int lastIndex;
	
	public GradesService() {
		sc = new Scanner(System.in);
		gradesArray = new Grades[5];
		exit = false;
		nextIndex = 0;
		lastIndex = gradesArray.length - 1;
	}
	
	public void printTitle() {
		System.out.println("학생 성적 관리 프로그램(ver 0.3.0)");
	}
	
	public String menu() {
		System.out.print("\n1.입력 2.보기 3.수정 4.삭제 0.종료 >");
		return sc.nextLine();
	}
	
	// 1. 입력
	public void input() {
		int[] grades = getGrades();
		
		if(lastIndex < nextIndex) {
			increaseArray();
		}
		
		gradesArray[nextIndex++] = new Grades(grades[0], grades[1], grades[2]);
	}
	
	// 2. 보기
	public void printGrades() {
		System.out.println("---------------------------------");
		System.out.println("학번\t|국어\t|영어\t|수학");
		
		for (int i = 0; i < nextIndex; i++) {
			System.out.println((i + 1) + "\t|" + gradesArray[i].kor + "\t|" + gradesArray[i].eng + "\t|" + gradesArray[i].math);
		}
		
		System.out.println("---------------------------------");
	}
	
	// 3. 수정
	public void update() {
		System.out.print("수정할 학번 입력 > ");
		int num = getStudentNumber();
		
		int[] grades = getGrades(num);
		
		gradesArray[num - 1].update(grades[0], grades[1], grades[2]);
	}
	
	// 4. 삭제
	public void delete() {
		System.out.print("삭제할 학번 입력 > ");
		int num = getStudentNumber();
		gradesArray[num - 1].delete();
	}
	
	// 0. 종료
	public void exit(){
		sc.close();
		exit = true;
		System.out.println("이용해주셔서 감사합니다.");
	}
	
	public int[] getGrades() {
		return getGrades(nextIndex + 1);
	}
	
	//성적을 순서대로 입력 받음.
	private int[] getGrades(int num) {
		int[] grades = new int[3];
		String[] gradesNames = {"국어", "영어", "수학"};
		
		for (int i = 0; i < grades.length; i++) {
			System.out.print(num +" 학번 " + gradesNames[i] +" >");
			grades[i] = Integer.parseInt(sc.nextLine());
		}
		
		return grades;
	}
	
	// 성적 배열 full일 경우, 배열을 증가 시킴.
	private void increaseArray() {
		Grades[] newGradesArray = new Grades[nextIndex * 2];
		for (int i = 0; i < gradesArray.length; i++) {
			newGradesArray[i] = gradesArray[i];
		}
		
		gradesArray = newGradesArray;
		lastIndex = gradesArray.length - 1;
	}
	
	
	// 학번을 입력 받고 존재하는지 검사.
	private int getStudentNumber(){
		int num = 0;
		while(true) {
			num = Integer.parseInt(sc.nextLine());
			if(num - 1 >= nextIndex || num <= 0) {
				System.out.println(num + " 학번은 존재하지 않습니다.");
				System.out.print("다시 학번을 입력하시오 > ");
			}else break;
		}
		
		return num;
	}
}

public class Ex17 {

	public static void main(String[] args) {
		// 학생 성적 관리 프로그램(ver 0.3.0)
		// 1.입력 2.보기 [3.수정 4.삭제] 0.종료 >
		// 학번 국어 영어 수학
		// -------------------
		// 입력에 제한이 없도록 제작하시오. (학생 수의 제한없음)
		// 배열을 사용하시오.
		// 컬렉션 프레임워크 금지.
		
		GradesService gs = new GradesService();
		gs.printTitle();
		while (!gs.exit) {
			switch (gs.menu()) {
			case "1":
				gs.input();
				break;
			case "2":
				gs.printGrades();
				break;
			case "3":
				gs.update();
				break;
			case "4":
				gs.delete();
				break;
			case "0":
				gs.exit();
				break;
			default:
				System.out.println("메뉴 확인 후 다시 입력하세요");
				break;
			}
		}

	}

}
