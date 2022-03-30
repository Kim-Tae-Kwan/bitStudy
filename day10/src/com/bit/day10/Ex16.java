package com.bit.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.imageio.IIOException;

public class Ex16 {

	public static void main(String[] args) throws FileNotFoundException {
		// Directory 감시
		// 폴더에 새로운 파일이 들어오면 읽어서 콘솔에 출력.
		
		String root = "D:\\";
		File dir = new File(root);
		List<String> fileList = new ArrayList<>();
		fileList.addAll(Arrays.asList(dir.list()));
		int cnt = fileList.size();
		
		while(true) {
			String[] dirList = dir.list();
			if(cnt != dirList.length) {
				int i;
				for (i = 0; i < dirList.length; i++) {
					if(!fileList.contains(dirList[i])) break;
				}
				cnt++;
				fileList.add(dirList[i]);
				String filePath = root + "\\" + dirList[i];
				Scanner scanner = new Scanner(new File(filePath));
				while (scanner.hasNext()) {
					String str = scanner.nextLine();
					System.out.println(str);
				}
				
				System.out.println("------------------------------------------\n");
				
			}
		}
	}
}
