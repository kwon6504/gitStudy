<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String backupNum = request.getParameter("num");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = "update cat_board set delNum=0 where num="+backupNum;

		System.out.println("==== 전송하려는 sql:" + sql);		
		int resultCount = st.executeUpdate(sql);	// 글쓰기 sql 전송
		if(resultCount == 1){
			System.out.println("==== 글복구 성공");
		} else {
			System.out.println("==== 글복구 실패");
		}
	} catch (Exception e) {		
		e.printStackTrace();
	}
	
	response.sendRedirect("list.jsp");	// 글리스트 화면으로 강제 이동
%>