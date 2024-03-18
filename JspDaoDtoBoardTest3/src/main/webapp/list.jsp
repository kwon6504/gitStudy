<%@page import="com.peisia.db.Board"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글번호 || 제목 || 작성자
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
	if (searchWord == null || searchWord.equals("null")) { //|| = or
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
	int nPageNum = Integer.parseInt(pageNum); //계산을 위한 int로 변환
	//totalBlock = 블럭 총 갯수.
	int totalBlock = (int)Math.ceil((double)totalPage/Board.PAGE_LINK_AMOUNT);
	//총 블록 갯수 = 총 페이지 수 / 블럭 당 페이지 수(결과의 소수점자리는 올림)
	//(int)Math.ceil= 숫자를 정수가 나오게 올림한다.
	//double 소수점이 나오게 바꾼다.
	//최종결과는 totalBlock 전체 블록 수를 나타낸다.
	//currentBlockNo = 현재 블럭 번호.
	int currentBlockNo = (int)Math.ceil((double)nPageNum/Board.PAGE_LINK_AMOUNT);
	//현재 블록 번호 = 현재 페이지 번호 / 블럭 당 페이지 수(결과의 소수점자리는 올림)
	//blockStartNo = 블럭 시작페이지 번호
	int blockStartNo = (currentBlockNo-1) * Board.PAGE_LINK_AMOUNT + 1;
	//시작페이지 번호 = (현재블록번호-1)*블럭당 페이지 수 + 1;
	//blockEndNo = 블록 끝 페이지 번호
	int blockEndNo = currentBlockNo * Board.PAGE_LINK_AMOUNT;
	//블록 끝 페이지 번호 = 현재블록번호 * 블럭당 페이지 수 + 1;
	if(blockEndNo > totalPage) {
		blockEndNo = totalPage;
	}
	
	int prevPage = 0; //이전 블록가기 위한 초기화값
	int nextPage = 0; //다음 블록가기 위한 초기화값
	
	boolean hasPrev = true; //이전 블럭 가기 가능 여부 저장값 초기화
	if(currentBlockNo == 1){ //현재 블럭이 1이라면
		hasPrev = false; //이전 블러가기는 불가능
	} else { // 1이 아니라면
		hasPrev = true; // 이전 블록 가긱 가능
		prevPage = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT;
		//이전 블록 이동시 몇 페이지로 이동할지 정하는 prevPage 객체
		//이전 블록의 마지막 페이지로 이동하는 공식
		//(현재 블록 번호-1)*블럭당 페이지 수.
	}
	
	boolean hasNext = true;
	if(currentBlockNo < totalBlock){ //현재 블록 번호가 총 블럭 수보다 작으면 다음 블록 넘어가기 가능
		hasNext = true;
	    //다음 블록의 첫 페이지로 이동하게 하기
	    //현재 블럭 번호 * 블럭 당 페이지수 +1
	    nextPage = currentBlockNo * Board.PAGE_LINK_AMOUNT + 1;
	} else { //현재 블록이 총 블록보다 같거나 많다면
		hasNext = false; //다음 블록 넘어가기 불가능
	}
	
	if(hasPrev) {
		if(searchWord==null){ //검색어 없이 이전블록으로 가기
%>
<a href="list.jsp?page=<%=prevPage %>">이전블록가기</a>
<%
		} else { //검색어 있을 경우 이전블로가기
%>
			<a href="list.jsp?page=<%=prevPage %>&word=<%=searchWord %>">이전블록가기</a>
			<!--리스트 페이지에서 이전페이지 번호가 검색한 리스트에서 이전페이지로 가도록 -->
<%
		}
	}

	for(int i=blockStartNo; i <= blockEndNo; i++){
		if(nPageNum == i){ //현재 페이지랑 번호가 같으면 링크 안걸어줌
%>
        [<%=i %>]
<%
		} else { //다른페이지와 블록이동에 링크 처리
			if(searchWord==null){ // 검색어 없을때.
				%>
				[<a href="list.jsp?page=<%=i %>"><%=i %></a>]
				<%
			} else {
				//검색을 한국어 할때는 url인코딩을 해줘야 한다.
				//deprecated 다음 버전에서 바뀔수도 있다(옛날거라서)는 경고의 의미
				String urlEncodedSearchWord = java.net.URLEncoder.encode(searchWord);
				%>
				[<a href="list.jsp?page=<%=i %>&word=<%=urlEncodedSearchWord %>"><%=i %></a>>]
				<%
			}
		}
	}
	
	
	for (int i = 1; i <= totalPage; i++) {
	
	%>
	<a href="list.jsp?page=<%=i%>&word=<%=searchWord%>"><%=i%></a>
	<%
	}
	%>
	<form action="list.jsp">
		<input name="word"> 
		<input type="submit" value="검색">
	</form>
	<hr>
	<fieldset id="link">
	<legend>링크</legend>
	<a href="write.jsp">글쓰기</a>
	</fieldset>
	<hr>
	<fieldset id="log">
	<legend>로그</legend>
	전체 페이지 수: <%=totalPage %><br>
	전체 페이지 번호: <%=pageNum %><br>
	</fieldset>
</body>
</html>