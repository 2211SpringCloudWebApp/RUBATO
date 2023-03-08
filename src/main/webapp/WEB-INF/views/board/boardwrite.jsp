<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>자유게시판 글쓰기</title>
	    <!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<!-- common footer css & js -->
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- boardwrite css & js -->
	    <link rel="stylesheet" type="text/css" href="../board/boardwrite.css">
	</head>
	<body>
	<!-- common header jsp include -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="boardWrite">
        <h1 style="color: #2FBDB1;">자유게시판</h1>
        <div class="listLine"></div>
        <div id="writeSubject1">
            <select id='selwriteOption'>
                <option value='G'>고민</option>
                <option value='L'>레슨후기</option>
                <option value='I'>일상공유</option>
                <option value='K'>기타</option>
            </select>
        </div>
        <div id="writeSubject2"><input type="text" value="제목"></div>
        <div class="listLine"></div>
        <input type="textarea">
        <div class="listLine"></div>
        <div id="submitBtn">
            <input type="submit" value="등록하기">
        </div>
    </div>
	</body>
		<!-- common footer jsp include -->
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</html>