package com.bit.webserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 extends Thread{
	Socket sock;
	
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		
		try {
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String msg = br.readLine();
			String[] arr = msg.split(" ");
			System.out.println(arr[1]);
			
			os = sock.getOutputStream();
			bos = new BufferedOutputStream(os);
			
			//header
			bos.write("HTTP/1.1 200 OK\n".getBytes()); 
			bos.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			
			 //partition
			bos.write("\r\n".getBytes());
			
			//body
			if(arr[1].equals("/")) arr[1] = "/index.html";
			File file = new File("." + arr[1]);
			if(file.exists()) {
				is = new FileInputStream(file);
				while(true) {
					int su = is.read();
					if(su == -1) break;
					bos.write(su);
				}
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
				if(os != null) os.close();
				if(sock != null) sock.close();
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(8080);
			System.out.println("server start!");
			while(true) {
				Socket sock = serverSocket.accept();
//				System.out.println(sock.getInetAddress().getHostAddress() + " 님 접속.");
				Server02 me = new Server02();
				me.sock = sock;
				me.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
