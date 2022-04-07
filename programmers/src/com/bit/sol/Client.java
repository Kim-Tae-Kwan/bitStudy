package com.bit.sol;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client extends Frame implements Runnable {

	TextArea area;
	InputStream is;

	public Client(InputStream is) {
		this.is = is;
		area = new TextArea();
		add(area);
		setSize(300, 300);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		OutputStream os = null;
		PrintStream ps = null;
		try {
			socket = new Socket("localhost", 5000);
			os = socket.getOutputStream();
			ps = new PrintStream(os);
			Client client = new Client(socket.getInputStream());
			Thread thread = new Thread(client);
			thread.start();

			while (true) {
				System.out.println("모두 #메시지, 귓말 번호#메시지 > ");
				ps.println(sc.nextLine());
				ps.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (os != null)
					os.close();
				if (socket != null)
					socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while (true) {
				String msg = br.readLine();
				area.append("\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
