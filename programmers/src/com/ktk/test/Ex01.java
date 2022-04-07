package com.ktk.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


class Kim implements Serializable{
	public static int cnt = 0;
	private final int num;
	private String name;
	private int kor, eng, math;
	
	public Kim(String name) {
		this.name = name;
		num = ++cnt;
	}
	
	public static void setCnt(int cnt) {
		Kim.cnt = cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getNum() {
		return num;
	}
	
}


public class Ex01 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("test07.bin");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
//		List<Kim> list= new ArrayList<Kim>();
//		for (int i = 0; i < 10; i++) {
//			Kim a = new Kim(String.valueOf(i));
//			list.add(a);
//		}
//			fos = new FileOutputStream(file);
//			oos = new ObjectOutputStream(fos);
//			
//			
////			for(Kim a : list) {
////				oos.writeObject(a);
////			}
//			oos.writeObject(list);
//			
//			oos.close();
//			fos.close();
			
			
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			List<Kim> list = new ArrayList<Kim>();
			
			while(true) {
				try {
					List<Kim> obj = (List<Kim>) ois.readObject();
//					list.add(obj);
					for(Kim a : obj) {
						System.out.println(a.getName());
					}
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
				
			}
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
