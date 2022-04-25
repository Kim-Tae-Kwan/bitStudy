package com.bit.day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Ex15 {

	public static void main(String[] args) {
		File file = new File("test06.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			int su = ois.read();
			int su2 = ois.readInt();
			ArrayList list = (ArrayList)ois.readObject();
			Vector vec = (Vector)ois.readObject();
			System.out.println(su);
			System.out.println(su2);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			System.out.println(vec.get(0));
			Vector vec2 = (Vector)vec.get(1);
			for (int i = 0; i < vec2.size(); i++) {
				System.out.println(vec2.get(i));
			}
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
