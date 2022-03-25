package com.bit.day08;

import java.util.Arrays;

class Ball{
	public final int su;
	public boolean check;
	public final String color;
	
	public Ball(int su){
		this.su = su; 
		check = false;
		
		switch (su/10) {
		case 0:
			color = "노랑";
			break;
		case 1:
			color = "파랑";
			break;
		case 2:
			color = "빨강";
			break;
		case 3:
			color = "초록";
			break;

		default:
			color = "회";
			break;
		}
	}
}

public class Teacher2 {
	public static void main(String[] args) {
		//2. 객체지향
		/////////////////////////////////////
		
		// 1. Ball 45개 만들기.
		int limit = 45;
		Ball[] box = new Ball[limit];
		for (int i = 0; i < box.length; i++) {
			box[i] = new Ball(i + 1);
		}
		
		// 2. 6개 숫자 뽑기.
		String[] note = new String[6];
		for (int i = 0; i < 6; i++) {
			int ran = (int)(Math.random() * limit);
			Ball ball = box[ran];
			if(ball.check) {// 뽑았던 공
				i--;
			}else {// 안뽑았던 공
				note[i] = ball.color + "색 공 " + ball.su;
				ball.check = true;
			}
		}
		
		System.out.println(Arrays.toString(note));
		
		
	}
}
