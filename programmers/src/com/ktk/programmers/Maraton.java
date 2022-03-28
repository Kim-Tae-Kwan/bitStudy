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
		String[] participant = { "leo", "kiki", "eden"};
		String[] completion = { "eden", "kiki" };
		
		Maratoner[] maratoners = new Maratoner[participant.length];
		for (int i = 0; i < participant.length; i++) {
			maratoners[i] = new Maratoner(participant[i]);
		}
		
		for (int i = 0; i < completion.length; i++) {
			for (int j = 0; j < maratoners.length; j++) {
				if(completion[i].equals(maratoners[j].name)) {
					maratoners[j].fail = true;
					break;
				}
			}
		}
		
		for(Maratoner maratoner: maratoners) {
			if(maratoner.fail == false) {
				System.out.println(maratoner.name);
			}
		}
		
		
		
		
		
//		List<String> participantList = new ArrayList<String>();
//		participantList.addAll(Arrays.asList(participant));
//		
//		for (int i = 0; i < completion.length; i++) {
//			String a = completion[i];
//			participantList.remove(a);
//		}
		
//		System.out.println(participantList);
		
	}

}
