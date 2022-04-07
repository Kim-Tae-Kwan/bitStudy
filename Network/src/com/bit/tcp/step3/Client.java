package com.bit.tcp.step3;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		InputStream is = null;
		InputStreamReader sir = null;
		BufferedWriter bw = null;
		
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket("192.168.128.133", 5000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			sir = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(sir);
			bw = new BufferedWriter(osw);

			while (true) {
				System.out.print("> ");
				String msg = scanner.nextLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
				msg = br.readLine();
				System.out.println(msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (scanner != null)
					scanner.close();
				if (socket != null)
					socket.close();
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (osw != null)
					osw.close();
				if (sir != null)
					sir.close();
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
