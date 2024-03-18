package com.MangoChat.RoomDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.MangoChat.MasterClass.Master_DA;
import com.MangoChat.MasterClass.Master_DB;

public class R_Dao extends Master_DA {

	public void create(String userNo, String roomName, String userMax) { // 방 만들기
		chatroom(userNo, roomName, userMax); // 채팅창 정보 생성, 유저 넘버, 설정한 채팅이름, 채팅창 노출 여부 등
		String roomNo = roomNo(userNo); // 채팅창 넘버 구하는함수
		chatJoin(userNo, roomNo); // 채팅창 넘버와 유저 넘버를 묶어서 연관시키는 함수
	}

	private void chatroom(String userNo, String roomName, String userMax) { // 채팅방 정보 생성 <-- 첫번째
		try {
			String sql = String.format("INSERT INTO %s(bossNo,roomName,userMax)values(%s,'%s',%s)",
					Master_DB.DB_TABLE_ROOM, userNo, roomName, userMax);
			// 공개 비공개 or 최대인원수는 임시로 지정해줌
			super.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
	}

	private String roomNo(String userNo) {
		String re = null;
		String sql = String.format("SELECT MAX(roomNo) FROM %s WHERE bossNo = %s", DB_TABLE_ROOM, userNo);
		try {
			// 가장 마지막에 만들어진게 바로전에 INSERT 해준 값이기 때문에 MAX 로 값을 구해줌, 유저넘버가 들어간이유는 혹시라도 동시에
			// 방만드는경우가 생길까봐
			ResultSet rs = super.Query(sql);
			rs.next();
			re = rs.getString("MAX(roomNo)");
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			super.close();
		}
		return re;
	}

	private void chatJoin(String userNo, String roomNo) { // 두번째
		String sql = String.format("INSERT INTO %s(userNo,roomNo)values(%s,%s)",DB_TABLE_JOIN ,userNo, roomNo);
		try {
			// 채팅넘버와 유저 넘버 연관시켜줌
			super.update(sql);
		} catch (Exception e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			super.close();
		}
	}

	private ArrayList<String> roomNoList(String userNo) { // 들어가 있는 방 찾기
		ArrayList<String> roomList = new ArrayList<String>();
		String sql = String.format("SELECT * FROM %s WHERE userNo = %s", DB_TABLE_JOIN, userNo);
		try {
			ResultSet rs = super.Query(sql);
			while (rs.next()) {
				roomList.add(rs.getString("roomNo"));
			}
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		} finally {
			super.close();
		}
		return roomList;
	}

	public ArrayList<R_Dto> roomList(String userNo) { // 들어와 있는방들의 정보 확인용
		ArrayList<String> roomNoList = roomNoList(userNo);
		ArrayList<R_Dto> roomListg = new ArrayList<>();
		for (String no : roomNoList) {
			String sql = String.format("SELECT * FROM %s WHERE roomNo = %s", DB_TABLE_ROOM, no);
			try {
				ResultSet rs = super.Query(sql);
				rs.next();
				roomListg.add(new R_Dto(no, rs.getString("bossNo"), rs.getString("roomName"), rs.getString("userMax")));
			} catch (Exception e) {
				System.out.println(sql);
				e.printStackTrace();
			} finally {
				super.close();
			}
		}

		return roomListg;
	}
	
	

//	public int roomUserCount() { 최대 인원확인용.
//		
//	}

	
	

}
