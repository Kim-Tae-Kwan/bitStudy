package com.bit.tcp.step2;

//단일 echo 서버

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		InputStreamReader isr = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			serverSocket = new ServerSocket(5000);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);

			while (true) {
				String msg = br.readLine();
				bw.write("re : " + msg);
				bw.newLine();
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
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

}
