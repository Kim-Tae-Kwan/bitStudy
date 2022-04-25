package com.bit.day08;

import java.util.Arrays;

class LottoBall{
	public final int num;
	public boolean check;
	
	public LottoBall(int num) {
		this.num = num;
		check = false;
	}
}

public class MyAnswer2 {

	public static void main(String[] args) {
		// 로또 번호생성기(ver 0.1.0)
		// 4,44,23,33,12,2
		// sort -> 2,4,12,23,33,44 + 보너스번호
		
		// 1. 공을 45개 준비.
		LottoBall[] box = new LottoBall[45];
		for (int i = 0; i < box.length; i++) {
			LottoBall ball = new LottoBall(i + 1);
			box[i] = ball;
		}
		
		// 2.랜덤으로 하나씩 6개를 뽑는다.
		int[] note = new int[6];
		for (int i = 0; i < note.length; i++) {
			int ran = (int)(Math.random() * 45);
			LottoBall ball = box[ran];
			if(ball.check){
				i--;
			}else {
				note[i] = ball.num;
				ball.check = true;
			}
		}
		
		//3. 정렬
		for (int i = 0; i < note.length; i++) {
			for (int j = i+1; j < note.length; j++) {
				if(note[i] > note[j]) {
					int temp = 0;
					temp = note[i];
					note[i] = note[j];
					note[j] = temp;
				}
				
			}
		}
		
		//4. 보너스 번호
		int bonus = 0;
		
		while(bonus == 0) {
			int ran = (int)(Math.random() * 45);
			boolean same = false;
		    LottoBall ball = box[ran];
		    for (int i = 0; i < note.length; i++) {
		    	if(note[i] == ball.num) {
		    		same = true;
					break;
				}
			}
		    
		    if(!same) {
		    	bonus = ball.num;
		    }
		}
		System.out.println(Arrays.toString(note) + "\t보너스 번호: " + bonus);
	}

}
