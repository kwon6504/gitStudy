package com.MangoChat.util;

import java.sql.ResultSet;

import com.MangoChat.LoginDB.L_Dto;
import com.MangoChat.MasterClass.Master_DA;
import com.MangoChat.MasterClass.Master_DB;

public class Util extends Master_DA {

	public L_Dto userName(String userNo) {
		L_Dto name = null;
		String sql = String.format("SELECT * FROM %s WHERE userNo = %s", Master_DB.DB_TABLE_LOGIN, userNo);
		try {
			ResultSet rs = super.Query(sql);
			rs.next();
			name = new L_Dto(rs.getString("userName"), rs.getString("userTag"));
		} catch (Exception e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	
	public int roomUserCount(String roomNo) {
		int count = 0;
		String sql = String.format("SELECT COUNT(*) FROM %s WHERE roomNo = %s", DB_TABLE_JOIN, roomNo);
		try {
			ResultSet rs = super.Query(sql);
			rs.next();
			count = rs.getInt("COUNT(*)");
		} catch (Exception e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			close();
		}
		return count;
	}
}
