<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	function valChk() {
		if(frm.userId.value == "") {
		    alert("아이디를 입력해 주세요.");
		    frm.userId.focus();
		    return false;
		  }
		else if(frm.userPw.value == "") {
		    alert("비밀번호를 입력해 주세요.");
		    frm.userPw.focus();
		    return false;
		  }
		else if(frm.userPwCon.value == "") {
		    alert("비밀번호 확인을 입력해 주세요.");
		    frm.userPwCon.focus();
		    return false;
		  }
		else if(frm.userName.value == "") {
		    alert("이름를 입력해 주세요.");
		    frm.userName.focus();
		    return false;
		  }
	}
</script>
</head>
<body>
	<!-- top -->
	<header>
		<h2>회원가입</h2>
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
			<div id="SignUpWrapper">
				<form:form action="signUpAct" method="post" name="frm" onsubmit="return valChk()" modelAttribute="signUpCommand">
					<table>
						<tr>
							<th>아이디</th>
							<td><form:input path="userId" placeholder="아이디"/></td>
							
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="userPw" name="userPw" placeholder="비밀번호" />
								${notEqual }
							</td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" id="userPwCon" name="userPwCon" placeholder="비밀번호 확인" /></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><form:input path="name" placeholder="이름" /></td>
						</tr>
						<tr>
							<th colspan="2">
								<input type="button" onclick="javascript:history.back();" value="뒤로가기" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" value="제출" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="다시작성" />&nbsp;&nbsp;&nbsp;&nbsp;
							</th>
						</tr>
					</table>
				</form:form>
			</div>
	</section>
	<!-- 	내용 끝 -->
</body>
</html>
