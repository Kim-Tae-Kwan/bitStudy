package com.bit.tcp.step4;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;


public class Server extends Thread{
	final Socket socket;
	final BufferedWriter bw;
	List<BufferedWriter> list;

	public Server(Socket socket, BufferedWriter bw, List<BufferedWriter> list) {
		this.socket = socket;
		this.bw = bw;
		this.list = list;
	}

	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			while (true) {
				String msg = br.readLine();
				for(BufferedWriter bw : list ) {
					bw.write(socket.getInetAddress().getHostAddress() + " : " + msg);
					bw.newLine();
					bw.flush();
				}
			}

		} catch (SocketException e) {
			list.remove(this.bw);
			try {
				for(BufferedWriter bw : list ) {
					bw.write(socket.getInetAddress().getHostAddress() + " 님이 퇴장하셨습니다.");
					bw.newLine();
					bw.flush();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			System.out.println(socket.getInetAddress().getHostAddress() + " 연결종료.");
			System.out.println("list size : " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				
				list.remove(socket);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	
	public static BufferedWriter getWriter(Socket socket) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return bw;
	}

	public static void main(String[] args) {
		ServerSocket serv = null;
		List<BufferedWriter> list = new ArrayList<BufferedWriter>();

		try {
			serv = new ServerSocket(5000);
			System.out.println("Socket Server Start!!");
			while (true) {
				Socket socket = serv.accept();
				BufferedWriter bw = getWriter(socket);
				list.add(bw);
				try {
					for(BufferedWriter write : list ) {
						write.write(socket.getInetAddress().getHostAddress() + " 님이 입장하셨습니다.");
						write.newLine();
						write.flush();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				Server thr = new Server(socket,  bw, list);
				thr.setDaemon(true);
				thr.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
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
