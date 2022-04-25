package com.bit.day08;

import java.util.*;

public class Ex05 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar(2002,5-1,1);
		System.out.println(calendar.get(GregorianCalendar.YEAR));
		System.out.println(calendar.get(GregorianCalendar.MONTH) + 1);
		System.out.println(calendar.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println(calendar.get(GregorianCalendar.HOUR_OF_DAY));
		System.out.println(calendar.get(GregorianCalendar.MINUTE));
		System.out.println(calendar.get(GregorianCalendar.SECOND));
		System.out.println("---------------------------------------");
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
		
	}

}
