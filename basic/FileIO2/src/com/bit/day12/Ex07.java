package com.bit.day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex07 {

	public static void main(String[] args) {
		File file = new File("test04.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			if(!file.exists()) file.createNewFile();
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write("첫째줄");
			bw.newLine();
			bw.write("두째줄");
			bw.newLine();
			bw.write("세째줄");
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
