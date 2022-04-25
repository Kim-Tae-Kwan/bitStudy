package com.bit.day12;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex11 {

	public static void main(String[] args) {
		File file = new File("test05.bin");
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			dos.write(127);
			dos.writeInt(05);
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
			dos.writeChar('@');
			dos.writeUTF("Hello");
			
			
			dos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
