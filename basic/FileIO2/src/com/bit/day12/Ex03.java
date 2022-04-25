package com.bit.day12;

import java.io.File;
import java.io.FileInputStream;

public class Ex03 {

	public static void main(String[] args) {
		File file = new File("test01.txt");
		FileInputStream fis = null;
		
		byte[] buf = new byte[16];
		
		try {
			if(!file.exists()) file.createNewFile();
			fis = new FileInputStream(file);
			
			for (int i = 0; i < buf.length; i++) {
				buf[i] = (byte)fis.read();
			}
			
			System.out.println(new String(buf));
			
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
