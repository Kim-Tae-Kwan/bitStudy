package com.bit.day12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Ex13 {

	public static void main(String[] args) {
		File file = new File("test03.txt");
		FileInputStream fis = null;
		//메모리 적재.
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		try {
			fis = new FileInputStream(file);
			baos = new ByteArrayOutputStream();
			
			while(true) {
				int su = fis.read();
				if(su == -1) break;
				baos.write(su);
			}
			bais = new ByteArrayInputStream(baos.toByteArray());
			while(true) {
				int su = bais.read();
				if(su == -1) break;
				System.out.println();
			}
			
			bais.close();
			baos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
