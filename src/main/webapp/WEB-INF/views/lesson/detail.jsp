<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>레슨 등록</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/lesson/detail.css">
    <link rel="stylesheet" href="/resources/css/common/header.css">
    <link rel="stylesheet" href="/resources/css/common/footer.css">
</head>
<body> 
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="detail-main">
        <h2>레슨글 제목</h2>
        <div id="teacher-id">
            <small>[작성자 아이디]</small>
        </div>
        <div id="pre-intro">한줄소개</div>
        <div id="lesson-opt">
            <div>지역</div>
            <div>금액</div>
            <div>시간</div>
        </div>
        <div id="detail-intro">
            <fieldset>
                <legend>상세소개</legend>
            </fieldset>
        </div>
        <div id="detail-btns">
            <button onclick="">신청하기</button>
            <button onclick="">목록으로</button>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>