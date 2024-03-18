package com.peisia.jsp.board.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.peisia.db.Dao;
import com.peisia.jsp.board.Board;
import com.peisia.jsp.board.dto.Dto;

public class DaoBoard extends Dao {
	// 삭제 Dao
	public void del(String category, String no) {
		connect();
		String sql = String.format("delete from %s where b_no=%s and b_category like '%s'"
				, Board.TABLE_PS_BOARD_FREE, no, category);
		update(sql);
		close();
	}
	
	//글리스트 출력하는 함수
	public ArrayList<Dto> selectList(String category, int startIndex) {
		connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format(
					"select * from %s where b_category = '%s' limit %d,%d"
					,Board.TABLE_PS_BOARD_FREE
					,category
					,startIndex
					,Board.LIST_AMOUNT
					);
			System.out.println("sql :"+ sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				posts.add(new Dto(
						rs.getString("B_CATEGORY"),
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
	
	//검색한 후 글리스트 출력 함수
		public ArrayList<Dto> selectList(String category, int startIndex, String word) {
			connect();
			ArrayList<Dto> posts = new ArrayList<>();
			try {
				String sql = String.format(
						"select * from %s where b_title like '%%%s%%' and b_category = '%s' limit %d,%d"
						,Board.TABLE_PS_BOARD_FREE
						,word
						,category
						,startIndex
						,Board.LIST_AMOUNT
						);
				System.out.println("sql :"+ sql);
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					posts.add(new Dto(
							rs.getString("B_CATEGORY"),
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
		
		//총 글 수 구하기
		public int selectPostCount(String category) {
			int count = 0;
			connect();
			try {
				String sql = String.format("select count(*) from %s where b_catgory = '%s'", Board.TABLE_PS_BOARD_FREE, category);
				System.out.println("sql: "+sql);
				ResultSet rs = st.executeQuery(sql);
				rs.next();
				count = rs.getInt("count(*)");
			} catch (Exception e) {
				e.printStackTrace();
			}
			close();
			return count;
		}
		
		//검색 총 글 수 구하기
		public int selectSearchPostCount(String category, String word) {
			int count = 0;
			connect();
			try {
				String sql = String.format("select count(*) from %s where b_catgory = '%s' and b_title = '%%%s%%'"
						, Board.TABLE_PS_BOARD_FREE, category, word);
				System.out.println("sql: " + sql);
				ResultSet rs = st.executeQuery(sql);
				rs.next();
				count = rs.getInt("count(*)");
			} catch (Exception e) {
				e.printStackTrace();
			}
			close();
			return count;
		}
		
		//글쓰기
		public void insert(Dto d) {
			connect();
			String sql = String.format(
					"insert into %s (b_category, b_title, b_id, b_title) values ()"
					);
		}
}
