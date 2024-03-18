package com.peisia.db;

import java.io.IOException;

import com.peisia.c.util.Cw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class ServletController extends HttpServlet {
	String nextPage;
	Dao dao;
	
	@Override
	public void init() throws ServletException { //서블릿이 최초 실행되는 시점에서 초기화 작업을 함
		dao = new Dao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		Cw.wn("action:"+action);
		if(action!=null) {
			switch(action) {
			//했음
			case "/del":
				Cw.wn("삭제");
				nextPage="/list.jsp";
				dao.del(request.getParameter("no"));				
				break;
			case "/write"://todo
				Cw.wn("쓰기");
				nextPage="/write.jsp";
				break;
			case "/edit"://todo
				Cw.wn("수정");
				nextPage="/edit.jsp";
				break;
			case "/read"://todo
				Cw.wn("읽기");
				nextPage="/read.jsp";
				break;
			case "/list"://todo
				Cw.wn("리스트");
				nextPage="/list.jsp";
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}
}