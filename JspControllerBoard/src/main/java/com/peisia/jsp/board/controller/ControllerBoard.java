package com.peisia.jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.jsp.board.dto.Dto;
import com.peisia.jsp.board.service.ServiceBoard;

@WebServlet("/board/*")
public class ControllerBoard extends HttpServlet {
	String category;
	String nextPage;
	ServiceBoard service;
	@Override // 상속
	public void init() throws ServletException {
		service = new ServiceBoard();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		category = request.getParameter("category");
		String action = request.getPathInfo();
		System.out.println("action:"+action);
		if(action!=null) {
			switch(action) {
			case "/del":
				nextPage = "/board/list";
				service.del(category, request.getParameter("no"));
				break;
			case "/write":
				nextPage = "/board/list";
				Dto dto = new Dto(
						category
						,request.getParameter("title")
						,request.getParameter("id")
						,request.getParameter("text")
						);
				service.write(dto);
				break;
			}
		}
	}
}
