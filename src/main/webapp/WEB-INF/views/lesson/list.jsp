<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 레슨목록</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/lesson/list.css">
    <link rel="stylesheet" href="/resources/css/common/header.css">
    <link rel="stylesheet" href="/resources/css/common/footer.css">
</head>
<body> 
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="list-main">
        <div id="list-title">
            <h2>레슨 목록</h2>
        </div>
        <c:if test="${sessionScope.loginUser.memberId eq null}">
            <div class="create-wrapper">
                <h4> < 로그인 후 RUBATO의 선생님이 되어보세요! > </h4>
            </div>
        </c:if>
        <c:if test="${sessionScope.loginUser.memberId ne null}">
            <div class="create-wrapper">
                <button class="list-btn" onclick="location.href='/lesson/create'">레슨 등록</button>
                <button class="list-btn" onclick="location.href='/lesson/mylesson'">나의 레슨</button>
                <button class="list-btn" onclick="location.href='/apply/myapply'">나의 신청</button>
            </div>
        </c:if>
        <div id="list-content">
            <c:forEach items="${lList}" var="lesson" varStatus="i">   
                <table id="list-detail">
                    <tr>
                        <td colspan="4"><a href="/lesson/detail?lessonNo=${lesson.lessonNo}" id="detailLink"> ${lesson.lessonTitle} </a></td>
                    </tr>
                    <tr>
                        <td  colspan="4">${lesson.lessonPre}</td>
                    </tr>
                    
                    <tr id="for-width">
                        <td style="width: 20%;">${lesson.lessonArea}</td>
                        <td style="width: 25%;">${lesson.lessonPrice} 만원 / 1회</td>
                        <td style="width: 40%;">${lesson.lessonPlan}</td>
                        <td style="width: 15%;">${lesson.memberNickname}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>

    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>