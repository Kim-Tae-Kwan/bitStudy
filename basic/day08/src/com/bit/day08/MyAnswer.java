package com.bit.day08;

import java.util.Random;

class Lotto{
	
	Random random = new Random();
	int[] numbers = new int[6];
	int bonusNum = 0;
	
	public void printMain() {
		System.out.println("로또 번호생성기(ver 0.1.0)");
	}
	
	public void printResult() {
		String result = "";
		
		for(int i = 0; i < numbers.length; i++) {
			result += numbers[i];
			if(i != numbers.length) {
				result += ",";
			}
		}
		
		result += " + " + bonusNum;
		
		System.out.println(result);
	}
	
	public void getNumbers() {
		for(int i = 0; i < numbers.length; i++) {
			while(true) {
				int number = random.nextInt(45);
				boolean check = false;
				
				if(number == 0) continue;
				
				for(int j = 0; j < i; j++) {
					if(numbers[j] == number) {
						check = true;
						break;
					}
				}
				
				if(!check) {
					numbers[i] = number;
					break;
				}
			}
		}
	}
	
	public void getBonusNum() {
		while(true) {
			int number = random.nextInt(45);
			boolean check = false;
			
			if(number == 0) continue;
			
			for(int i = 0; i < numbers.length; i++) {
				if(numbers[i] == number) {
					check = true;
					break;
				}
			}
			
			if(!check) {
				bonusNum = number;
				break;
			}
		}
	}
	
	public void sort() {
		for(int i=1; i < numbers.length; i++){
            for(int j=i ; j >= 1; j--){
                
                if(numbers[j] < numbers[j-1]){ 
                    int tmp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = tmp;
                }else break;  
                
            }
        }
	}
}

public class MyAnswer {

	public static void main(String[] args) {
		// 로또 번호생성기(ver 0.1.0)
		// 4,44,23,33,12,2
		// sort -> 2,4,12,23,33,44 + 보너스번호
		///////////////////////////////////////
		// Arrays.sort() X
		///////////////////////////////////////
		//1. 전형
		//2. 객체지향
		//3. 아이디어
		///////////////////////////////////////
		
		Lotto lotto = new Lotto();
		lotto.printMain();
		lotto.getNumbers();
		lotto.sort();
		lotto.getBonusNum();
		lotto.printResult();
	}
}
