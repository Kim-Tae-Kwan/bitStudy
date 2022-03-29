package com.bit.day10;

import java.util.*;

class Ball implements Comparable<Ball>{
	public int su;
	
	
	public Ball(int su) {
		this.su = su;
	}
	
	@Override
	public int compareTo(Ball obj) {
		return this.su - ((Ball)obj).su;
//		return obj.su - this.su;
	}
}

public class Ex04 {

	public static void main(String[] args) {
		// TreeSet 오름차순(양수) 내림차순(음수) 결정
		Comparator<Ball> comp = new Comparator<Ball>() {

			@Override
			public int compare(Ball o1, Ball o2) {
				return o1.su - o2.su;
//				return o2.su - o1.su;
			}
			
		};		
		
		Set lotto = new TreeSet(comp);
		Random random = new Random();
//		int ran = 1;
		while(lotto.size() != 6){
			int ran = random.nextInt(45) + 1;
			lotto.add(new Ball(ran));
		}
		
		Iterator ite = lotto.iterator();
		while(ite.hasNext()) {
			Ball ball = (Ball)ite.next();
			System.out.print(ball.su + " ");
		}
	}
}