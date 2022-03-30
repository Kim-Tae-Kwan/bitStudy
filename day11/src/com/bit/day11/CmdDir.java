package com.bit.day11;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CmdDir {

	static SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd a HH:MM");
	static DecimalFormat decimalFormat = new DecimalFormat("###,###");
	
	public static void main(String[] args) {

		if(args.length == 0) {
			args = new String[1];
			args[0] = "D:\\";
//			args[0] = ".";
		}
		
		
		String rootPath = args[0];
		System.out.println(new File(rootPath).getAbsolutePath());
//		File root = new File(new File(rootPath).getAbsolutePath()); // 절대경로로 File 객체 생성.
		File root = new File(rootPath);
		
		String[] list = root.list();
		if(root.getParent() != null) {
			String[] temp = new String[list.length + 2];
			temp[0] = ".";
			temp[1] = "..";
			System.arraycopy(list, 0, temp, 2, list.length);
			list = temp;
		}
		
		int fileCnt = 0;
		long fileSize = 0L;
		int dirCnt = 0;
		for (int i = 0; i < list.length; i++) {
			String absolutePath = rootPath + "\\" +list[i];
			File file = new File(absolutePath);
			
			if(file.isFile()) {
				fileCnt++;
				fileSize += file.length();
			}else dirCnt++;
			
			System.out.println(getInfo(file));
		}
		
		
		
		
		
		int middleCnt = 20;
		String filesSize = "";
		for (int i = 0; i < 12; i++) {
			filesSize += " ";
		}
		filesSize += fileCnt + "개 파일";
		for (int i = 0; i < middleCnt - decimalFormat.format(fileSize).length(); i++) {
			filesSize += " ";
		}
		filesSize += decimalFormat.format(fileSize) + " 바이트";
		System.out.println(filesSize);
		
		
		
		middleCnt = 18;
		String dirsSize = "";
		for (int i = 0; i < 12; i++) {
			dirsSize += " ";
		}
		dirsSize += dirCnt + "개 디렉토리";
		for (int i = 0; i < middleCnt - decimalFormat.format(root.getTotalSpace()).length(); i++) {
			dirsSize += " ";
		}
		dirsSize += decimalFormat.format(root.getTotalSpace()) + " 바이트 남음";
		System.out.println(dirsSize);
		
	}
	public static String getFileInfo(File file) {
		
		return "";
	}
	
	public static String getDirInfo(File file) {
		return "";
	}
	
	public static String getInfo(File file) {
		StringBuilder sb = new StringBuilder();
		sb.append(dtFormat.format(new Date(file.lastModified())));
		if(file.isDirectory()) {
			sb.append("    <DIR>          ");
		}else {
			int middleLength = 17;
			String size = decimalFormat.format(file.length());
			for (int i = 0; i < middleLength - size.length() + 1; i++) {
				sb.append(" ");
			}
			sb.append(size + " ");
		}
		sb.append(file.getName());
		return sb.toString();
	}

}
