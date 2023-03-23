<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>RUBATO 자유게시판</title>
				<!-- common header css & js -->
				<link rel="stylesheet" href="/resources/css/common/header.css">
				<!-- common footer css & js -->
				<link rel="stylesheet" href="/resources/css/common/footer.css">
				<!-- boarddetail css & js -->
				<link rel="stylesheet" type="text/css" href="/resources/css/board/boarddetail.css">
				<link rel="preconnect" href="https://fonts.googleapis.com">
				<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
				<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap" rel="stylesheet">
			</head>

			<body>
				<!-- common header jsp include -->
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
				<div id="contentContainer">
					<form action="">
						<div id="contentDetail">
							<h1>자유게시판</h1>
							<div class="detailLine"></div>
							<div id="contentTop">
								<div id="contentCategory">${board.boardCategory}</div>
								<div id="contentSubject">${board.boardTitle }</div>
								<div id="contentWriter">${board.memberNickname }</div>
								<div id="contentDate">${board.boardDate }</div>
								<div id="contentCount">조회수 : ${board.viewCount }</div>
								<div id="contentComment">댓글 : ${commentCount }</div>
							</div>
							<div class="detailLine"></div>
							<div id="contentText">${board.boardContent }</div>
							<div class="detailLine"></div>
							<div id="detailBtn">
								<!-- 하얀 수정 - 관리자로 들어갔을때는 리스트 버튼만 뜨게 함 -->
									<c:if test="${loginUser.memberId != 'mngmt2023' }">
										<input type="button" value="목록" id="boardList" onclick="location.href='/board/list'">
										<input type="button" value="수정" id="boardModify" onclick="location.href='/board/modify?boardNo=${board.boardNo}'">
										<input type="button" value="삭제" id="boardDelete" onclick="removeCheck(${board.boardNo });">
										<input type="button" value="신고" id="boardReport" onclick="location.href='/report/writeView?boardCategory=${board.boardCategory}&boardNo=${board.boardNo} '">
									</c:if>
									<c:if test="${loginUser.memberId == 'mngmt2023' }">
										<input type="button" value="자유게시판리스트" id="reportList" onclick="location.href='/manager/board'">
										<input type="button" value="신고리스트" id="reportList" onclick="location.href='/manager/reportBoard'">
									</c:if>
								</div>
						</div>
					</form>
				</div>
				<div id="commentContainer">
					<!-- 댓글 작성 -->
					<div id="commentSub">
						<form action="/board/comment" method="post" id="commentForm">
							<input type="hidden" name="boardNo" value="${board.boardNo }">
							<input type="text" placeholder="타인을 배려하는 마음을 담아 댓글을 작성해주세요." name="commentContent">
							<input type="submit" value="댓글 등록" onClick="submitComment()">
						</form>
					</div>
					<!-- 작성된 댓글 목록 -->
					
					<div id="commentDiv">
						<p id="commentView"><b>${commentCount }</b>개의 댓글</p>
						<div class="detailLine"></div>
						<c:forEach var="bc" items="${comments}">
							<div class="commentWrapper">
								<span id="commentWriter">작성자 ${bc.memberNickname}</span>
								<span id="commentDate">작성일
									<fmt:formatDate value="${bc.commentDate}" pattern="yy-MM-dd" />
								</span><br>
								<span id="commentWD">${bc.commentContent}</span>
								<c:if test="${bc.memberId eq sessionScope.loginUser.memberId}">
									<span class="deleteCommentButton" onclick="deleteCheck(${bc.boardNo}, ${bc.commentNo});">삭제</span>
<!-- 									<input type="button" value="삭제" id="commentDeleteBtn"> -->
								</c:if>
								<div class="detailLine2"></div>
							</div>
						</c:forEach>
					</div>


				</div>
				<script>
					// 게시판 상단 작성일 00-00-00 형태로 만들어주기
					var boardDate = document.querySelectorAll("#contentDate");
					for (var i = 0; i < boardDate.length; i++) {
						boardDate[i].innerHTML = boardDate[i].innerHTML.substr(0, 10);
					}

					// 로그인 여부에 따라 삭제 버튼 보이기
					var deleteButton = document.querySelector("#boardDelete");
					if (isLoggedIn() && "${board.memberId}" === "${sessionScope.loginUser.memberId}") {
						deleteButton.style.display = "inline-block"; // 버튼 보임
					} else {
						deleteButton.style.display = "none"; // 버튼 안 보임
					}
					// 삭제버튼 클릭한 경우 한번 더 묻는 팝업창 생성, 확인 시 삭제완료
					function removeCheck(boardNo) {
						if (confirm("정말 삭제하시겠습니까?")) {
							location.href = "/board/remove?boardNo=" + boardNo;
						}
					}

					// 댓글삭제버튼 클릭한 경우 한번 더 묻는 팝업창 생성, 확인 시 삭제완료
					function deleteCheck(boardNo, commentNo) {
						if (confirm("정말 삭제하시겠습니까?")) {
							location.href = "/boardComment/remove/" + boardNo + "/" + commentNo;
						} else {
// 							history.back();
						}
					}

					// 본인이 작성한 댓글에서만 삭제버튼이 보이게 함
					var deleteCButtons = document.querySelectorAll(".deleteCommentButton input[type='submit']");
					for (var i = 0; i < deleteCButtons.length; i++) {
						var deleteCButton = deleteCButtons[i];
						var commentNo = deleteCButton.previousElementSibling.value;
						if (isLoggedIn() && "${board.memberId}" === "${sessionScope.loginUser.memberId}") {
							deleteCButton.style.display = "inline-block"; // 버튼 보임
						} else {
							deleteCButton.style.display = "none"; // 버튼 안 보임
						}
					}

					// 본인이 작성한 게시물에서만 수정버튼이 보이게 함
					var modifyButton = document.querySelector("#boardModify");
					if (isLoggedIn() && "${board.memberId}" === "${sessionScope.loginUser.memberId}") {
						modifyButton.style.display = "inline-block"; // 버튼 보임
					} else {
						modifyButton.style.display = "none"; // 버튼 안 보임
					}

					// 하얀 추가
					// 본인이 작성한 게시글에서는 신고버튼 안보이게 함
					var boardReport = document.querySelector("#boardReport");
					if (isLoggedIn() && "${board.memberId}" === "${sessionScope.loginUser.memberId}") {
						boardReport.style.display = "none";   // 내가 작성한 게시글에서는 신고버튼 안보임
					} else {
						boardReport.style.display = "inline-block";   // 내가 작성한 게시글이 아니면 신고버튼 보임
					}

					// isLoggedIn()에 맞는 함수 작성해주기
					function isLoggedIn() {
						var checkObj = "${loginUser.memberId}";
						if (checkObj != "") {
							return true;
						} else {
							return false;
						}
					}

					function submitComment() {
						// 로그인 여부 확인
						if ("${sessionScope.loginUser}" == "") {
							// 로그인 팝업창 띄우기
							alert("로그인 후 작성 가능합니다.");
							window.location.href = "/loginPage";
						} else {
							// 댓글 작성 폼 제출
							document.getElementById("commentForm").action = "/board/comment";
							document.getElementById("commentForm").submit();
							// 댓글 작성 완료 메시지 띄우기
							alert("댓글이 작성되었습니다.");
							// 페이지 새로고침
							location.reload();
						}
					}
				</script>
			</body>
			<!-- common footer jsp include -->
			<jsp:include page="/WEB-INF/views/common/footer.jsp" />

			</html>