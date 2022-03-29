package com.ktk.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Maratoner{
	public String name;
	public boolean fail;
	
	public Maratoner(String name) {
		this.name = name;
		fail = false;
	}
}

public class Maraton {

	public static void main(String[] args) {
//		String[] participant = { "leo", "kiki", "eden"};
//		String[] completion = { "eden", "kiki" };
		
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		
		String[] participant = { "mislav", "stanko", "mislav", "ana"};
		String[] completion = { "stanko", "ana", "mislav" };
		
		//Maratoner 객체로 변환.
		Maratoner[] maratoners = new Maratoner[participant.length];
		for (int i = 0; i < participant.length; i++) {
			maratoners[i] = new Maratoner(participant[i]);
		}
		
		//완주자 체크.
		for (int i = 0; i < completion.length; i++) {
			for (int j = 0; j < maratoners.length; j++) {
				if(completion[i].equals(maratoners[j].name)) {
					maratoners[j].fail = true;
					break;
				}
			}
		}
		
		//체크되지 않은 사람 -> 완주 못한 사람
		for(Maratoner maratoner: maratoners) {
			if(maratoner.fail == false) {
				System.out.println(maratoner.name);
			}
		}
	}

}
