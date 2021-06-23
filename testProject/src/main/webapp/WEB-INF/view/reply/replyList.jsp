<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대댓글 리스트</title>
</head>
<body>
	<c:forEach var="replyList" items="${replyList }" varStatus="status">
		<div
			style="border: 1px solid gray; width: 600px; padding: 5px; margin-top: 5px;
          margin-left: <c:out value="${20*replyList.replyDepth}"/>px; display: inline-block">
			<c:out value="${replyList.replyWriter}" />
			<c:out value="${replyList.replyDate}" />
			<a href="#"
				onclick="fn_replyDelete('<c:out value="${replyList.replyNum}"/>')">삭제</a>
			<a href="#"
				onclick="fn_replyUpdate('<c:out value="${replyList.replyNum}"/>')">수정</a>
			<a href="#"
				onclick="fn_replyReply('<c:out value="${replyList.replyNum}"/>')">댓글</a>
			<br />
			<div id="reply<c:out value="${replyList.replyNum}"/>">
				<c:out value="${replyList.replyMemo}" />
			</div>
		</div>
		<br />
	</c:forEach>
</body>
</html>