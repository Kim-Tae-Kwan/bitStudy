package com.bit.tcp.step3;

//다중 echo 서버.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;

public class Server extends Thread {
	final Socket socket;

	public Server(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);

			while (true) {
				String msg = br.readLine();
				bw.write(socket.getInetAddress().getHostAddress() + " : " + msg);
				bw.newLine();
				bw.flush();
			}

		} catch (SocketException e) {
			System.out.println(socket.getInetAddress() + " 연결종료.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (osw != null)
					osw.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		ServerSocket serv = null;

		try {
			serv = new ServerSocket(5000);
			System.out.println("Socket Server Start!!");
			while (true) {
				Socket socket = serv.accept();
				System.out.println(socket.getInetAddress());
				Server thr = new Server(socket);
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
