package com.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.Driver;

public class Ex02 {
	static Logger log = Logger.getGlobal();

	static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/scott";
		String user = "user01";
		String password = "1234";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return conn;
	}

	static boolean notNull(Object object) {
		if (object == null)
			return false;
		else
			return true;
	}
	
	public static boolean same(int result,int target) {
		 if(target == result) return true;
		 else return false;
	}
	
	public static boolean equals(Object result, Object target) {
		if(result.equals(target)) return true;
		else return false;
	}

	public static void main(String[] args) {
		// protocol//[hosts][/database][?properties]
		// oracle -> jdbc:oracle:thin:@myhost:1521:orcl
		// mysql -> jdbc:mysql://host:3306/sakila
		log.setLevel(Level.INFO);
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		while (true) {
			System.out.print("1.보기 2.입력 0.종료 > ");
			input = sc.nextLine();

			if (input.equals("0"))
				break;
			else if (input.equals("1")) {
				System.out.println("-------------------------------------------");
				System.out.println("deptno\t|dname\t|loc");
				System.out.println("-------------------------------------------");
				
				
				Connection conn = getConnection();
				Statement statement = null;
				ResultSet rs = null;
				try {
					statement = conn.createStatement();
					rs = statement.executeQuery("select deptno, dname, loc from dept order by deptno desc");
					
					while(rs.next()) {
						System.out.print(rs.getString(1) + "\t");
						System.out.print(rs.getString(2) + "\t");
						System.out.println(rs.getString(3) + "\t");
					}
					System.out.println("-------------------------------------------");
					
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
				
				
				
			} else if (input.equals("2")) {
				System.out.print("deptno > ");
				input = "insert into dept values (" + sc.nextLine();
				System.out.print("dname > ");
				input += ",'" + sc.nextLine();
				System.out.print("loc > ");
				input += "','" + sc.nextLine() + "')";
				
				log.info(input);
				Connection conn = null;
				Statement statement = null;
				
				try {
					conn = getConnection();
					statement = conn.createStatement();
					statement.executeUpdate(input);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(statement != null) statement.close();
						if(conn != null) conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
				
				
				
			}

		}

	}
}
