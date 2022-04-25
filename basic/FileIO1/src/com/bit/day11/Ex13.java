package com.bit.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex13 {

	public static void main(String[] args) throws IOException{
		File origin = new File("Dir.java");
		File copy = new File("copy.java");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] buf = new byte[1024];
		
		try {
			if(!copy.exists()) copy.createNewFile();
			fis = new FileInputStream(origin);
			fos = new FileOutputStream(copy);
			
			while (true) {
				int cnt = fis.read(buf);
				if(cnt == -1) break;
				
				fos.write(buf, 0, cnt);
			}
			
			fis.close();
			fos.close();
			System.out.println("복사완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
