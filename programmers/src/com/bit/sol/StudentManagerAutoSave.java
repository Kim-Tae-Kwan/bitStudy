package com.bit.sol;

import java.io.*;
import java.util.*;

public class StudentManagerAutoSave extends Thread{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = "";
		System.out.println("성적관리 프로그램 (ver 0.5.9)");
		File file = new File("data.txt");
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			if(!file.exists()) file.createNewFile();
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) break;
				data += msg + "\n";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String input = "";
		while(true) {
			System.out.print("1.입력 2.보기 3.수정 4.삭제 0.종료 > ");
			input = sc.nextLine();
			if(input.equals("0")) break;
			else if(input.equals("1")) {
				String[] title = "학번\t이름\t국어\t영어\t수학\t평균".split("\t");
				for (int i = 0; i < title.length - 1; i++) {
					System.out.print(title[i] + " > ");
					input = sc.nextLine();
					data += input + "\t";
				}
				data += "\r\n";
				
				try {
					fw = new FileWriter(file);
					bw = new BufferedWriter(fw);
					
					bw.write(data);
					bw.flush();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(bw != null) bw.close();
						if(fw != null) fw.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
			}else if(input.equals("2")) {
				System.out.println("-----------------------------------------");
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("-----------------------------------------");
				System.out.println(data);
				System.out.println("-----------------------------------------");
				
			}else if(input.equals("3")) {
				
			}else if(input.equals("4")) {
				
			}
			
		}
		
	}

}
