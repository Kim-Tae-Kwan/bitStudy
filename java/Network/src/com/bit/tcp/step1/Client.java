package com.bit.tcp.step1;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		
		try {
//			InetAddress address = InetAddress.getByAddress(new byte[] { (byte)192, (byte)168, (byte)128, (byte)143});
//			Socket socket = new Socket(address, 5000);
			Socket socket = new Socket("192.168.128.133", 5000);
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println("내가 왔다.");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println(br.readLine());
			
			is.close();
			isr.close();
			is.close();
			ps.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
