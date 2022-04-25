package com.bit.day12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex06 {

	public static void main(String[] args) {
		File file = new File("test03.txt");
		FileWriter fw = null;
		FileReader fr = null;
		try {
			if(!file.exists()) file.createNewFile();
			fw = new FileWriter(file);
			fr = new FileReader(file);
			
			fw.write("문자열을 문자열스트림을 통해 바로 작성.");
			fw.write("\n");
			fw.write("다음 줄 작성");
			fw.write("\n");
			fw.write("또 다음줄 작성");
			
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
