package com.peisia.c.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.peisia.util.Cw;

public class Load {
	static Scanner sc = new Scanner(System.in);
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;

	public static void initDb() { // db와 연동해주는 함수, 생략 가능하나 무조건 넣는게 좋다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void writer_run(String xx) {

////	Scanner sc=new Scanner(System.in);
////	System.out.println("글제목을 입력해주세요:");
//	String title = null;
////	System.out.println("글내용을 입력해주세요:");
//	String con = null;
////	System.out.println("작성자 id를 입력해주세요:");
//	String id = null;
//	int hit = 0;
		dbExecuteUpdate(xx);
	}
	
	public static int getPostCount() {
		String count = "";
		try {
			result = st.executeQuery("select count(*) from board where b_reply_ori is null and b_del = 0");
			//db에다가 ""안에 내용을 입력하는 함수.
			result.next(); // 리스트를 받아올때 다음글이 있는지 체크해주는 함수
			count = result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}

	public static void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열
										// 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dbExecuteUpdate(String query) {
		Cw.wn("전송할sql"+query);
		try {
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수:" + resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int dbExecuteUpdateRe(String query) {
		try {
			Cw.wn("전송할sql" + query );
			int resultCount = st.executeUpdate(query);
			Cw.wn("처리된 행 수:" + resultCount);
			return resultCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0; //처리하면서 0로 돌아간다.
	}

	public static boolean dbPostCount(String id) {
		boolean ck = false;
		try {
			result = st.executeQuery("select count(*) from members where u_id = '" + id + "';"); // board에 행 갯수가 몇개인지
																									// 알려주는 명령어
			result.next();
			int count = result.getInt("count(*)");
			System.out.println("중복검사확인:" + count);
			if (count == 0) {
				ck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ck;
	}

	public static boolean dbPostCount(String id, String pw) {
		boolean ck = false;
		try {
			result = st.executeQuery("select count(*) from members WHERE u_id = '" + id + "' and u_pw = '" + pw + "';"); // board에
			result.next();
			int count = result.getInt("count(*)");
			System.out.println("로그인확인숫자:" + count);
			if (count == 0) {
				ck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ck;
	}
	
	public static boolean dbPostCount(int no) {
		boolean ck = false;
		try {
			result = st.executeQuery("select count(*) from board where b_no = '" + no + "';"); // board에 행 갯수가 몇개인지
																									// 알려주는 명령어
			result.next();
			int count = result.getInt("count(*)");
			System.out.println("글존재확인:" + count);
			if (count == 0) {
				ck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ck;
	}

	public static String dbexecuteQuery(String query) {
		System.out.println("==========================================");
		System.out.println("================= 글리스트 ==================");
		System.out.println("==========================================");
		System.out.println("글번호 글제목 작성자id 작성시간 조회수");
		try {
			result = st.executeQuery(query);
			while (result.next()) { // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.

				String no = result.getString("b_no");
				String title = result.getString("b_title");
				String id = result.getString("b_id");
				String datetime = result.getString("b_datetime");
				String hit = result.getString("b_hit");
				System.out.println(no + " " + title + " " + id + " " + datetime + " " + hit);

			}
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return query;
	}
	
	public static String dbexecuteQueryId(String witer,String b_id) {
		b_id = null;
		try {
			result = st.executeQuery(witer);
			while (result.next()) { // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				b_id = result.getString("b_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b_id;
	}
}
