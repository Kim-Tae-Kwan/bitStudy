package com.bit.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex10 {

	public static void main(String[] args) throws IOException{
		File origin = new File("D:\\Development\\javawork\\day11\\Dir.java");
		File copy = new File("./copy.java");
		
		if(!copy.exists()) copy.createNewFile();
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		fis = new FileInputStream(origin);
		fos = new FileOutputStream(copy);
		
		for (long i = 0; i < origin.length(); i++) {
			fos.write(fis.read());
		}
		
		fis.close();
		fos.close();
		System.out.println("복사완료");
	}

}
