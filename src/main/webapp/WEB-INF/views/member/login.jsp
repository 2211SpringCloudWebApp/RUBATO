<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/resources/css/member/login.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/common/header.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/common/footer.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		<title>RUBATO - 로그인</title>
	</head>

	<body>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="main">
			<h1 class="logo-main">Rubato</h1>
			<div class="container">
				아이디 <input type="text" placeholder="ID" id="memberId" name="memberId" class="account"><br>
				비밀번호 <input type="password" placeholder="Password" id="memberPwd" name="memberPwd" class="account"><br>
				<button id="login1" class="account">login</button>
				<p id="alert" class="account"></p>
			</div>
			<div id=find>
				<a href="/member/findId" id="Id">아이디 찾기</a>
				<a href="/member/findPwd">비밀번호 찾기</a>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		<script>
			$(function () {
				$('#login1').mouseenter(function () {
					$(this).css('cursor', 'pointer');
				}).mouseout(function () {
					$(this).css('cursor', 'normal');
				}).click(function () {
					submitCheck();
				});
			});

			function submitCheck() {
				var memberId = $('#memberId').val();
				var memberPwd = $("#memberPwd").val();
				$.ajax({
					type: "POST",
					url: '/member/loginCheck',
					data: {
						memberId: memberId,
						memberPwd: memberPwd
					},
					success: function (data) {
						if(data ==="unactive"){
							alert("비활성화된 계정입니다. 관리자에게 문의하세요");
						}
						else if (data == "false"){
							alert('잘못된 아이디이거나, 비밀번호가 틀렸습니다.');
						}
						else{
							location.href = "/index.jsp"; // login페이지로 돌아가시면 됩니다.
						}
					}
				});
			}
		</script>
	</body>

	</html>