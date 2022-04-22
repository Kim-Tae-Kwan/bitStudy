package com.bit.test04;

import java.sql.*;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/scott";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 성적 관리 프로그램 (0.9.0)");
		String input = null;
		while(true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료 > ");
			input = sc.nextLine();
			if(input.equals("0")) break;
			else if(input.equals("1")) {
				String sql = "select num, name, kor, eng, math, truncate((kor+eng+math)/3, 2) from stu01";
				try {
					conn = DriverManager.getConnection(url, System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASSWORD"));
					statement = conn.createStatement();
					rs = statement.executeQuery(sql);
					
					while(rs.next()) {
						System.out.print(rs.getInt(1) + "\t");
						System.out.print(rs.getString(2) + "\t");
						System.out.print(rs.getInt(3) + "\t");
						System.out.print(rs.getInt(4) + "\t");
						System.out.print(rs.getInt(5) + "\t");
						System.out.println(rs.getInt(6));
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
			
			
			
			
		}
		System.out.println("이용해주셔서 감사합니다.");
	}

}
