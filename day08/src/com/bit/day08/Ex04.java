package com.bit.day08;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar.get(Calendar.YEAR) + "년");
		System.out.println(calendar.get(Calendar.MONTH)+ 1 + "월"); //0~11 
		System.out.println(calendar.get(Calendar.DATE) + "일");
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		switch (day) {
		case Calendar.SUNDAY:
			System.out.println();
			break;
		case Calendar.MONDAY:
			System.out.println();
			break;
		default:
			break;
		}
		
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(calendar.get(Calendar.AM_PM));
		System.out.println(calendar.get(Calendar.HOUR) + "시");
		System.out.println(calendar.get(Calendar.MINUTE) + "분");
		System.out.println(calendar.get(Calendar.SECOND) + "초");
	}
}