package com.bit.network;

import java.io.*;
import java.net.*;

public class Ex03 {

	public static void main(String[] args) {
		File file = new File("google.html");
		String path = "https://google.com";
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		FileWriter fw = null; 
		PrintWriter pw = null;
		
		try {
			URL url = new URL(path);
			URLConnection conn = url.openConnection();
			
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			
			String msg = null;
			while((msg=br.readLine()) != null) {
				pw.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw !=null) pw.close();
				if(fw !=null) fw.close();
				
				if(br !=null) br.close();
				if(isr !=null) isr.close();
				if(is !=null) is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
	}

}
