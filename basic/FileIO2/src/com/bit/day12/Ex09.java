package com.bit.day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ex09 {

	public static void main(String[] args) {
		File file = new File("test04.txt");
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
				
			while(true) {
				String msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
