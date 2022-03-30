package com.bit.day11;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex15 {

	public static void main(String[] args) {
		String msg = "abcdefg";
		File file = new File("test11.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		long be, af;
		
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			be = System.currentTimeMillis();
			
			byte[] arr = msg.getBytes();
//			for (int i = 0; i < arr.length; i++) {
//				bos.write(arr[i]);
//			}
			
			bos.write(arr);
			
			bos.close();
			fos.close();
			af = System.currentTimeMillis();
			System.out.println(af - be + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
