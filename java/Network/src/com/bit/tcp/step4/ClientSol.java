package com.bit.tcp.step4;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSol extends Frame implements Runnable {
	static TextArea area;
	static BufferedReader br = null;

	@Override
	public void run() {
		try {
			while (true) {
				String msg = br.readLine();
				area.setText(area.getText() + "\n" + msg);
			}
		} catch (SocketException e) {
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ClientSol() {
		area = new TextArea();
		add(area);
		setSize(400, 500);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		ClientSol me = new ClientSol();
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		BufferedWriter bw = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;

		InputStream is = null;
		InputStreamReader sir = null;

		try {
			socket = new Socket("192.168.128.133", 5000);
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);

			is = socket.getInputStream();
			sir = new InputStreamReader(is);
			br = new BufferedReader(sir);

			Thread thread = new Thread(me);
			thread.start();

			while (true) {
				System.out.print("내용 입력 (1.귓속말 0.종료)> ");
				String msg = scanner.nextLine();
				
				if(msg.equals("0")) break;
				else if(msg.equals("1")) {
					while(true) {
						System.out.print("귓속말 할 번호 (a.list 보기 b.나가기)> ");
						msg = scanner.nextLine();
						if(msg.equals("b")) break;
						else if(msg.equals("a")) {
							bw.write("list");
							bw.newLine();
							bw.flush();
						}else {
							System.out.print("내용 입력 > ");
							msg = msg + "/" +scanner.nextLine();
							bw.write(msg);
							bw.newLine();
							bw.flush();
							break;
						}
					}
				}else {
					bw.write(msg);
					bw.newLine();
					bw.flush();
				}
			}
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

}
