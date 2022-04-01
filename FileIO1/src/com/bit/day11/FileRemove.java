package com.bit.day11;

import java.io.File;

public class FileRemove {

	public static void main(String[] args) {
//		File file = new File("D:\\Development\\javawork\\day11\\test2.txt");
		File file = new File("test2.txt");
		if(file.exists()) {
			boolean result = file.delete();
			if(result) System.out.println("삭제완료.");
			else System.out.println("삭제실패.");
		}else System.out.println("존재하지 않습니다.");
	}

}
