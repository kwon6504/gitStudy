<%@page import="com.peisia.jsp.Board"%>
<%@page import="com.peisia.jsp.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.jsp.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글번호 | 제목 | 작성자
	<hr>
	<%
	String pageNum = request.getParameter("page");

	if (pageNum == null) {
		pageNum = "1";
	}
	Dao dao = new Dao();
	int totalPage = 0;
	ArrayList<Dto> posts = null;
	String searchWord = request.getParameter("word");
	if (searchWord == null || searchWord.equals("null")) {
		posts = dao.list(pageNum);
		totalPage = dao.getTotalPageCount();
	} else {
		posts = dao.listSearch(searchWord, pageNum);
		totalPage = dao.getSearchTotalPageCount(searchWord);
	}
	for (int i = 0; i < posts.size(); i++) {
	%>
	<%=posts.get(i).no%>
	<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
	<%=posts.get(i).id%>
	<hr>
	<%
	}
	int nPageNum = Integer.parseInt(pageNum);
	int totalBlock = (int) Math.ceil((double) totalPage / Board.Page_Link_Amount);
	int currentBlockNo = (int) Math.ceil((double) nPageNum / Board.Page_Link_Amount);
	int blockStartNo = (currentBlockNo - 1) * Board.Page_Link_Amount + 1;
	int blockEndNo = currentBlockNo * Board.Page_Link_Amount;
	if (blockEndNo > totalPage) {
	blockEndNo = totalPage;
	}

	int prevPage = 0;
	int nextPage = 0;

	boolean hasPrev = true;
	if (currentBlockNo == 1) {
	hasPrev = false;
	} else {
	hasPrev = true;
	prevPage = (currentBlockNo - 1) * Board.Page_Link_Amount;
	}

	boolean hasNext = true;
	if (currentBlockNo < totalBlock) {
	hasNext = true;
	nextPage = currentBlockNo * Board.Page_Link_Amount + 1;
	} else {
	hasNext = false;
	}

	if (hasPrev) {
	if (searchWord == null) {
	%>
	<a href="list.jsp?page=<%=prevPage%>">[이전]</a>
	<%
	} else {
	%>
	<a href="list.jsp?page=<%=prevPage%>&word=<%=searchWord%>">[이전]</a>
	<%
	}
	}

	for (int i = blockStartNo; i <= blockEndNo; i++) {
	if (nPageNum == i) {
	%>
	[<%=i%>]
	<%
	} else {
	if (searchWord == null) {
	%>
	[
	<a href="list.jsp?page=<%=i%>"><%=i%></a>]
	<%
	} else {
	String urlEncodedSearchWord = java.net.URLEncoder.encode(searchWord);
	%>
	[
	<a href="list.jsp?page=<%=i%>&word=<%=urlEncodedSearchWord%>"><%=i%></a>]
	<%
	}
	}
	}
	if (hasNext) {
	if (searchWord == null) {
	%>
	<a href="list.jsp?page=<%=nextPage%>">[다음]</a>
	<%
	} else {
	%>
	<a href="list.jsp?page=<%=nextPage%>&word=<%=searchWord%>">[다음]</a>
	<%
	}
	}
	%>
	<form action="list.jsp">
		<input name="word"> <input type="submit" value="검색">
	</form>
	<a href="write.jsp">글쓰기</a>
</body>
</html>