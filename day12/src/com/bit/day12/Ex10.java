package com.bit.day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Ex10 {

	public static void main(String[] args) {
		File file = new File("test04.txt");

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			
			pw.println("첫번째줄");
			pw.println("두번째줄의 내용");
			pw.println("세번째줄의 내용");
			
			pw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
