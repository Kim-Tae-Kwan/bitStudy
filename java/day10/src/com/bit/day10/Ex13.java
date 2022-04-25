package com.bit.day10;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;

public class Ex13 {
	public static void main(String[] args) throws IOException {
		// 절대 경로
		// 상대 경로 
		
		String path = "D:\\Development\\javawork\\day10";
//		String path = "D:\\Development\\javawork\\day10";
		File file = new File(path);
		
//		System.out.println("존재 하냐 ? " + file.exists());
//		System.out.println("디렉토리냐? " + file.isDirectory());
//		System.out.println("파일이냐  ? " + file.isFile());
//		System.out.println("경로1  ? " + file.getParent());
//		System.out.println("경로2 ? " + file.getPath());
//		System.out.println("절대경로1 ? " + file.getAbsolutePath());
//		System.out.println("절대경로2 ? " + file.getCanonicalPath());
//		System.out.println("파일명 ? " + file.getName());
//		System.out.println("r권한 ? " + file.canRead());
//		System.out.println("w권한 ? " + file.canWrite());
//		System.out.println("x권한 ? " + file.canExecute());
//		System.out.println("사이즈 ? " + file.length() + "byte");
//		System.out.println("마지막 수정일자 ? " + new Date(file.lastModified()));
//		System.out.println(Arrays.toString(file.list()));
		System.out.println(file.getFreeSpace());
	}
}
