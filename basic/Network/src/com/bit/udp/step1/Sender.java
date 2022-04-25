package com.bit.udp.step1;

import java.net.*;

public class Sender {

	public static void main(String[] args) {
		byte[] arr = {127,0,0,1};
		InetAddress addr = null;
		int port = 5000;
		
		DatagramSocket dsock = null;
		DatagramPacket packet = null;
		
		try {
			addr = InetAddress.getByAddress(arr);
			dsock = new DatagramSocket();
			
			String msg = "hello UDP";
			packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);
			dsock.send(packet);
			
			msg = "잘받았나요";
			packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);
			dsock.send(packet);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(dsock != null) dsock.close();
		}
	}
}
