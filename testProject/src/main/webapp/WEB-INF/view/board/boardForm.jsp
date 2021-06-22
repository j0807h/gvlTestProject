<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardForm</title>
</head>
<body>
<form:form action="boardRegist" method="post" name="frm" modelAttribute="boardCommand" enctype="multipart/form-data">
	글쓴이 : <form:input path="boardWriter" />
			<form:errors path="boardWriter" /><br />
	제목 : <form:input path="boardSubject" />
			<form:errors path="boardSubject" /><br />
	내용 : <form:textarea path="boardContent" cols="50" rows="5"></form:textarea><br />
	파일 : <input type="file" name="boardFile" multiple="multiple" >
<%-- 			<form:errors path="boardPw" /><br /> --%>
	<input type="submit" value="저장" ><br />
	<input type="reset" value="다시 작성" ><br />
	<input type="button" value="리스트로 가기" onclick="javascript:location.href='/'" ><br />
</form:form>
</body>
</html>