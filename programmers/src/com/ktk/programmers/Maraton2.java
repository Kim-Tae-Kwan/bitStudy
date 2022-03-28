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
		
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		System.out.println(Arrays.toString(participant));
		System.out.println(Arrays.toString(completion));
		
		int i;
		for(i = 0; i < completion.length; i++) {
//			if(!participant[i].equals(completion[i])) {
//				break;
//			}
			
			if(!completion[i].equals(participant[i])) {
				break;
			}
		}
		
		System.out.println(participant[i]);
		
	}

}
