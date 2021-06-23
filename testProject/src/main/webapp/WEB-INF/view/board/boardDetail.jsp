<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail</title>
</head>
<body>
		<!-- top -->
		<header>
			<h2>게시판</h2>
		</header>
		<!-- top 끝 -->
	<!-- 	메뉴선택바 -->
		<nav>
			<div>
				<ul>
					<li><a href="/">홈으로</a></li>
	<!-- 				로그인 안됐을 때 -->
					<c:if test="${empty authInfo }">
						<li><a href="login">로그인</a></li>
					</c:if>
	<!-- 				로그인 됐을 때 -->
					<c:if test="${!empty authInfo }">
						<li>${name }님 반갑습니다. </li>
						<li><a href="logout">로그아웃</a> </li>
					</c:if>
				</ul>
			</div>
		</nav>
	<!-- 	메뉴선택바 끝 -->
	<!-- 	내용 -->
		<section>
			<c:forEach items="${list }" var="board">
				<table>
					<tr>
						<th>게시글 번호</th>
						<td>${board.boardNum }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${board.boardSubject }</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td>${board.boardWriter }</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${fn:substring(board.boardRegist,0,10) }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${board.boardCount }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${board.boardContent }</td>
					</tr>
					<tr>
						<th>파일</th>
						<td>${board.boardFile }</td>
					</tr>
					<tr>
						<th>IP 주소</th>
						<td>${board.ipAddr }</td>
					</tr>
				</table>
			</c:forEach>
			<p>&nbsp;</p>
			<hr />
<%-- 				<%@ include file="../reply/replyList.jsp" %> --%>
<%-- 				<%@ include file="../reply/replyForm.jsp" %> --%>
				<%@ include file="../comment/commentForm.jsp" %>
			<hr />
			<a href="javascript:history.back();">back</a>
		</section>
	<!-- 	내용 끝-->
</body>
</html>