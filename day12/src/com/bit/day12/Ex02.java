package com.bit.day12;

import java.io.File;
import java.io.FileReader;

public class Ex02 {

	public static void main(String[] args) {
		File file = new File("test01.txt");
		FileReader fr = null;
		try {
			if(!file.exists()) file.createNewFile();	
			fr = new FileReader(file);
			
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
			
			
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
