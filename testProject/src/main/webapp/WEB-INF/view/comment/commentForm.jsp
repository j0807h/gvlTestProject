<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
<!-- 		<label for="content">comment</label> -->
		<form name="commentForm" id="commentForm" method="get">
			<div>
				<div>
					<span><Strong>Comments</Strong></span><span id="coCnt"></span>
				</div>
				<div>
					<table class="table">
						<tr>
							<td><textarea style="width: 1100px" rows="3" cols="30"
									id="coContent" name="coContent" placeholder="댓글을 입력하세요"></textarea>
								<div>
									<a href='#' onClick="commentInsert('${list.get(0).boardNum }')">등록</a>
								</div></td>
						</tr>
					</table>
				</div>
			</div>
			<input type="hidden" name="boardNum" id="boardNum"
				value="${list.get(0).boardNum }" />
		</form>
		<hr />
	</div>
	<div class="container">
		<form id="commentListForm" name="commentListForm" method="post">
			<div class="commentList"></div>
		</form>
	</div>
	
	<%@include file ="commentAjax.jsp" %>
	
</body>
</html>
