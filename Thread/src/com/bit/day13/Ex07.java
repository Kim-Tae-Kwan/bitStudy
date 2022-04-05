package com.bit.day13;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

//Thread 제어.

class Lec07 extends Thread{
	FileOutputStream fos = null;
	
	@Override
	public void run() {
		try {
			File file =  new File("test07.txt");
			fos = new FileOutputStream(file);
			while(true) {
				fos.write(65);
//				fos.flush();
//				sleep(500);
			}
			
//			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}


public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lec07 thr = new Lec07();
		
		
		while(true) {
			System.out.print("1.시작 2.멈춤 3.재시작 4.끝 5. 상태 0.종료 > ");
			int input = sc.nextInt();
			if(input == 0) break;
			else if(input == 1) thr.start();
			else if(input == 2) thr.suspend();
			else if(input == 3) thr.resume();
			else if(input == 4) {
//				try {
//					if(thr.fos != null) thr.fos.close();
//					thr.stop();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				
				thr.stop();
				
			}else if(input == 5) System.out.println(thr.getState());
		}
	}
}
