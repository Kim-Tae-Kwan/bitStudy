package com.bit.tcp.step4;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

class SocketReader extends Thread{
	final Socket socket;
	
	public SocketReader(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader sir = null;
		BufferedReader br = null;
		
		try {
			is = socket.getInputStream();
			sir = new InputStreamReader(is);
			br = new BufferedReader(sir);
			
			while(true) {
				String msg = br.readLine();
				Client.area.setText(Client.area.getText() + "\n" + msg);
				
			}
		} catch (SocketException e) {
			System.out.println("¼­¹ö Á¢¼ÓÀÌ ²÷°å½À´Ï´Ù.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
				if (br != null)
					br.close();
				if (sir != null)
					sir.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}


public class Client extends Frame{
	static TextArea area;
	
	public Client() {
		area = new TextArea();
		add(area);
		setSize(400, 500);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		Client me = new Client();
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		BufferedWriter bw = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		
		try {
			socket = new Socket("192.168.128.133", 5000);
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);

			SocketReader sr = new SocketReader(socket);
			sr.setDaemon(true);
			sr.start();
			
			while (true) {
				System.out.print("> ");
				String msg = scanner.nextLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (scanner != null)
					scanner.close();
				if (socket != null)
					socket.close();
				if (bw != null)
					bw.close();
				if (osw != null)
					osw.close();
				if (os != null)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
