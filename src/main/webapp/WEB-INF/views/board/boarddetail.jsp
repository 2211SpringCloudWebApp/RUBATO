<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    <link rel="stylesheet" type="text/css" href="../board/boarddetail.css">
	</head>
	<body>
		<div id="contentContainer">
	        <div id="contentDetail">
	            <h1 style="color: #2FBDB1;">자유게시판</h1>
	            <div class="detailLine"></div>
	            <div id="contentTop">
	                <div id="contentCategory">분류</div>
	                <div id="contentSubject">제목</div>
	                <div id="contentWriter">작성자</div>
	                <div id="contentDate">작성일 : </div>
	                <div id="contentCount">조회수 : </div>
	                <div id="contentComment">댓글 : </div>
	            </div>
	            <div class="detailLine"></div>
	            <div id="contentText"></div>
	            <div class="detailLine"></div>
	            <div id="detailBtn">
	                <input type="button" value="글 수정" id="boardModify">
	                <input type="button" value="목록" id="boardList">
	                <input type="button" value="신고" id="boardReport">
	            </div>
	        </div>
	        <p>0개의 댓글</p>
	        <div class="detailLine"></div>
	        <div id="commentDiv">
	
	            <div id="commentWriter">작성자 </div>
	            <div id="commentDate">작성일자 </div>
	
	            <div id="commentWD">
	                <input type="text">
	            </div>
	
	        </div>
	        <div class="detailLine"></div>
	        <div id="commentSub">
	            <input type="textarea" placeholder="타인을 배려하는 마음을 담아 댓글을 작성해주세요.">
	            <input type="submit" value="댓글 등록">
	        </div>
	    </div>
	</body>
</html>