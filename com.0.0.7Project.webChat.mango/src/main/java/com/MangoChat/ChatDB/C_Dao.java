package com.MangoChat.ChatDB;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.MangoChat.MasterClass.Master_DA;

public class C_Dao extends Master_DA {

	public ArrayList<C_Dto> chattingList(String roomNo) {
		ArrayList<C_Dto> list = new ArrayList<C_Dto>();
		String sql = String.format("SELECT * FROM %s WHERE roomNo = %s",DB_TABLE_CHATTING,roomNo);
		try {
			ResultSet rs = super.Query(sql);
			while (rs.next()) {
				list.add(new C_Dto(rs.getString("userNo"), rs.getString("chatContent"),rs.getString("createdAt")));
			}
		} catch (Exception e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void chatting(String roomNo, String chatContent,String userNo) {
		String sql = String.format("INSERT INTO %s(roomNo,userNo,chatContent)VALUES(%s,%s,'%s')",DB_TABLE_CHATTING,roomNo,userNo,chatContent);
		try {
			super.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
