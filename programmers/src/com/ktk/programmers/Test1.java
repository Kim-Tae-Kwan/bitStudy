package com.ktk.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student{
	public static int cnt;
	private final int num;
	private String name;
	private int basic, back, front;
	
	public Student(String name) {
		this.name = name;
		num = ++cnt;
	}
	
	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}
	
	public void setGrades(int[] grades) {
		setBasic(grades[0]);
		setBack(grades[1]);
		setFront(grades[2]);
	}
	
	public double getAvg() {
		return (basic + back + front)*100/3/100.0;
	}
	
}

public class Test1 {
	static Scanner sc = new Scanner(System.in);
	static Map<Integer, Student> map = new HashMap<Integer, Student>(); // key : 학번, value : Student
	
	
	public static void main(String[] args) {
		System.out.println("학생 성적 관리 프로그램 (ver 0.1.0)");
		
		int input = 0;
		while(true) {
			System.out.print("\n1.입력 2.보기 3.수정 4.삭제 5.검색 0.종료 > ");
			try {
				input = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("메뉴를 보고 다시 입력해주세요.\n");
				continue;
			}
			
			if(input == 0) {// 0.종료
				System.out.print("이용해주셔서 감사합니다.");
				break;
			}else if(input == 1) {// 1.입력
				if(Student.cnt == 30) {
					System.out.println("학생 수는 30명을 초과할 수 없습니다.");
					continue;
				}
				
				System.out.print("이름 > ");
				Student student = new Student(sc.nextLine());
				
				int[] grades = getGrades(input);
				
				student.setGrades(grades);
				map.put(student.getNum(), student);
			}else if(input == 2) {// 2.보기
				System.out.println("------------------------------------------------------");
				System.out.println("학번\t이름\t기초문법\t백엔드\t프론트\t평균");
				System.out.println("------------------------------------------------------");
				for (Integer key : map.keySet()) {
					System.out.println(getStudentInfo(key));
				}
				System.out.println("------------------------------------------------------");
			}else if(input == 3) {// 3.수정
				input = getStudentNumber(0);
				if(input == 0) continue;
				int[] grades = getGrades(input);
				map.get(input).setGrades(grades);
			}else if(input == 4) {// 4.삭제
				input = getStudentNumber(1);
				if(input == 0) continue;
				map.remove(input);
				System.out.println(input + "학번 삭제 완료.\n");
			}else if(input == 5) {// 5. 검색
				input = getStudentNumber(2);
				if(input == 0) continue;
				System.out.println("------------------------------------------------------");
				System.out.println("학번\t이름\t기초문법\t백엔드\t프론트\t평균");
				System.out.println("------------------------------------------------------");
				System.out.println(getStudentInfo(input));
				System.out.println("------------------------------------------------------");
				
				
			}else System.out.println("메뉴를 보고 다시 입력해주세요.\n");
		}
	}
	
	/*
	 * 성적 입력 받기.
	 * 각 성적을 순서대로 입력 받는다.
	 * ex)
	 * 기초문법 >
	 * 백엔드 >
	 * 프론트 >
	*/
	/**
	 * 각 성적을 순서대로 입력 받는다.
	 * @param input - 학번
	 * @return int[] - 각 과목의 점수
	 * 
	 */
	public static int[] getGrades(int input) {
		String[] sub = {"기초문법", "백엔드", "프론트"};
		int[] grades = new int[sub.length];
		for (int i = 0; i < grades.length; i++) {
			System.out.print(input + "학번 " + sub[i] + " > ");
			try {
				int num = Integer.parseInt(sc.nextLine());
				if(num > 100) {
					System.out.println("점수는 100을 초과할 수 없습니다.\n");
					i--;
					continue;
				}
				grades[i] = num;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.\n");
				i--;
			}
		}
		return grades;
	}
	
	/* 
	 * 학번 입력 받기. 
	 * option ->  0 : 수정, 1 : 삭제, 2 : 검색
	 * 숫자 및 학번 존재 유효성 검사 포함.
	 * 뒤로가기 0 반환.
	*/
	public static int getStudentNumber(int option) {
		int input = 0;
		String[] arr = {"수정", "삭제", "검색"};
		while(true) {
			System.out.print(arr[option] + "할 학번 (뒤로가기 0)> ");
			try {
				input = Integer.parseInt(sc.nextLine());
				if(input == 0) break;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요.\n");
				continue;
			}
			
			Student student = map.get(input);
			if(student == null) {
				System.out.println(input + "학번은 존재하지 않습니다.\n");
				continue;
			}
			break;
		}
		return input;
	}
	
	/*
	 * 학생 정보 얻기.
	 * ex) 학번 이름 [과목...] 평균
	 *     
	 */
	public static String getStudentInfo(int key) {
		Student student = map.get(key);
		return student.getNum() + "\t" + student.getName() + "\t" + student.getBasic() + "\t\t" + 
						  student.getBack() + "\t" + student.getFront() + "\t" + student.getAvg();
	}
	
}
