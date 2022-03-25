package com.bit.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) throws FileNotFoundException{
		
		InputStream inn = System.in;
		Scanner scanner;
		scanner = new Scanner(inn);
		
		System.out.println(scanner.nextInt());
		System.out.println(scanner.next());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.next());
	}
}
