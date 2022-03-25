package com.bit.day08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09 {

	public static void main(String[] args) {
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm a");
		String msg = sdf.format(d1);
		System.out.println(msg);
	}

}
