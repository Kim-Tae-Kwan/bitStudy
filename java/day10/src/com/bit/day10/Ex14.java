package com.bit.day10;

import java.io.File;
import java.text.*;
import java.util.*;

public class Ex14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd a HH:MM");
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		
		while(true){
			System.out.print(">");
			String[] input = sc.nextLine().split(" ");
			
			if(!input[0].equals("dir") || input.length <= 1) {
				System.out.println("명령어를 다시 입력하세요.\n");
				continue;
			}
			
			String path = input[1];
			File root = new File(path);
			
			if(root.exists()) {
				String[] list = root.list();
				
				int fileCnt = 0;
				long fileSize = 0L;
				int dirCnt = 0;
				for(String fileName : list) {
					File file = new File(path + "\\" +fileName);
					String dirString = "";
					String size = "";
					String lastMod = "";
					
					lastMod = dtFormat.format(new Date(file.lastModified()));
					
					if(file.isDirectory()) {
						dirCnt++;
						dirString = "<DIR>";
						 
					}else {
						size = decimalFormat.format(file.length());
						fileCnt++;
						fileSize += file.length();
					}
					System.out.println(lastMod + "\t" + dirString + "\t" + size + "\t" + fileName);
					
				}
				
				System.out.println("\t\t" + fileCnt + "개 파일\t\t" + decimalFormat.format(fileSize) + " 바이트");
				System.out.println("\t\t" + dirCnt + "개 디렉토리\t\t" + decimalFormat.format(root.getFreeSpace()) + " 바이트 남음");
			}else {
				System.out.println("지정된 경로를 찾을 수 없습니다.\n");
				continue;
			}
		}
		 
	}

}
