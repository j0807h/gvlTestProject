<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인</title>
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
		<form action="writeBoard" method="get" name="frm">
<!-- 			<table border="1"> -->
<!-- 				<colgroup> -->
<!-- 					<col width="78" /> -->
<!-- 					<col width="381" /> -->
<!-- 					<col width="70" /> -->
<!-- 					<col width="75" /> -->
<!-- 				</colgroup> -->
<!-- 				<tr> -->
<!-- 					<th colspan="3">게시글</th> -->
<!-- 					<th>글 개수 : </th> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>번호</th> -->
<!-- 					<th>제목</th> -->
<!-- 					<th>작성자</th> -->
<!-- 					<th>조회수</th> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 			<%@ include file="include/includePage.jsp" %><br /> --%>
			<c:if test="${!empty authInfo }">
			<input type="submit" value="게시글 등록" />
			</c:if>
		</form>
	</section>
<!-- 	내용 끝 -->
	
	
<!-- 	임시 -->
	<a href="boardList">게시글 목록</a>
	

</body>
</html>