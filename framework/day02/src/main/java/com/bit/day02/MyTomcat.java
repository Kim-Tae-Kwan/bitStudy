package com.bit.day02;

import org.apache.catalina.Server;
import org.apache.catalina.startup.Tomcat;

public class MyTomcat {

	public static void main(String[] args) {
		Tomcat server = new Tomcat();
		server.setPort(8080);
		try {
			server.addWebapp("/", "D:\\Development\\bitStudy\\framework\\day02\\src\\main\\webapp");
			
			server.addServlet("/", "ex01", "com.bit.contoller.Ex01Contoller");
			
			server.start();
			Server server2 = server.getServer();
			server2.await();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
