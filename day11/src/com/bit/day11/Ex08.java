package com.bit.day11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex08 {
	// 파일 입출력.
	public static void main(String[] args) {
		File file = new File("test01.txt");
		try {
			if(!file.exists()) file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 바이트 스트림
		// 기본 단위    : 1byte.
		// inputStream  : 읽기.
		// outputStream : 쓰기.
		String msg = "abcd";
		byte[] arr = msg.getBytes();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			
			for (int i = 0; i < arr.length; i++) {
				fos.write(arr[i]);
			}
			
//			fos.write(-22); // 1byet 씩 작성.
//			fos.write(-80);
//			fos.write(-128);
//			fos.write(66);
//			fos.write(67);
//			fos.write(68);
			
			fos.close();
			System.out.println("작성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}

}
