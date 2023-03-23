<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>RUBATO 자유게시판</title>
		<!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<!-- common footer css & js -->
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- boardwrite css & js -->
		<link rel="stylesheet" type="text/css" href="/resources/css/board/boardwrite.css">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap" rel="stylesheet">
	</head>

	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp" />

		<div id="boardWrite">
			<h1 style="color: #2FBDB1;">자유게시판</h1>
			<form action="/board/write" method="post">
				<div class="listLine"></div>
				<div id="writeSubject1">
					<select id="selwriteOption" name="boardCategory">
						<option value='고민'>고민</option>
						<option value='레슨후기'>레슨후기</option>
						<option value='일상공유'>일상공유</option>
						<option value='기타'>기타</option>
					</select>
				</div>
				<div id="writeSubject2"><input type="text" name="boardTitle"></div>
				<div class="listLine"></div>
				<input type="hidden" name="memberId" value="${board.memberId }">
				<input type="text" id="boardContent1000" name="boardContent">
				<div class="listLine"></div>
				<div id="submitBtn">
					<input type="submit" value="등록하기">
				</div>
			</form>
		</div>
	</body>
	<!-- common footer jsp include -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	</html>