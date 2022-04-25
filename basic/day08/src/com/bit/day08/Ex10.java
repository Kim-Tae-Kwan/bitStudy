package com.bit.day08;

import java.text.DateFormat;
import java.util.Date;

public class Ex10 {

	public static void main(String[] args) {
		Date d1 = new Date();
		long d2 = d1.getTime();
		System.out.println(d2);
		
		Date d3 = new Date();
		d3.setMonth(2-1);
		long d4 = d3.getTime();
		System.out.println((d2-d4)/1000/60/60/24);
		
		long d5 = 100L*24L*60L*60L*1000L;
		Date d6 = new Date(d2 + d5);
		String msg = DateFormat.getDateInstance().format(d6);
		System.out.println(msg);
		
	}

}
