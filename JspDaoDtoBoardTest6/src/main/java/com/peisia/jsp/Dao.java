package com.peisia.jsp;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao extends Da {
	//글리스트
	public ArrayList<Dto> list(String page) { 
		ArrayList<Dto> posts = new ArrayList<>();
		connect();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*Board.List_Amount;
			String sql = String.format("select * from %s limit %s, %s", Db.TABLE_PS_BOARD_FREE, startIndex,
					Board.List_Amount);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return posts;
	}
	
	//글읽기
	public Dto read(String no) {
		connect();
		Dto post = null;
		try {
			String sql = String.format(
					"select*from %s where b_no='%s'",
					Db.TABLE_PS_BOARD_FREE, no);
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
		String sql = String.format(
				"insert into %s (b_title, b_id, b_text) values('%s', '%s', '%s')"
				, Db.TABLE_PS_BOARD_FREE, d.title, d.id, d.text);
		update(sql);
		close();
	}
	
	//글삭제
	public void del(String no) {
		connect();
		String sql = String.format("delete from %s where b_no=%s"
				, Db.TABLE_PS_BOARD_FREE, no);
		update(sql);
		close();
	}
	
	//글수정
	public void edit(Dto d, String no) {
		connect();
		String sql = String.format("update %s set b_title='%s', b_text='%s' where b_no=%s"
				, Db.TABLE_PS_BOARD_FREE, d.title, d.text, no);
		update(sql);
		close();
	}
	
	// 총 글 수 구하기
	public int getPostCount() {
		int count = 0;
		connect();
		try {
			String sql = String.format("select count(*) from %s"
					, Db.TABLE_PS_BOARD_FREE);
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
	
	//검색한 글의 총수 구하기
	public int getSearchPostCount(String word) {
		int count = 0;
		connect();
		try {
		String sql = String.format("select count(*) from %s where b_title like '%%%s%%'"
				, Db.TABLE_PS_BOARD_FREE, word);
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
	
	//총 페이지 수 구하기
	public int getTotalPageCount() {
		int totalPageCount = 0;
		int count = getPostCount();
		
		if(count % Board.List_Amount == 0) { //%는 나누기가 아니고 나머지를 계산하는 연산자.
			totalPageCount = count / Board.List_Amount;
		} else {
			totalPageCount = count / Board.List_Amount + 1;
		}
		return totalPageCount; 
	}
	
	//총 페이지 수 구하기<검색>
	public int getSearchTotalPageCount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostCount(word);
		
		if(count % Board.List_Amount == 0){		
			totalPageCount = count / Board.List_Amount;
		}else{					
			totalPageCount = count / Board.List_Amount + 1;
		}
		return totalPageCount;
	}
	
	//글리스트 검색
	public ArrayList<Dto> listSearch(String word, String page){
		connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*Board.List_Amount;
			String sql = String.format(
					"select*from %s where like '%%%s%%' limit %s,%s"
					,Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.List_Amount);
			System.out.println("sql:"+sql);
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
}
