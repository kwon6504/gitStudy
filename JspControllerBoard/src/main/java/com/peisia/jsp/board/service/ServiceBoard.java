package com.peisia.jsp.board.service;

import com.peisia.jsp.board.dao.DaoBoard;
import com.peisia.jsp.board.dto.Dto;

public class ServiceBoard {
	DaoBoard dao;
	public ServiceBoard() {
		dao = new DaoBoard();
	}
	
	public void del(String category, String no) {
		dao.del(category, no);
	}
	
	public void write(Dto d) {
		dao.insert(d);
	}
}
