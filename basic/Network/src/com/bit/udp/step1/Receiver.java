package com.bit.udp.step1;

import java.net.*;

public class Receiver {

	public static void main(String[] args) {
		byte[] buf = new byte[128];
		
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		
		try {
			socket = new DatagramSocket(5000);
			packet = new DatagramPacket(buf, buf.length);
			
			socket.receive(packet);
			System.out.println(new String(packet.getData()));
			
			buf = new byte[200];
			packet = new DatagramPacket(buf, buf.length);
			
			socket.receive(packet);
			System.out.println(new String(packet.getData()));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(socket != null) socket.close();
		}
		
	}

}
