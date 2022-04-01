package com.bit.day11;

import java.io.*;

public class Ex11 {
	//버퍼 이용하여 속도 개선
	public static void main(String[] args) {
		String msg = "";
		for (int i = 0; i < 100000; i++) {
			msg += i;
		}
		
		byte[] buf = msg.getBytes();
		long before, after;
		
		File file = new File("test11.txt");
		FileOutputStream fos = null;
		try {
			if(!file.exists()) file.createNewFile();
			fos = new FileOutputStream(file);
			
			before = System.currentTimeMillis();
			for (int i = 0; i < buf.length; i++) {
				fos.write(buf[i]);
			}

			fos.close();
//			fos.write(buf,0,buf.length); //버퍼(배열) 사용.
//			fos.close();
			after = System.currentTimeMillis();
			System.out.println("작성 완료: " + (after - before) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
