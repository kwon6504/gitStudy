package com.MangoChat.LoginDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MangoChat.MasterClass.Master_DA;


public class L_Dao extends Master_DA {

// 로그인 
	
	public L_Dto login(String id,String pw) {
		L_Dto ck = null;
		String sql = String.format("SELECT * FROM %s WHERE id = '%s' AND pw = '%s'", DB_TABLE_LOGIN,id,pw);
		try {
			ResultSet rs = super.Query(sql);
			rs.next();
			ck = new L_Dto(rs.getString("userNo"), id , rs.getString("userName"),rs.getString("userTag"));
		} catch (SQLException | NullPointerException e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			close();
		}
		return ck;
	}
	public boolean loginCk(String id,String pw) {
		boolean ck = false;
		String sql = String.format("SELECT COUNT(*) FROM %s WHERE id = '%s' AND pw = '%s'", DB_TABLE_LOGIN, id, pw);
		try {
			ResultSet rs = super.Query(sql);
			rs.next();
			int a = rs.getInt("COUNT(*)");
			if(a == 1) {
				ck = true;
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ck;
	}

	public boolean signUpIdCk(String id) { // 아이디 중복
		boolean ck = false;
		try {
			String sql = String.format("SELECT COUNT(*) FROM %s WHERE id = '%s'", DB_TABLE_LOGIN, id);
			ResultSet rs = super.Query(sql);
			rs.next();
			String idCk = rs.getString("COUNT(*)");
			if (idCk.equals("0")) {
				ck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	public void sigbUp(L_Dto a) {
		int userTag = userTag(a.userName);
		try {
			String sql = String.format("INSERT INTO %s (id,pw,userName,userTag) values ('%s','%s','%s',%s)", DB_TABLE_LOGIN, a.id,
					a.pw, a.userName, userTag);
			super.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}

	private int userTag(String name) {
		int num = 0;
		try {
			String sql = String.format("SELECT MAX(userTag) FROM %s WHERE userName = '%s' ", DB_TABLE_LOGIN	, name);
			ResultSet rs = super.Query(sql);
			rs.next();
			num = rs.getInt("MAX(userTag)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return num + 1;
	}

}
