package com.ktk.programmers;

import java.util.Arrays;
import java.util.List;

public class Maraton2 {

	public static void main(String[] args) {
//		String[] participant = { "leo", "kiki", "eden"};
//		String[] completion = { "eden", "kiki" };
		
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		
		String[] participant = { "mislav", "stanko", "mislav", "ana"};
		String[] completion = { "stanko", "ana", "mislav" };
		
		//정렬
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		//이름이 같지 않은 인덱스
		int i;
		for(i = 0; i < completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				break;
			}
		}
		
		String answer = participant[i];
		
		System.out.println(answer);
		
	}

}
