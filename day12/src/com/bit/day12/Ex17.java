package com.bit.day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex17 {

	public static void main(String[] args) {
		File file = new File("test07.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			Lec16 obj = (Lec16) ois.readObject();
			System.out.println(obj.su2);
			obj.func();
			
			fis.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
