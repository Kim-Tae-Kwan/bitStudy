package com.bit.network;

import java.net.*;

//IP 정보 얻기.
public class Ex01 {

	public static void main(String[] args) {
		String host = "naver.com";
		byte[] arr = { (byte)223,(byte)130,(byte)200,(byte)107};
		try {
			//도메인으로 ip 얻기
			InetAddress address1 = InetAddress.getByName(host);
			System.out.println(address1.getHostName());
			System.out.println(address1.getHostAddress());
			System.out.println("-----------------------------------------");
			
			//ip으로 ip 얻기
			InetAddress address2 = InetAddress.getByAddress(arr);
			System.out.println(address2.getHostName());
			System.out.println(address2.getHostAddress());
			System.out.println("-----------------------------------------");
			
			//도메인으로 모든 ip 얻기
			InetAddress[] address = InetAddress.getAllByName(host);
			for (int i = 0; i < address.length; i++) {
				System.out.println(address[i].getHostName());
				System.out.println(address[i].getHostAddress());
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
