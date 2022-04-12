package com.bit.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex04 {
	
	public static void printList() {
		String sql = "select * from dept";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = Ex02.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(Ex02.equals("10", rs.getString(1)));
				System.out.println(Ex02.equals("ACCOUNTING", rs.getString(2)));
				System.out.println(Ex02.equals("NEW YORK", rs.getString(3)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(statement != null) statement.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		printList();
	}

}
