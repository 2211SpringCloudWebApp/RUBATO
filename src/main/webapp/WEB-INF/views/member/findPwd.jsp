<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/resources/css/member/findId.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/common/footer.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		<title>RUBATO - 비밀번호 찾기</title>
	</head>

	<body>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="main">
			<h1 class="logo-main">Rubato</h1>
			<form action="/member/findPwd" method="POST">
				<div class="container">
					아이디 <input type="text" placeholder="아이디를 입력하세요" id="memberId" name="memberId" class="account"><br>
					이메일 <input type="text" placeholder="이메일을 입력하세요" id="memberEmail" name="memberEmail"
						class="account"><br>
					<button id="submit">비밀번호 찾기</button>
				</div>
			</form>
		</div>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	</body>

	</html>