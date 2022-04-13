package com.bit.webserver;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		OutputStream os = null;
		PrintStream ps = null;
		try {
			serverSocket = new ServerSocket(80);
			
			clientSocket = serverSocket.accept();
			InetAddress address = clientSocket.getInetAddress();
			System.out.println(address.getHostAddress() + " 접속이 들어왔습니다.");
			
			os = clientSocket.getOutputStream();
			ps = new PrintStream(os);
			
//			ps.println("Header Info");
			ps.println("HTTP/1.1 200 OK");
			
			ps.println();
			ps.println("document content...");
			
			clientSocket.close();
			
			clientSocket = serverSocket.accept();
			address = clientSocket.getInetAddress();
			System.out.print(address.getHostAddress() + " 접속이 들어왔습니다.");
			
			os = clientSocket.getOutputStream();
			ps = new PrintStream(os);
			
//			ps.println("Header Info");
			ps.println("HTTP/1.1 200 OK");
			
			ps.println();
			ps.println("document content...");
			
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) serverSocket.close();
				if(ps != null) ps.close();
				if(os != null) os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
