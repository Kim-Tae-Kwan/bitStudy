package com.bit.db;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.Driver;

public class log {

	public static void main(String[] args) {
		Logger log = Logger.getGlobal();
		
		log.setLevel(Level.INFO);
//		log.setLevel(Level.WARNING);
//		log.setLevel(Level.SEVERE);
		
		try {
			Driver driver = new Driver();
//			System.out.println(driver);
			log.info(driver.toString());
			log.info("정보 : info");
			log.severe("심각 : severe");
			log.warning("경고 : warning");
			log.fine("로그메시지fine");
			log.finer("로그메시지finer");
			log.config("로그메시지config");
			log.finest("로그메시지finest");
			
		} catch (SQLException e) {
			log.severe("심각 : severe");
			e.printStackTrace();
		}
	}
}
