package com.bit.database;

// 데이터베이스 연결.
// insert, update, delete

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.*;

public class Crud {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test01";
		
//		String sql = "insert into bbs01 values (7, 'test7', 'tester', 'test')";
//		String sql = "update bbs01 set content='test' where num=6";
		String sql = "delete from bbs01 where num=6";
		
		// IO&Map 동시
		Properties info = new Properties();
		info.setProperty("user", "user01");
		info.setProperty("password", "1234");
		
		try {
			Driver driver = new Driver();
			Connection connection = DriverManager.getConnection(url, info);
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
			statement.close();
			connection.close();
			System.out.println("DML 수행 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
