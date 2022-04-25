package com.bit.db;

import java.lang.reflect.Field;

class Lec03{
	int su = 1234;
}

public class Reflect {

	public static void main(String[] args) {
//		Lec03 obj = new Lec03();
//		System.out.println(obj.su);
		
		try {
			Class clz = Class.forName("com.bit.db.Lec03");
			Lec03 obj = (Lec03) clz.newInstance();
			Field[] fields = clz.getDeclaredFields();
			System.out.println(fields[0].getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Class<Lec03> clz = Lec03.class;
			Lec03 obj = clz.newInstance();
			System.out.println(obj.su);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
