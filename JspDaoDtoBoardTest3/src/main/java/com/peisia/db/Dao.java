package com.peisia.db;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao extends Da {
	//글리스트
	public ArrayList<Dto> list(String page) {
		connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*3;
			
			String sql = String.format("select*from %s limit %s,3"
					,Db.TABLE_PS_BOARD_FREE,startIndex);
			System.out.println("sql:+");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		close();
		return posts;
	}
	
	//전체 글 수 구하기
	public int getPostCount() {
		int count = 0;
		connect();
		try {
			String sql = String.format(
					"select count(*) from %s"
					, Db.TABLE_PS_BOARD_FREE
					);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch(Exception e) {
			e.printStackTrace();
		}
		close();
		return count;
	}
	
	//검색한 총 글수 구하기
	public int getSearchPostCount(String word) {
		int count=0;
		connect();
		try {
			String sql = String.format(
					"select count(*) from %s where b_title like '%%%s%%'"
					, Db.TABLE_PS_BOARD_FREE
					, word);
			System.out.println("sql:" + sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch(Exception e) {
			e.printStackTrace();
		}
		close();
		return count;
	}
	
	//글리스트 검색
	public ArrayList<Dto> listSearch(String word, String page){
		connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*3; //페이지 한페이지당 3개씩
			String sql = String.format(
					"select*from %s where b_title like '%%%s%%' limit %s,3"
					, Db.TABLE_PS_BOARD_FREE, word , startIndex);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) { //글리스트 불러오기
				posts.add(new Dto(
						rs.getString("b_no"),
						rs.getString("b_title"),
						rs.getString("b_id"),
						rs.getString("b_datetime"),
						rs.getString("b_hit"),
						rs.getString("b_text"),
						rs.getString("b_reply_count"),
						rs.getString("b_reply_ori")
						));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		close();
		return posts;
	}
	
	//총페이지수 구하기
	public int getTotalPageCount() {
		int totalPageCount = 0;
		int count = getPostCount();
		
		if(count % 3 == 0) {//나누기했을때 나머지가 없이 딱 맞아 떨어질떄
			totalPageCount = count / 3;
		} else {
			totalPageCount = count / 3+1;
		}
		return totalPageCount;
	}
	
	//검색한글 총 페이지 수 구하기
	public int getSearchTotalPageCount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostCount(word);
		
		if(count % 3 == 0) {
			totalPageCount = count / 3;
		} else {
			totalPageCount = count / 3 + 1;
		}
		return totalPageCount;
	}
	
	//글읽기
	public Dto read(String no) {
		connect();
		Dto post = null;
		try {
			String sql = String.format(
					"select*from %s where b_no=%s"
					, Db.TABLE_PS_BOARD_FREE, no);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
		} catch(Exception e) {
			e.printStackTrace();
		}
		close();
		return post;
	}
	
	//글쓰기
	public void write(Dto d) {
		connect();
		String sql = String.format("insert into %s(b_title, b_id, b_text) values('%s', '%s', '%s')"
				, Db.TABLE_PS_BOARD_FREE
				, d.title
				, d.id
				, d.text
				);
		update(sql);
		close();
	}
	
	//글삭제
	public void del(String no) {
		connect();
		String sql = String.format("delete from %s where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, no);
		update(sql);
		close();
	}
	
	//글수정
	public void edit(Dto d ,String no) {
		connect();
		String sql = String.format(
				"update %s set b_title='%s',b_text='%s' where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.text,no);
		update(sql);
		close();
	}
}
