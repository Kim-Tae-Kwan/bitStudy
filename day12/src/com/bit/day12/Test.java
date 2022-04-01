package com.bit.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Grades {
	private int basic;
	private int backEnd;
	private int frontEnd;

	public Grades(int basic, int backEnd, int frontEnd) {
		this.basic = basic;
		this.backEnd = backEnd;
		this.frontEnd = frontEnd;
	}
	
	public Grades(int[] grades) {
		this.basic = grades[0];
		this.backEnd = grades[1];
		this.frontEnd = grades[2];
	}
	
	public void delete() {
		basic = 0;
		backEnd = 0;
		frontEnd = 0;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getBackEnd() {
		return backEnd;
	}

	public void setBackEnd(int backEnd) {
		this.backEnd = backEnd;
	}

	public int getFrontEnd() {
		return frontEnd;
	}

	public void setFrontEnd(int frontEnd) {
		this.frontEnd = frontEnd;
	}
	
	public int getTotal() {
		return basic + backEnd + frontEnd;
	}
	
	public double getAvg() {
		int total = getTotal();
		return total / 3.0;
	}
}

class Student{
	public static int count = 0;
	private final int number;
	private Grades grades;
	private String name;
	
	public Student(Grades grades, String name) {
		this.number = ++count;
		this.grades = grades;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public Grades getGrades() {
		return grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void updateGrades(Grades grades) {
		this.grades = grades;
	}
}

class GradesService{
	Scanner sc;
	List<Student> students;
	List<Integer> delList;
	boolean exit;
	
	public GradesService() {
		sc = new Scanner(System.in);
		students = new ArrayList<Student>();
		delList = new ArrayList<Integer>();
		exit = false;
	}
	
	public void printTitle() {
		System.out.println("학생 성적 관리 프로그램(ver 0.1.0)");
	}
	
	public String menu() {
		System.out.print("\n1.입력 2.보기 3.수정 4.삭제 0.종료 >");
		return sc.nextLine();
	}
	
	// 1. 입력
	public void input() {
		if(Student.count > 30) {
			System.out.print("학생 수는 30명을 초과할 수 없습니다.");
			return;
		}
		
		System.out.print("학생의 이름을 입력하시오. > ");
		String name = sc.nextLine();
		Grades grades = getGrades();
		
		Student student = new Student(grades, name);
		students.add(student);
	}
	
	// 2. 보기
	public void printGrades() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("학번\t|이름\t\t|기초문법\t|백엔드\t|프론트엔드\t|평균");
		
		for (Student student : students) {
			System.out.println(student.getNumber() + "\t|" + student.getName() + "\t\t|" + student.getGrades().getBasic() + "\t\t|" + student.getGrades().getBackEnd() + "\t|" + student.getGrades().getFrontEnd() + "\t\t|" + String.format("%.2f", student.getGrades().getAvg()));
		}
		
		System.out.println("--------------------------------------------------------------------------");
	}
	
	// 3. 수정
	public void update() {
		System.out.print("수정할 학번 입력 (뒤로가기 0)> ");
		int num = getStudentNumber();
		
		if(num == 0) return;
		
		Grades grades = getGrades();
		
		if(grades == null) return;
		
		Student student = students.get(num - 1);
		student.updateGrades(grades);
	}
	
	// 4. 삭제
	public void delete() {
		System.out.print("삭제할 학번 입력 (뒤로가기 0)> ");
		int num = getStudentNumber();
		
		if(num == 0) return;
		
		students.remove(num - 1);
		delList.add(num);
	}
	
	// 0. 종료
	public void exit(){
		sc.close();
		exit = true;
		System.out.println("이용해주셔서 감사합니다.");
	}
	
	//성적을 순서대로 입력 받음.
	private Grades getGrades() {
		int[] grades = new int[3];
		String[] gradesNames = {"기초문법", "백엔드", "프론트엔드"};
		
		for (int i = 0; i < grades.length; i++) {
			System.out.print(gradesNames[i] +" >");
			try {
				int input = Integer.parseInt(sc.nextLine());
				if(input > 100) {
					System.out.println("점수는 100 점을 초과할 수 없습니다.\n");
					i--;
					continue;
				}else if(input == 0) {
					return null;
				}
				
				grades[i] = input;	
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.\n");
				i--;
			}
		}
		
		return new Grades(grades);
	}
	
	// 학번을 입력 받고 존재하는지 검사.
	private int getStudentNumber(){
		int num = 0;
		while(true) {
			try {
				num = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.print("숫자만 입력하세요. (뒤로 가기 0)> ");
				continue;
			}
			
			if(num > Student.count || delList.contains(num)) {
				System.out.println(num + " 학번은 존재하지 않습니다.\n");
				System.out.print("다시 입력하세요. (뒤로 가기 0)> ");
			}else break;
		}
		
		return num;
	}
}

public class Test {

	public static void main(String[] args) {
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
