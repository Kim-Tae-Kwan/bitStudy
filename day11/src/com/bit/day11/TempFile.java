package com.bit.day11;

import java.io.File;

public class TempFile {

	public static void main(String[] args) {
		File file = null;
		try {
			file = File.createTempFile("abcdefg", ".txt");
			System.out.println(file.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
