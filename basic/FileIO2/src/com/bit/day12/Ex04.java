package com.bit.day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Ex04 {

	public static void main(String[] args) {
		File file = new File("test01.txt");
		File copy = new File("test02.txt");
		FileReader fr = null;
		FileWriter fw = null;
		char[] cbuf = new char[10];
		try {
			if(!file.exists()) file.createNewFile();
			fr = new FileReader(file);
			fw = new FileWriter(copy);
			
			while(true) {
				int su = fr.read(cbuf,0,3);
				if(su == -1) break;
				System.out.println(Arrays.toString(cbuf));
				fw.write(cbuf,0,su);
			}
			
			fw.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
