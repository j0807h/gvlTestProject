<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file	="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<!-- top -->
	<header>
		<h2>로그인</h2>
	</header>
	<!-- top 끝 -->
<!-- 	메뉴선택바 -->
	<nav>
		<div>
			<ul>
				<li><a href="/">홈으로</a></li>
				<li><a href="login">로그인</a></li>
			</ul>
		</div>
	</nav>
<!-- 	메뉴선택바 끝 -->
<!-- 	내용 -->
	<section>
				<div id="LoginWrapper">
					<div class="LoginDataWrap">
						<!-- 화면 바뀌게 -->
						<form:form action="loginAct" method="post" name="frm"
 							modelAttribute="loginCommand">
							<div class="idForm">
								<form:input path="userId" id="userId" placeholder="ID" />
							</div>
							<div class="passForm">
								<input type="password" name="userPw" id="userPw"
									placeholder="PW" />
							</div>

							<!-- 에러 -->
							<div>
								<form:errors path="userId" />
								&nbsp;
								<form:errors path="userPw" />
								&nbsp; <span>${valid_userId }</span>&nbsp; <span>${valid_userPw }</span>
							</div>
							<input type="submit" value="LOG IN" class="loginButton" />
						</form:form>
					</div>
					<!-- 하단 나비 -->
					<div id="bottomWrapper">
						<ul>
							<li><a href="javascript:history.back();">back</a></li>
							<li><a href="/signUp">Sign Up</a></li>
						</ul>
					</div>
				</div>
	</section>
<!-- 	내용 끝 -->
</body>
</html>