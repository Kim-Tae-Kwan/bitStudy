package com.bit.day12;

import java.io.File;
import java.io.FileWriter;

public class Ex01 {
	// 문자열 스트림 (2Byte)
	
	public static void main(String[] args) {
		File file = new File("test01.txt");
		FileWriter fw = null;
		try {
			if(!file.exists()) file.createNewFile();	
			fw = new FileWriter(file);
			
			fw.write('가'); // AutoCasting '가' -> 97
			fw.write('나');
			fw.write('다');
			fw.write(' ');
			fw.write('라');
			fw.write('마');
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
