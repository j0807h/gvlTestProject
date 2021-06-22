<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
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
					<li>${name }님반갑습니다.</li>
				</c:if>
			</ul>
		</div>
	</nav>
	<!-- 	메뉴선택바 끝 -->
	<!-- 	내용 -->
	<section>
		<form action="writeBoard" method="get" name="frm">
			<c:if test="${count > 0 }">
					자료실 게시판  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 글 개수 : ${count } <hr />
					
					번호 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					제목   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					작성자   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					등록일   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					조회수   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<hr />
<%-- 				<c:forEach items="${lists }" var="dto" varStatus="status"> --%>
<%-- 					${status.count } &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; --%>
<%-- 					<a href="libDetail?boardNum=${dto.boardNum }">${dto.boardSubject }</a> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; --%>
<%-- 					${dto.boardWriter } &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- 					${dto.boardRegist } &nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- 					${dto.boardCount } &nbsp;&nbsp;&nbsp;&nbsp; --%>
<!-- 					<hr /> -->
<%-- 				</c:forEach> --%>
				<%@ include file="../include/includePage.jsp"%><br />
			</c:if>
			<hr />
			<c:if test="${count <= 0 }">
				게시글 없음<br />
			</c:if>
			<a href="writeBoard">게시글 등록</a>
			<%@ include file="../include/includePage.jsp"%><br />
			<c:if test="${!empty authInfo }">
				<input type="submit" value="게시글 등록" />
			</c:if>
		</form>
	</section>
	<!-- 	내용 끝 -->



</body>
</html>