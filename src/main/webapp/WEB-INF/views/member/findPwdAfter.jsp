<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/resources/css/member/findPwdAfter.css">
<link rel="stylesheet" type="text/css" href="/resources/css/common/header.css">
<link rel="stylesheet" type="text/css" href="/resources/css/common/footer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>RUBATO - 아이디 찾기</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="main">
		<h1>비밀번호 찾기</h1>
			<c:if test="${member ne null }">
				<h4>회원님의 비밀번호는'${member.memberPwd}'입니다.</h4>
			</c:if>
			<c:if test="${member eq null }">
				<h4>등록된 정보가 없습니다.</h4>
			</c:if>
			<button type="button" id="return" onclick="location.href='/member/login'">로그인 화면으로 돌아가기</button>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>

</html>