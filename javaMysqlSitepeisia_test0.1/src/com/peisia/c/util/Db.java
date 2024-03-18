package com.peisia.c.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	static private String DB_NAME = "my_cat";
	static private String DB_ID = "root";
	static private String DB_PW = "root";
	static public String tableName = "board";
	static public Connection con = null;
	static public Statement st = null;
	static public ResultSet result = null;

	// Db 접속 함수
	public static void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_ID, DB_PW);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입 아이디 Db table에 등록
	public static void dbExecuteUpdate(String query) {
		Cw.wn("전송할sql:" + query); // 로그 찍기
		try {
			int resultcount = st.executeUpdate(query);
			Cw.wn("처리된 행 수: " + resultcount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 중복검사 함수
	public static boolean dbPostCount(String id) {
		boolean ck = false;
		try {
			result = st.executeQuery("select count(*) from member where s_id= '" + id + "';");
			result.next();
			int count = result.getInt("count(*)");
			Cw.wn("중복검사확인: " + count);
			if (count == 0) {
				ck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ck;
	}

	// 로그인 처리 함수
	public static boolean isProcLogin(String id, String pw) {
		String count = "";
		try {
			result = st.executeQuery("select count(*) from member where s_id='" + id + "' and s_pw='" + pw + "'");
			result.next();
			count = result.getString("count(*)");
			Cw.wn("찾는 회원의 수: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (count.equals("1")) {
			Cw.wn("[로그인 성공]");
			return true;
		} else {
			Cw.wn("[로그인 실패]");
			return false;
		}
	}

	public static void getPostCount() {
		// TODO Auto-generated method stub
		
	}

}
