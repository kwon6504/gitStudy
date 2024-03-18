package com.lowlist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowlist.BoardDao.BoardMemberDao;
import com.lowlist.Dto.DtoMember;
import com.lowlist.service.serviceBoard;
@WebServlet("/ContorllerServlet")
public class ContorllerServlet extends HttpServlet {
	String category;
	String nextPage;
	serviceBoard service;
	@Override
	public void init() throws ServletException {
		service = new serviceBoard();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getPathInfo();
		
		if(action != null){
			switch(action) {
				case "/del":
					nextPage = "/board/list";
					service.del(request.getParameter("id"));
					break;
				case "/write":
					nextPage = "/board/write";
					break;
				case "/signup":
					nextPage = "/board/signup";
					break;
				case "/login":
					nextPage = "/board/login";
					break;
				}
			}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int no = 0;
		
		System.out.println("초기값"+no);
		System.out.println("아이디"+id);
		System.out.println("패스워드"+pw);
		BoardMemberDao login_add = new BoardMemberDao();
		
		if(login_add.login_run(id, pw)) {
		    HttpSession session = request.getSession();
		    session.setAttribute("idkey", id);
		    no = login_add.login_no(id,pw);
		    String nono = String.valueOf(no);
		    session.setAttribute("idNo", nono);
		    System.out.println("세션화 된 값"+no);
		    response.sendRedirect("friend_list.jsp");
		} else {
		    System.out.println("id, pw 불일치");
		    response.sendRedirect("index.html");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		DtoMember sign_up_load = new DtoMember(id,pw);
		BoardMemberDao sign_up_add = new BoardMemberDao();
		
		System.out.println("------------------");
		System.out.println(sign_up_load.id);
		System.out.println(sign_up_load.pw);
		
		if(id == null && pw == null || id.equals("null") && pw.equals("null")) {
			System.out.println("꺼져");
			response.sendRedirect("index.html");
		}else {
			System.out.println("잘댐");
			sign_up_add.signup(sign_up_load);
			response.sendRedirect("index.html");
			out.println("바보");
		}
		
	}
}
