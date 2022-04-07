package com.bit.tcp.step1;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("접속대기...");
			Socket socket = serverSocket.accept();
			System.out.println("누군가 들어옴...");
			
			InetAddress address = socket.getInetAddress();
			System.out.println(address.getHostAddress());
			
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println("ip : " + address.getHostAddress() + "님 환영합니다.");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println(br.readLine());
			
			
			ps.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
