package com.bit.day12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Ex18 {

	public static void main(String[] args) {
		File file = new File("test08.txt");
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			
			osw.write("문자열 잘 작성됩니다...");
			
			
			osw.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
