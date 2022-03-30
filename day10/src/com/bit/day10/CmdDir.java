package com.bit.day10;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CmdDir {

	static SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd a HH:MM");
	static DecimalFormat decimalFormat = new DecimalFormat("###,###");
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String directoryName = System.getProperty("user.dir");

		while(true) {
			System.out.print(directoryName + ">");
			String[] input = sc.nextLine().split(" ");
			
			if(!input[0].equals("dir") || input.length <= 1) {
				System.out.println("명령어를 다시 입력하세요.\n");
				continue;
			}
			
			String path = input[1];
			String[] list = new File(path).list();
			
			for (int i = 0; i < list.length; i++) {
				String filePath = path + "\\" +list[i];
				String output = getInfo(filePath);
				System.out.println(output);
			}
		}
	}
	
	public static String getInfo(String path) {
		File file = new File(path);
		String output = "";
		output += dtFormat.format(new Date(file.lastModified()));
		if(file.isDirectory()) {
			
			output += "    <DIR>          ";
		}else {
			int middleLength = 17;
			String size = decimalFormat.format(file.length());
			for (int i = 0; i < middleLength - size.length() + 1; i++) {
				output += " ";
			}
			output += size + " ";
		}
		
		output += file.getName();
		return output;
	}

}
