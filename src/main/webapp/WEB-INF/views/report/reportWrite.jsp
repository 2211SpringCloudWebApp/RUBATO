<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>신고하기</title>
		<!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<!-- common footer css & js -->
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- boardwrite css & js -->
		<link rel="stylesheet" type="text/css" href="/resources/css/manager/reportWrite.css">
	</head>

	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<div id="boardWrite">
			<h1 style="color: #2FBDB1;">신고하기</h1>
			<form action="/report/write" method="post">
				<div class="listLine"></div>
				<div id="writeSubject1">
					<select id="selwriteOption" name="reportCategory">
						<option value='욕설'>욕설</option>
						<option value='광고'>광고</option>
						<option value='기타'>기타</option>
					</select>
				</div>
				<div class="listLine"></div>
				<input type="text" id="boardContent1000" name="reportContent" value="${reportContent }">
				<div class="listLine"></div>
				<div id="submitBtn">
					<!-- 관리자로 들어가면 등록하기 버튼이 아닌 리스트 버튼이 뜨게 함 -->
					<c:if test="${member.memberId != 'mngmt2023' }">
						<input type="submit" value="등록하기">
					</c:if>
					<c:if test="${member.memberId == 'mngmt2023' }">
						<input type="button" value="리스트" onclick="location.href='/manager/reportBoard'">
						<input type="button" value="신고게시물" onclick="location.href='/board/detail?boardNo=${boardNo}'">
					</c:if>
				</div>
				<input type="hidden" name="postCategory" value="${boardCategory }">
				<input type="hidden" name="postNo" value="${boardNo }">
				<input type="hidden" name="memberId" value="${member.memberId }">
			</form>
		</div>
	</body>
	<!-- common footer jsp include -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	</html>