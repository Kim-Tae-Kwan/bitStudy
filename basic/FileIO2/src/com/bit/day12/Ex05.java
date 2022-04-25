package com.bit.day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Ex05 {

	public static void main(String[] args) {
		File file = new File("test01.txt");
		File copy = new File("test02.txt");
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			if(!file.exists()) file.createNewFile();
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			fw = new FileWriter(copy);
			bw = new BufferedWriter(fw);
			
			int su = -1;
			while((su = br.read()) != -1) {
				bw.write(su);
			}
			
			
			
			bw.close();
			fw.close();
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
