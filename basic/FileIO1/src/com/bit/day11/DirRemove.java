package com.bit.day11;

import java.io.File;

public class DirRemove {

	public static void main(String[] args) {
		File file = new File("test01");
		boolean result = file.delete();
		if(!result) {
			String[] arr = file.list();
			for (int i = 0; i < arr.length; i++) {
				File temp = new File(file.getName() + "\\" +arr[i]);
				temp.delete();
			}
		}
		
//		if(result) System.out.println("디렉토리 삭제 완료");
//		else System.out.println("디렉토리 삭제 실패");
	}
}
