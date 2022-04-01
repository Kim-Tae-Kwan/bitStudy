package com.bit.day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Ex14 {

	public static void main(String[] args) {
		File file = new File("test06.bin");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.write(-127);
			oos.writeInt(1234);
			//data 스트림과 중복.
			List list = new ArrayList();
			list.add(1111);
			list.add(2222);
			list.add(3333);
			oos.writeObject(list);
			
			Vector vec = new Vector();
			vec.add(789);
			Vector vec2 = new Vector();
			vec2.add(456);
			vec2.add(vec);
			
			oos.writeObject(vec2);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
