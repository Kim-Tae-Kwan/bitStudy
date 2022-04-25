package com.bit.day04;
/*
학생 성적관리 프로그램(ver 0.1.0)
한 학생의 성적을 통해 다음을 출력하시오.
요구사항
 - 과목은 3과목
 - 과목별 성적은 국어:84,영어:93,수학:70
 - 매 실행시 성적은 변경될 것임
 - 평균은 소수점 2자리까지만 출력


결과
--------------------------------------
국어:84     영어:93     수학:70
--------------------------------------
합계:000
평균:00.00
--------------------------------------
학점:B학점

(100~90이상:A, 90미만~80이상:B, 80미만~70이상:C, 70미만~60이상:D, 60미만:F)
 
 */
class Exam{
	public int kor;
	public int eng;
	public int math;
	
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}
	
	public double getAverage() {
		int total = this.getTotal();
		return total / 3.0; 
	}
	
	public String getGrade() {
		int avg = (int)this.getAverage();
		if(avg < 60) return "F";
		else if(avg < 70) return "D";
		else if(avg < 80) return "C";
		else if(avg < 90) return "B";
		else return "A";
	}
	
	public void print() {
		System.out.println("결과");
		System.out.println("--------------------------------------");
		System.out.println("국어:" + this.kor + "\t영어:" + this.eng + "\t수학:" + this.math);
		System.out.println("--------------------------------------");
		System.out.println("합계:" + this.getTotal());
		System.out.println("평균:" + String.format("%.2f", this.getAverage()));
		System.out.println("--------------------------------------");
		System.out.println("학점:" + this.getGrade() + "학점");
		
	}
}
public class Ex08 {
	public static void main(String[] args) {
		Exam exam = new Exam(84, 93, 70);
		exam.print();
	}
}
