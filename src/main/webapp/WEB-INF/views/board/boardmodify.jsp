<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>게시판 본문/댓글 상세</title>
			<!-- common header css & js -->
			<link rel="stylesheet" href="/resources/css/common/header.css">
			<!-- common footer css & js -->
			<link rel="stylesheet" href="/resources/css/common/footer.css">
			<!-- boarddetail css & js -->
			<link rel="stylesheet" type="text/css" href="/resources/css/board/boarddetail.css">
		</head>

		<body>
			<!-- common header jsp include -->
			<jsp:include page="/WEB-INF/views/common/header.jsp" />
			<div id="contentContainer">
				<form action="/board/modify" method="get">
					<div id="contentDetail">
						<h1 style="color: #2FBDB1;">자유게시판</h1>
						<div class="detailLine"></div>
						<div id="contentTop">
							<div id="contentCategory">
								<select id="selwriteOption" name="boardCategory">
									<option value='G' <c:if test="${board.boardCategory eq 'G' }">selected</c:if>>고민
									</option>
									<option value='L' <c:if test="${board.boardCategory eq 'L' }">selected</c:if>>레슨후기
									</option>
									<option value='I' <c:if test="${board.boardCategory eq 'I' }">selected</c:if>>일상공유
									</option>
									<option value='K' <c:if test="${board.boardCategory eq 'K' }">selected</c:if>>기타
									</option>
								</select>
							</div>
							<div id="contentSubject">
								<input type="text" value="${board.boardTitle }">
							</div>
							<div id="contentWriter">${board.memberId }</div>
							<div id="contentDate">${board.boardDate }</div>
							<div id="contentCount">조회수 : ${board.viewCount }</div>
							<div id="contentComment">댓글 : ${boardComment.commentNo }</div>
						</div>
						<div class="detailLine"></div>
						<div id="contentText">
							<textarea rows="30" cols="100">${board.boardContent }</textarea>
						</div>
						<div class="detailLine"></div>
						<div id="detailBtn">
							<input type="button" value="목록" id="boardList" onclick="location.href='/board/list'"> 
							<input type="button" value="등록" id="boardModify"
								onclick="location.href='/board/list'">
							<input type="button" value="삭제" id="boardDelete" onclick="removeCheck(${board.boardNo });">
							<input type="button" value="신고" id="boardReport">
						</div>
					</div>
				</form>
				<!-- 작성된 댓글 목록 -->
				<p>0개의 댓글</p>
				<div class="detailLine"></div>
				<div id="commentDiv">

					<div id="commentWriter">작성자</div>
					<div id="commentDate">작성일</div>

					<div id="commentWD">
						<input type="text">
					</div>

				</div>
				<div class="detailLine"></div>
				<!-- 댓글 작성 -->
				<div id="commentSub">
					<form action="/board/comment" method="post">
						<input type="hidden" name="boardNo" value="${boardComment.boardNo }">
						<input type="text" placeholder="타인을 배려하는 마음을 담아 댓글을 작성해주세요." name="commentContent"> <input
							type="submit" value="댓글 등록">
					</form>
				</div>
			</div>

			<script>

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
				// 본인이 작성한 게시물에서만 수정버튼이 보이게 함
				var modifyButton = document.querySelector("#boardModify");
				if (isLoggedIn() && "${board.memberId}" === "${sessionScope.loginUser.memberId}") {
					modifyButton.style.display = "inline-block"; // 버튼 보임
				} else {
					modifyButton.style.display = "none"; // 버튼 안 보임
				}

				// isLoggedIn()에 맞는 함수 작성해주기
				function isLoggedIn() {
					var checkObj = "${loginUser.memberId }";
					if(checkObj != "") {
						return true;
					}else{
						return false;
					}
					// 쿠키를 사용하여 로그인 여부를 판단
// 					var cookieValue = document.cookie
// 						.split('; ')
// 						.find(row => row.startsWith('login='))
// 						?.split('=')[1];

// 					return cookieValue === 'true';
				}

			</script>

		</body>

		</html>