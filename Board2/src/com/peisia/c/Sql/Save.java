package com.peisia.c.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Save {
	static Connection con = null;
	static Statement st = null;
	static ResultSet result = null;
	
	
	public static void dbInit() {
		try {
			// (1/n) 디비 접속 정보 넣어서 접속하기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			// (2/n) Statement 객체 얻어오기.
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	private static void dbExecuteUpdate(String sql) {
//		try {
//			int resultCount = st.executeUpdate(sql);
//			Cw.wn("등록되었습니다 :" + resultCount);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static String dbExecuteQueryString(String query,String a,String b) {
		String name = b;
		try {
			System.out.println("1차 오류");
			result = st.executeQuery(query);
			System.out.println(result);
			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				name = result.getString(a);
				return name;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
		return name;
	}
	
	
	public static int dbExecuteQuery(String query,String a,int b) {
		int name = b;
		try {
			System.out.println("1차 오류");
			result = st.executeQuery(query);
			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				name = result.getInt(a);
				return name;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
		return name;
	}
	
//	public static String dbExecuteQuery(String query)
}






