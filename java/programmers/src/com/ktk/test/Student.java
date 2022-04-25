package com.ktk.test;

public class Student {
	public static int cnt = 0;
	private int num;
	private String name;
	private int kor, eng, math;

	public Student(String name) {
		this.name = name;
	}

	public static void setCnt(int cnt) {
		Student.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public void setGrades(int[] grades) {
		this.kor = grades[0];
		this.eng = grades[1];
		this.math = grades[2];
	}

	public double getAvg() {
		return (kor + eng + math) * 100 / 3 / 100.0;
	}
}
