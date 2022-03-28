package com.bit.day09;

import java.util.Enumeration;
import java.util.Vector;

public class Ex10 {
	public static void main(String[] args) {
		Vector vec1 = new Vector();
		vec1.addElement("첫번째");
		vec1.addElement("두번째");
		vec1.addElement("세번째");
		vec1.addElement("네번째");
		
		System.out.println(vec1.elementAt(0));
		System.out.println(vec1.elementAt(1));
		System.out.println(vec1.elementAt(2));
		System.out.println(vec1.elementAt(3));
		System.out.println("------------------");
		System.out.println(vec1.firstElement());
//		vec1.removeElementAt(0);
		System.out.println(vec1.firstElement());
		System.out.println(vec1.firstElement());
		System.out.println(vec1.firstElement());
		System.out.println(vec1.firstElement());
		System.out.println("------------------");
		
		Enumeration eum = vec1.elements();
		while(eum.hasMoreElements()) {
			System.out.println(eum.nextElement());
		}
		eum = vec1.elements();
		while(eum.hasMoreElements()) {
			System.out.println(eum.nextElement());
		}
	}
}
