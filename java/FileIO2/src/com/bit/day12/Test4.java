package com.bit.day12;

import java.sql.*;
import java.util.*;

public class Test4{
	static Scanner sc = new Scanner(System.in);
	
	/** 
	 * Mysql에 연결하여 Connetion 반환한다.
	 * @return Connetion
	 */
	public static Connection getConnection() {
		String url = "jdbc:mysql://192.168.128.133:3306/test";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 새로운 학생 정보를 입력한다.
	 * @param name : 학생 이름
	 * @param grades : 학생 성적
	 */
	public static void insert(String name, int[] grades) {
		String sql = "insert into student (name, kor, eng, math) values ('" + name + "', " + grades[0] + "," + grades[1]
				+ "," + grades[2] + ");";
		execute(sql);
	}

	/**
	 * 학번과 새로운 성적으로 학생 정보를 수정한다.
	 * @param num : 학번
	 * @param grades : 새로운 성적.
	 */
	public static void update(int num, int[] grades) {

		String sql = "update student set kor=" + grades[0] + ", eng=" + grades[1] + ", math=" + grades[2]
				+ " where num=" + num + ";";

		execute(sql);
	}

	/**
	 * 학번으로 학생 정보를 삭제한다.
	 * @param num : 학번.
	 */
	public static void delete(int num) {
		String sql = "delete from student where num = " + num + ";";
		execute(sql);
	}

	/**
	 * update, insert, delete 쿼리문을 수행한다.
	 * @param sql : 쿼리문.
	 */
	public static void execute(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 학번으로 학생 이름을 받는다.
	 * @param num : 학번.
	 * @return 학생 이름.
	 */
	public static String getName(int num) {
		String sql = "select name from student where num=" + num + ";";
		String name = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	/**
	 * 저장되어 있는 모든 학생 정보를 출력한다.
	 */
	public static void printStudentInfo() {
		String sql = "select * from student;";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getInt(5) + "\t"
						+ ((rs.getInt(3) + rs.getInt(4) + rs.getInt(5)) * 100 / 3 / 100.0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 존재하는 학번인지 유효성 검사한다.
	 * @param num : 학번
	 * @return true : 존재, false : 존재하지 않음.
	 */
	public static boolean numValidate(int num) {
		String sql = "select * from student where num=" + num + ";";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			result = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 각 성적을 순서대로 입력 받는다.
	 * 
	 * @param input - 학번
	 * @return int[] - 각 과목의 점수
	 * 
	 */
	public static int[] getGrades(String name) {
		String[] sub = { "국어", "영어", "수학" };
		int[] grades = new int[sub.length];
		for (int i = 0; i < grades.length; i++) {
			System.out.print(name + " 님 " + sub[i] + " > ");
			try {
				int num = Integer.parseInt(sc.nextLine());
				if (num > 100) {
					System.out.println("점수는 100을 초과할 수 없습니다.\n");
					i--;
					continue;
				}
				grades[i] = num;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.\n");
				i--;
			}
		}
		return grades;
	}

	/**
	 * 학번 입력 받기. 학번의 존재 유무 확인 후 학번을 반환한다.
	 * 
	 * @param option - 0 : 수정, 1 : 삭제
	 * @return 유효성 검사를 통과한 학번.(뒤로가기 0 반환)
	 */
	public static int getStudentNumber(int option) {
		int input = 0;
		String[] action = { "수정", "삭제" };
		while (true) {
			System.out.print(action[option] + "할 학번 (뒤로가기 0)> ");

			// 숫자 입력 유효성 검사.
			try {
				input = Integer.parseInt(sc.nextLine());
				if (input == 0)
					break;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요.\n");
				continue;
			}

			// 존재하는 학번 검사.
			if (!numValidate(input)) {
				System.out.println(input + "학번은 존재하지 않습니다.\n");
				continue;
			}
			break;
		}
		return input;
	}

	/**
	 * 학생 정보 표시 줄 생성
	 * @return ------------------------
	 */
	public static String getLine() {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < 46; i++) {
			line.append("-");
		}
		return line.toString();
	}

	public static void main(String[] args) {
		String line = getLine();
		System.out.println("학생 성적 관리 프로그램 (ver 0.9.0)");

		int input = 0;
		while (true) {
			System.out.print("\n1.입력 2.보기 3.수정 4.삭제 0.종료 > ");
			try {
				input = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("메뉴를 보고 다시 입력해주세요.\n");
				continue;
			}

			if (input == 0) {// 0.종료
				System.out.print("이용해주셔서 감사합니다.");
				break;
			} else if (input == 1) {// 1.입력
				System.out.print("이름 > ");
				String name = sc.nextLine();
				int[] grades = getGrades(name);
				insert(name, grades);
			} else if (input == 2) {// 2.보기
				System.out.println(line);
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println(line);
				printStudentInfo();
				System.out.println(line);
			} else if (input == 3) {// 3.수정
				input = getStudentNumber(0);
				if (input == 0)
					continue;
				String name = getName(input);
				int[] grades = getGrades(name);

				update(input, grades);

				System.out.println(input + "학번 수정 완료.\n");
			} else if (input == 4) {// 4.삭제
				input = getStudentNumber(1);
				if (input == 0)
					continue;
				delete(input);

				System.out.println(input + "학번 삭제 완료.\n");
			} else
				System.out.println("메뉴를 보고 다시 입력해주세요.\n");
		}
	}
}
