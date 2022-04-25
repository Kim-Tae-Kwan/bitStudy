package com.ktk.programmers;
//가장 큰 수
import java.util.*;
class Solution{
	public String solution(int[] numbers) {
		String answer = "";
		List<String> list = new ArrayList<>();
		int index = 0;
		int first = numbers[0];
		int end = numbers[numbers.length - 1];
		
		while(true) {
			//정수 붙이기.
			String sum = "";
			for(int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			list.add(sum);
			
			//순서 바꾸기.
			int temp = 0;
			temp = numbers[index];
			numbers[index] = numbers[index + 1];
			numbers[index + 1] = temp;
			index++;
			
			if(first == numbers[0] && end == numbers[numbers.length - 1]) break;
			else if(index == numbers.length - 1) index = 0;
			
		}
		
		for(String number : list) {
			System.out.println(number);
		}
		
		
		for(String number : list) {
			if(answer.isEmpty()) answer = number;
			else {
				for(int i = 0; i < number.length(); i++) {
					if(number.charAt(i) == answer.charAt(i)) continue;
					else if(number.charAt(i) > answer.charAt(i)) {
						answer = number;
						break;
					}
				}
			}
		}

		return answer;
    }
}

public class MaxNumber {

	public static void main(String[] args) {
		//int[] numbers = {6, 10, 2};
		int[] numbers = {3,30,34,5,9};
		
		Arrays.sort(numbers);
		
		System.out.println(Arrays.binarySearch(numbers, 34));
		
		for(int a : numbers) {
			System.out.println(a);
		}
		
		
		
//		Solution solution = new Solution();
//		
//		String result = solution.solution(numbers);
//		System.out.println(result);
		
//		Comparator<Integer> cp = new Comparator<Integer>() {
//			
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			}
//		};

	}

}
