package com.peisia.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Testservlet2
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
		if(id.equals("cat") && pw.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("idkey", id);
			//session.setMaxInactiveInterval(30);
		}else {
			System.out.println("id,pw비일치");
		}
		PrintWriter out = response.getWriter();
		out.println("<a href = 'index2.jsp'>인덱스</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
	}
	

}
