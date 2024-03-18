package com.peisia.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Xxx")
public class Xxx extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		response.sendRedirect("http://daum.net");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");        // 안하면 한글 깨짐
		PrintWriter out = response.getWriter();
		out.println("서블릿이란?");

		System.out.println("아이디:" + id);
		System.out.println("암호:" + pw);
	}

}
