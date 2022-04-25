package com.bit.tcp.step4;

import java.io.*;
import java.util.*;
import java.net.*;

public class ServerSol extends Thread{
	static int cnt = 0;
	int num;
	static BufferedWriter bw = null;
	Socket socket;
	static Map<Integer, BufferedWriter> map = new HashMap<Integer, BufferedWriter>();
	
	public ServerSol(Socket socket) {
		this.socket = socket;
		num = ++cnt;
	}

	@Override
	public void run() {
		
		OutputStream os = null;
		OutputStreamWriter osw = null;
		
		InputStream is = null;
		InputStreamReader sir = null;
		BufferedReader br = null;
		
		
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			is = socket.getInputStream();
			sir = new InputStreamReader(is);
			br = new BufferedReader(sir);
			map.put(num, bw);
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					map.remove(num);
					msg = num + " 님이 나갔습니다.";
					sendAll(msg);
					break;
				}
				
				
				String[] msgs = msg.split("/");
				
				if(msgs.length == 2) {
					BufferedWriter bw = map.get(Integer.parseInt(msgs[0]));
					sendTo(msgs[1], bw);
				}else if(msg.equals("list")) {
					sendMe(getList());
				}else sendAll(msg);
				
			}
		} catch (SocketException e) {
			map.remove(num);
			String msg = num + " 님이 나갔습니다.";
			sendAll(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) socket.close();
				if (br != null)
					br.close();
				if (sir != null)
					sir.close();
				if (is != null)
					is.close();
				if (bw != null)
					bw.close();
				if (osw != null)
					osw.close();
				if (os != null)
					os.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void sendAll(String msg) {
		BufferedWriter bw = null;
		try {
			for(Integer key : map.keySet()) {
				bw = map.get(key);
				bw.write(num + " > " +msg);
				bw.newLine();
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMe(String msg) {
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendTo(String msg, BufferedWriter bw) {
		try {
			bw.write(num + " 님의 귓속말 > " + msg);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getList() {
		StringBuilder str = new StringBuilder();
		str.append("===================\n");
		str.append("현재 접속 중인 ip\n");
		for(Integer key : map.keySet()) {
			str.append(key + "\n");
		}
		str.append("===================\n");
		return str.toString();
	}
	
	public static void main(String[] args) {
		ServerSocket serv = null;

		try {
			serv = new ServerSocket(5000);
			System.out.println("Socket Server Start!!");
			while (true) {
				Socket socket = serv.accept();
				ServerSol me = new ServerSol(socket);
				me.start();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (serv != null)
					serv.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
