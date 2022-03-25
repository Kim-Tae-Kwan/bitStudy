package com.bit.day08;

import java.text.DateFormat;
import java.util.Date;

public class Ex08 {

	public static void main(String[] args) {
		Date d1 = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		String msg = df.format(d1);
		System.out.println(msg);
	}
}
