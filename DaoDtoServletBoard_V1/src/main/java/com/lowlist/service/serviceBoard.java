package com.lowlist.service;

import com.lowlist.BoardDao.BoardListDao;
import com.lowlist.BoardDao.BoardMemberDao;
import com.lowlist.Dto.Dto;

public class serviceBoard {
	
	BoardListDao board_dao = new BoardListDao();
	BoardMemberDao member_dao = new BoardMemberDao();
	boolean login = true;
	
//	public serviceBoard() {
//		board_dao = new BoardListDao();
//		member_dao = new BoardMemberDao();
//	}
	
	public void del(String no) {
		board_dao.del(no);
	}
	
	public void write(Dto d) {
		board_dao.write(d);
	}
	
	public Dto read(String no) {
		return board_dao.read(no);
	}
	
	public void edit(Dto d,String no) {
		board_dao.edit(d, no);
	}
	
	public boolean login(String id , String pw) {
		login = false;
		if(member_dao.login_run(id, pw)) {
		   login = true;
		} else {
		    System.out.println("id, pw 불일치");
		   login = false;
		}
		return login;
	
	}
}
