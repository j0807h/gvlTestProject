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
					<li><a href="logout" >로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
	<!-- 	메뉴선택바 끝 -->
	<!-- 	내용 -->
	<section>
		<form action="writeBoard" method="get" name="frm" >
			<c:if test="${count > 0 }">
				<table border="1" width="800">
					<colgroup>
						<col width="50" />
						<col width="380" />
						<col width="100" />
						<col width="100" />
						<col width="70" />
					</colgroup>
<!-- 					<div> -->
<%-- 						<p>글 개수 : ${count }</p> --%>
<!-- 					</div> -->
					<tr>
						<th colspan="5" align="right">글 개수 : ${count } </th>
					</tr>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
					<c:forEach items="${lists }" var="dto" varStatus="status">
						<tr>
							<td>${(page - 1) * limit + status.count }</td>
							<td><a href="boardDetail/${dto.boardNum }">${dto.boardSubject }</a></td>
							<td>${dto.boardWriter }</td>
							<td>${fn:substring(dto.boardRegist,0,10) }</td>
							<td>${dto.boardCount }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<div>
				<%@ include file="../include/includePage.jsp"%><br />
			</div>	
			<c:if test="${count <= 0 }">
				게시글 없음<br />
			</c:if>
			<c:if test="${!empty authInfo }">
				<input type="submit" value="게시글 등록" />
			</c:if>
		</form>
	</section>
	<!-- 	내용 끝 -->


</body>
</html>