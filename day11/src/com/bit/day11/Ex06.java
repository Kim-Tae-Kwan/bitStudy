package com.bit.day11;

import java.io.File;

public class Ex06 {

	public static void main(String[] args) {
		// 바꿀 File 객체가 필요.
		// 경로 변경시 이동함.
		
		File before = new File("ex01.txt");
		File after = new File("test02\\ex02.txt"); //이동.
		
		boolean result = before.renameTo(after);
		System.out.println(result);
	}

}
