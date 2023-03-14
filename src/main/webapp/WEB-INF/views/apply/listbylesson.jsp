<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>RUBATO - 신청목록</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/resources/css/apply/listbylesson.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/footer.css">
    </head>
    <body> 
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <div id="list-main">
            <div id="list-title">
                <h2><a href="/lesson/detail?lessonNo=${param.lessonNo}" id="detailLink">${aList[0].lessonTitle}</a></h2>
            </div>
            <div id="list-content">
                <c:forEach items="${aList}" var="apply" varStatus="i">
                    
                    <table id="list-detail">    
                        <tr>
                            <td style="width: 30%;"><b>신청자 ID | </b>${apply.memberId}</td>
                            <td style="width: 30%;"><b>요청 금액 | </b>${apply.applyPrice}</td>
                            <td style="width: 40%;"><b>요청 일정 | </b>${apply.applyPlan}</td>   
                        </tr>
                        <tr>
                            <td colspan="3"><b>상세 요청 | </b>${apply.applyContent}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><b>신청일 | </b>${apply.applyDate}</td>
                            <td><button id="confirm-btn"><a href="mailto:${apply.memberEmail}?subject=Rubato,레슨 신청의 건">수락하기</a></td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </body>
</html>