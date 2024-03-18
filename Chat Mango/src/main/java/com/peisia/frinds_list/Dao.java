package com.peisia.frinds_list;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao extends Da {

	// 아이디 고유번호로 프렌드리스트에 친구추가 만들기
//	public void 

	// 프렌드 체크박스에 대기할수 있는거 만들기
	public void friendCheckBox(String word, String tag, String no) {
		String Friend_No = null;
		int MyloginNo = 0;
		Friend_No = userNo(word, tag);
		MyloginNo = loginMyNo(no);
		start();
		String sql = String.format("insert into %s(my_user_no, friend_user_no) values(%s, %s)", Db.DB_TABLE_CHECKBOX,
				MyloginNo, Friend_No);
		System.out.println("sql문확인용:" + sql);
		update(sql);
		close();
	}

	// 로그인한 아이디 고유번호 꺼내오기
	public Integer loginMyNo(String no) {
		start();
		int logins = 0;
		try {
			String sql = String.format("select*from %s where user_no=%s", Db.DB_TABLE_USERNAME, no);
			System.out.println("sql:" + sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			logins = rs.getInt("user_no");
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return logins;
	}

	// 친구 목록 번호 Dao
	public ArrayList<Dto> friendList(String no) {
		ArrayList<Dto> list = new ArrayList<>();
		try {
			super.start();
			String sql = String.format("select*from %s where my_user_no = %s", Db.DB_TABLE_LIST, no);
			ResultSet rs = st.executeQuery(sql);
			System.out.println("sql:" + sql);
			while (rs.next()) {
				list.add(new Dto(rs.getString("friend_user_no")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	// 친구 목록 이름으로 출력
	public Dto name(String no) {
		Dto ck = null;
		String sql = String.format("select * from %s where user_no = %s", Db.DB_TABLE_USERNAME, no);
		System.out.println("sql:" + sql);
		try {
			start();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			ck = new Dto(no,rs.getString("user_Name"),rs.getString("user_Tag"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	// 친구 닉네임과 태그로 고유번호 찾기
	public String userNo(String name, String tag) {
		String ck = null;
		String sql = String.format("select * from %s where user_name='%s' and user_tag='%s'", Db.DB_TABLE_USERNAME,
				name, tag);
		System.out.println("sql:" + sql);
		try {
			start();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			ck = rs.getString("user_no");
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	// 친구 추가 user_name, user_tag 찾기
	public Dto listSearch(String word, String tag) {
		start(); // [고정1,2,3]
		Dto posts = null;
		String sql = String.format("select * from %s where user_name = '%s' and user_tag = '%s'", Db.DB_TABLE_USERNAME,
				word, tag);
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				posts = new Dto(rs.getString("user_name"), rs.getString("user_tag"));
			}
		} catch (Exception e) {
			System.out.println("sql:" + sql);
			e.printStackTrace();
		}
		close();
		return posts;
	}
	
	//친구 삭제 실행문
	public void friendDel(String myNo, String friendNo) {
		del(myNo,friendNo);
		del(friendNo,myNo);
	}
	
	//친구 삭제 명령 입력문
	private void del(String myNo, String friendNo) {
		start();
		String delNo = String.format(
				"delete %s where my_user_no= %s and freind_user_no = %s"
				, Db.DB_TABLE_LIST, myNo, friendNo);
		update(delNo);
		close();
	}
}

//	//닉네임과 유저 태크 중복체크
//	public boolean check(String name, String tag) {
//		start();
//		boolean ck = false;
//		String sql = String.format("select count(*) from %s where userName='%s' and userTag='%s'"
//				, Db.DB_TABLE_USERNAME, name, tag
//				);
//		try {
//			ResultSet rs = st.executeQuery(sql);
//			rs.next();
//			int a = rs.getInt("count(*)");
//			if(a == 1) {
//				ck = true;
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		close();
//		return ck;
//	}

//	친구 추가 Dao << 예전꺼임		
//	public void friend_plus(Dto d) {
//		start();
//		String sql = String.format(
//				"insert into %s(no, my_user_no, friend_user_no) values(%s, %s)",
//				Db.DB_TABLE, d.My_User_no, d.Friend_User_no);
//		update(sql);
//		close();
//	}