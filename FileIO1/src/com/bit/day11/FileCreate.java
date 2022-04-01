package com.bit.day11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCreate {

	public static void main(String[] args) {
//		File file = new File("D:\\Development\\javawork\\day11\\test2.txt");
//		File file = new File("test2.txt");
		File file = new File("ex02.txt");
		if(!file.exists()) {
			try {
				boolean result = file.createNewFile();
				if(result) System.out.println("파일 생성 완료");
				else System.out.println("생성 실패");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("동일 파일명이 존재");
		}
	}
}
