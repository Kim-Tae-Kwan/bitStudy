package com.bit.sol;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Server extends Thread{
	static Map<Integer, PrintStream> list = new HashMap<Integer, PrintStream>();
	BufferedReader br;

	public Server(InputStream inputStream) {
		br = new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public void sayAll(String msg) {
		Iterator<Integer> ite = list.keySet().iterator();
		while(ite.hasNext()) {
			PrintStream ps = list.get(ite.next());
			ps.println(msg);
			ps.flush();
		}
	}
	
	public void sayOne(String msg) {
		PrintStream ps = list.get(hashCode());
		ps.println(msg);
		ps.flush();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String msg = br.readLine();
				if(msg.startsWith("#")) {
					sayAll(hashCode()  +" : " + msg.substring(1));
				}else {
					sayOne(hashCode()  +" : " + msg.substring(msg.indexOf('#') + 1));
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;
		try {
			 serverSocket = new ServerSocket(5000);
			 
			 while(true) {
				 socket = serverSocket.accept();
				 Server thr = new Server(socket.getInputStream());
				 list.put(thr.hashCode(), new PrintStream(socket.getOutputStream()));
				 thr.start();
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
