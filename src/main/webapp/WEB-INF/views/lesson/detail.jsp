<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 레슨상세</title>
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
        <h2>${lesson.lessonTitle}</h2>
        <div id="teacher-id">
            <small>${lesson.memberId}</small>
        </div>
        <div id="pre-intro">${lesson.lessonPre}</div>
        <div id="lesson-opt">
            <div>${lesson.lessonArea}</div>
            <div>${lesson.lessonPrice} 만원 / 1회</div>
            <div>${lesson.lessonPlan}</div>
        </div>
        <div id="detail-intro">
            <fieldset>
                <legend>상세설명</legend>
                ${lesson.lessonContent}
            </fieldset>
        </div>       
        <div id="detail-btns">
            <c:if test="${sessionScope.loginUser.memberId eq lesson.memberId}">
                <button onclick="location.href='/lesson/modify?lessonNo=${lesson.lessonNo}'">수정하기</button>
                <button onclick="location.href='/apply/listbylesson?lessonNo=${lesson.lessonNo}'">받은 신청</button>
            </c:if>
            <c:if test="${sessionScope.loginUser.memberId ne lesson.memberId}">
                <button onclick="location.href='/apply/create?lessonNo=${lesson.lessonNo}'">신청하기</button>
                <button onclick="location.href='/lesson/list'">목록으로</button>
            </c:if>   
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>