package com.bit.network;

import java.net.URL;

public class Ex02 {

	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://daum.net");
			System.out.println("protocol : "+ url.getProtocol());
			System.out.println("host : " + url.getHost());
			System.out.println("port : " + url.getPort());
			System.out.println("port : " + url.getDefaultPort());
			System.out.println("file : " + url.getFile());
			System.out.println("query : " + url.getQuery());
			System.out.println("ref : " + url.getRef());
			System.out.println("" + url.getAuthority());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
