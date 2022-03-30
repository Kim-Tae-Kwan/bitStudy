package com.bit.day11;

import java.io.File;
import java.io.FileInputStream;

public class Ex09 {

	public static void main(String[] args) {
		File file = new File("test01.txt");
		FileInputStream fis = null;
		byte[] arr = new byte[(int)file.length()];
		if(file.exists()) {
			try {
				fis = new FileInputStream(file);

//				for (int i = 0; i < arr.length; i++) {
//					arr[i] = (byte)fis.read();
//				}
				
				while(true) {
					int su = fis.read();
					if(su == -1) break;
					System.out.println(su);
				}
				
				System.out.println(new String(arr));
				
				
//				System.out.print((byte)fis.read());
//				System.out.print((byte)fis.read());
//				System.out.print((byte)fis.read());
//				System.out.print(fis.read());
//				System.out.print(fis.read());
//				System.out.print(fis.read());
				
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
