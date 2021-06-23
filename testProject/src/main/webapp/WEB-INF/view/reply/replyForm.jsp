<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 폼</title>
</head>
<body>
<%-- 	<a href="boardDelete?boardNum=<c:out value="${boardDetail.boardNum}"/>">삭제</a> --%>
<%-- 	<a href="boardForm?boardNum=<c:out value="${boardDetail.boardNum}"/>">수정</a> --%>
	<p>&nbsp;</p>
	<p><h3>댓글</h3></p>
	<div style="border: 1px solid; width: 600px; padding: 5px">
<!-- 		<form name="frm" action="boardReplySave" method="post"> -->
		<form name="frm" action="registReply" method="post">
			<input type="hidden" name="boardNum"
				value="<c:out value="${boardDetail.boardNum}"/>"> 작성자: <input
				type="text" name="replyWriter" size="20" maxlength="20"> <br />
			<textarea name="replyMemo" rows="3" cols="60" maxlength="500"
				placeholder="댓글을 달아주세요."></textarea>
<!-- 			<a href="registReply" onclick="fn_formSubmit()">저장</a> -->
			<input type=submit value="저장" />
		</form>
	</div>

</body>
</html>