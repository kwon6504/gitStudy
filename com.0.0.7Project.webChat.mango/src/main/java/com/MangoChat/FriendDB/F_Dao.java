package com.MangoChat.FriendDB;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.MangoChat.LoginDB.L_Dto;
import com.MangoChat.MasterClass.Master_DA;
import com.MangoChat.MasterClass.Master_DB;

public class F_Dao extends Master_DA {
	
	public boolean friendCheckBoxBoolean(String name, String tag, String no) {
		boolean Check = true;
		String Friend_No = null;
		Friend_No = friendUserNo(name, tag);
		if(friendCheckBoxCount(no,Friend_No).equals("1")) {
			Check = false;
		}else{
			Check = true;
		}
		return Check;
	}
	
	//친구추가 명령문
	private void Add(String myNo, String friendNo) {
		String AddNo = String.format("insert into %s(my_user_no, friend_user_no) values(%s, %s)"
				, DB_TABLE_LIST, myNo, friendNo);
		update(AddNo);
		close();
		// 체크박스 활용해서 추가기능 만들면 되요~~
		// 체크박스 테이블에 들어가있는거 삭제 후 프렌드리스트 찐 테이플에 추가하는거 추가하면 됩니당~~
		// jsp 에서 신청받은 리스트 추가하는건 나중에 하면되요~~
		// 이 글은 10초뒤 자동으로 삭제는 안되니까 알아서 삭제 해주세요~~
	}
	
	//친구추가 실행문
	public void friendAdd(String myNo, String friendNo) {
		Add(myNo,friendNo);
		Add(friendNo,myNo);
		checkDel(friendNo,myNo);
	}
	
	public String friendCheckBoxCount(String no, String friendNo){
		String Count = null;
		try {
			String sql = String.format("select COUNT(*) from %s where my_user_no = %s and friend_user_no = %s", Master_DB.DB_TABLE_CHECKBOX,no,friendNo);
			ResultSet rs = super.Query(sql);
			System.out.println("sql:" + sql);
			rs.next();
			Count = rs.getString("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return Count;
	}
	
	// 프렌드 체크박스에 신청된 정보 입력
	public void friendCheckBox(String name, String tag, String no) {
		String Friend_No = null;
		int MyloginNo = 0;
		Friend_No = friendUserNo(name, tag);
		MyloginNo = loginMyNo(no);
		String sql = String.format("insert into %s(my_user_no, friend_user_no) values(%s, %s)", Master_DB.DB_TABLE_CHECKBOX,
				MyloginNo, Friend_No);
		System.out.println("sql문확인용:" + sql);
		update(sql);
		close();
	}
	
	//친구 신청 왔을때 확인하는 Dao
	public ArrayList<F_Dto> friendPlusCheck(String no) {
		ArrayList<F_Dto> check = new ArrayList<>();
		try {
			String sql = String.format("select*from %s where friend_user_no= %s"
					,Master_DB.DB_TABLE_CHECKBOX, no);
			ResultSet rs = super.Query(sql);
			System.out.println("sql: "+sql);
			while(rs.next()) {
				check.add(new F_Dto(rs.getString("my_user_no")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		close();
		return check;
	}

	// 로그인한 아이디 계정 넘버 꺼내오기
	public Integer loginMyNo(String no) {
		int logins = 0;
		try {
			String sql = String.format("select*from %s where userNo=%s", Master_DB.DB_TABLE_LOGIN, no);
			System.out.println("sql:" + sql);
			ResultSet rs = super.Query(sql);
			rs.next();
			logins = rs.getInt("userNo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return logins;
	}

	// 친구 목록 번호 Dao
	public ArrayList<F_Dto> friendList(String no) {
		ArrayList<F_Dto> list = new ArrayList<>();
		try {
			String sql = String.format("select*from %s where my_user_no = %s", Master_DB.DB_TABLE_LIST, no);
			ResultSet rs = super.Query(sql);
			System.out.println("sql:" + sql);
			while (rs.next()) {
				list.add(new F_Dto(rs.getString("friend_user_no")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	// 친구 목록 이름 및 태그로 출력
	public F_Dto friendInfo(String no) {
		F_Dto ck = null;
		String sql = String.format("select * from %s where userNo = %s", Master_DB.DB_TABLE_LOGIN, no);
		System.out.println("sql:" + sql);
		try {
			ResultSet rs = super.Query(sql);
			rs.next();
			ck = new F_Dto(no,rs.getString("userName"),rs.getString("userTag"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	// 친구 닉네임과 태그로 고유번호 찾기
	public String friendUserNo(String name, String tag) {
		String ck = null;
		String sql = String.format("select * from %s where userName='%s' and userTag='%s'", Master_DB.DB_TABLE_LOGIN,
				name, tag);
		System.out.println("sql:" + sql);
		try {
			ResultSet rs = super.Query(sql);
			rs.next();
			ck = rs.getString("userNo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	// 친구 찾기 (이름에 해당되는 글자 있으면 전부 표시) 자기 자신은 로그인 세션 활용해서 검색 안되게 예외 처리 해둠
	public ArrayList<L_Dto> listSearch(String name , String no) {
		ArrayList<L_Dto> listSearch = new ArrayList<L_Dto>();
		String sql = String.format("select * from %s where userName like '%%%s%%' AND userNo != '%s'", Master_DB.DB_TABLE_LOGIN,
				name,no);
		try {
			ResultSet rs = super.Query(sql);
			while (rs.next()) {
				listSearch.add(new L_Dto(rs.getString("userName") , rs.getString("userTag")));
			}
		} catch (Exception e) {
			System.out.println("sql:" + sql);
			e.printStackTrace();
		}
		close();
		return listSearch;
	}
	
	// 친구 찾기 (이름,태그 정확할때만 작동) 자기 자신은 로그인 세션 활용해서 검색 안되게 예외 처리 해둠
	public ArrayList<L_Dto> tagListSearch(String name, String tag , String no) {
		ArrayList<L_Dto> taglistSearch = new ArrayList<L_Dto>();
		String sql = String.format("select * from %s where userName = '%s' and userTag = '%s' AND userNo != '%s'", Master_DB.DB_TABLE_LOGIN,
				name, tag , no);
		try {
			ResultSet rs = super.Query(sql);
			while (rs.next()) {
				taglistSearch.add(new L_Dto(rs.getString("userName"), rs.getString("userTag")));
			}
		} catch (Exception e) {
			System.out.println("sql:" + sql);
			e.printStackTrace();
		}
		close();
		return taglistSearch;
	}
	
	//친구 삭제 실행문
	public void friendDel(String myNo, String friendNo) {
		del(myNo,friendNo);
		del(friendNo,myNo);
	}
	
	//친구 삭제 명령 입력문
	private void del(String myNo, String friendNo) {
		String delNo = String.format(
				"delete from %s where my_user_no= %s and friend_user_no = %s"
				, Master_DB.DB_TABLE_LIST, myNo, friendNo);
		update(delNo);
		close();
	}
	
	//친구체크박스문 삭제
	private void checkDel(String myNo, String friendNo) {
		String delNo = String.format(
				"delete from %s where my_user_no= %s and friend_user_no = %s"
				, Master_DB.DB_TABLE_CHECKBOX, myNo, friendNo);
		update(delNo);
		close();
	}
}

