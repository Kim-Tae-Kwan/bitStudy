package com.bit.database;

//select

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Select {
	public static void main(String[] args) {
		String sql = "select num, sub, name, content from bbs01";
		String url = "jdbc:mysql://localhost:3306/test01";
		Properties info = new Properties();
		info.setProperty("user", "user01");
		info.setProperty("password", "1234");
		
//		Driver driver = null;
		Connection conn = null; // 데이터베이스 연결.
		Statement stmt = null; // 쿼리 날리기 위한 인터페이스.
		ResultSet rs = null; // select 결과 셋.
		
		try {
//			driver = new Driver();
			conn = DriverManager.getConnection(url, info);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print("num : " + rs.getString(1) + "\t");
				System.out.print("sub : " + rs.getString(2) + "\t");
				System.out.print("name : " + rs.getString(3) + "\t");
				System.out.println("content : " + rs.getString(4) + "\t");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
