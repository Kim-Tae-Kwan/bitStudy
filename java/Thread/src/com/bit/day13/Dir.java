package com.bit.day13;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dir {

	public static void main(String[] args) {
		String path = "D:\\Development\\javawork\\Thread";
		path = ".";
		File file = new File(path);
		if(file.exists()) {
			try {
				path = file.getCanonicalPath();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			file = new File(path);
			if(file.isDirectory()) {
				String[] list = file.list();
				for (int i = 0; i < list.length; i++) {
					File temp = new File(path + "\\" +list[i]);
					fileInfo(temp);
				}
			}else {
				File temp = file;
				fileInfo(temp);
			}
		}else System.out.println("파일 없음.");
	}
	
	//파일의 정보를 출력. (YYYY-MM-dd a.p HH:mm [<DIR>] [fileSize] fileName)
	public static void fileInfo(File temp) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd a HH:mm");
		String date = sdf.format(new Date(temp.lastModified()));
		System.out.print(date + "\t");
		if(temp.isDirectory()) {
			System.out.print("<DIR>\t\t");
		}else System.out.print("\t" + temp.length() + "\t");
		
		System.out.println(temp.getName());
	}

}
