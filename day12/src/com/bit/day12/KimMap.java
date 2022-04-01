package com.bit.day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KimMap {

	public static void main(String[] args) {
		Map<Integer, int[]> map = new HashMap<>();
		
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < 10; i++) {
			map.put(i, arr);
		}
		
		map.remove(0);
		map.remove(5);
		
		for(Integer key : map.keySet()) {
			System.out.println(key + " : " + Arrays.toString(map.get(key)));
		}
		
		

	}

}
