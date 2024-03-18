<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String title = request.getParameter("title");
String id = request.getParameter("id");
String content = request.getParameter("content");
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
	Statement st = con.createStatement();
	String sql = "insert into cat_board(title, content, id) values('" + title + "', '" + content + "', '" + id + "')";
	System.out.println("==== 전송할 sql" + sql);
	int resultCount = st.executeUpdate(sql);
	if (resultCount == 1) {
		System.out.println("글등록이 완료되었습니다.");
	} else {
		System.out.println("글등록에 실패하였습니다.");
	}
} catch (Exception e) {
	e.printStackTrace();
}

response.sendRedirect("list.jsp");
%>