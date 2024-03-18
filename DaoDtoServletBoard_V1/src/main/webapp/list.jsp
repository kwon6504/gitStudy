<%@page import="com.lowlist.Dto.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lowlist.BoardDao.BoardListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 임시</title>
</head>
<body>
<%
String id = (String)session.getAttribute("idkey");
if(id != null){

	BoardListDao dao_list = new BoardListDao();
	
	String pagenum = request.getParameter("page");
	String searchword = request.getParameter("word");
	System.out.println(pagenum+" 시작 페이지 넘버 파라미터 불러옴");
	int totalnum = 0;
	
	//어쩔수없음 ㅡㅡ
	if(pagenum == null ){
		pagenum = "1";
	}
	System.out.println(pagenum+" 현재 페이지 넘버 파라미터 불러옴");
	ArrayList<Dto> posts = dao_list.getArraySearch(pagenum,searchword,totalnum);
	int totalpage = dao_list.returnPageCal(pagenum,searchword,totalnum);
	for(int i = 0 ; i <posts.size() ; i++ ){
%>
글번호, 제목, 작성자<hr>
<%=posts.get(i).no%>
<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>
<%
}
%>
<%

int nowPageNum = Integer.parseInt(pagenum);
System.out.println(nowPageNum+" 현재 페이지 넘버 파라미터 불러옴");
Dto x = dao_list.blockVariable(nowPageNum,totalpage);

if(x.hasPrev){
	if(searchword==null){	// <1>일반 리스트
%>
		<a href="list.jsp?page=<%=x.prevPage%>">이전블럭가기</a>
<%				
	} else {				// <2>검색어로 검색한 리스트
%>				
		<a href="list.jsp?word=<%=searchword%>&page=<%=x.prevPage%>">이전블럭가기</a>
<%				
	}		
}

//페이지 번호 토탈번호로 for문 돌러서 하이퍼링크 추가함 링크 주소는 list.jsp?page=로 가게끔 바꿈
for(int i = x.blockStartNo; i<=x.blockEndNo;i++){
		if(searchword == null){
%>	
			<a href="list.jsp?page=<%=i%>">[<%=i%>]</a>
		<% 
		}else{
		String urlEncodedSearchWord = java.net.URLEncoder.encode(searchword);				
			%>
			<a href="list.jsp?word=<%=urlEncodedSearchWord%>&page=<%=i%>">[<%=i%>]</a>
			<% 
		}
	}
if(x.hasNext){
	if(searchword == null){
		%>
		<a href="list.jsp?page=<%=x.nextPage%>">🐿️다음블럭가기🐿️</a>
		<% 
	}else{
		%>
		<a href="list.jsp?word=<%=searchword%>&page=<%=x.nextPage%>">🐿️다음블럭가기🐿️</a>
		<%
	}
}
			%>
<br>
	<form action="list.jsp">
	<input name="word">
	<input type="submit" value="검색">
</form>
전체 페이지 수: <%=totalpage %><br>
현재 페이지 번호: <%=pagenum %><br>	
<br>
<a href="write.jsp">쓰기 </a>
<a href="list.jsp"> 돌아가기 </a>
<%
}else{
	response.sendRedirect("index.html");
}
%>
</body>
</html>