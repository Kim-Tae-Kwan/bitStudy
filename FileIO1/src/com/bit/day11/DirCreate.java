package com.bit.day11;

import java.io.File;
import java.util.Arrays;

public class DirCreate {

	public static void main(String[] args) {
		String path = "test01\\sub01";
		File file = new File("test01\\sub01");
//		String[] arr = path.split("\\\\"); // \\ -> \\\\
//		
//		String path1 = "";
//		for (int i = 0; i < arr.length; i++) {
//			if(i !=0 ) path1 +="\\";
//			path1 += arr[i];
//			File before = new File(path1);
//			before.mkdir();
//		}

		//상위 폴더부터 생성하기.
		String parent = file.getParent();
		File before = file;
		while(true) {
			String path1 = before.getParent();
			try {
				before = new File(path1);
				before.mkdir();
				before = file;
				if(before.getParent().equals(parent)) break;
			} catch (Exception e) {
				continue;
			}
		}
		file.mkdir();
	}
}
