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
                            <td style="width: 30%;"><b>신청자 ID | </b>${apply.memberNickname}</td>
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
            <table id="navi-box">
                <tr>
                    <td>
                        <c:if test="${pi.currentPage ne 1}">
                            <a href="/apply/listbylesson?lessonNo=${lessonNo}&page=1" id="navi-btn1"> ≪ </a>
                        </c:if>
                        <c:if test="${pi.currentPage ne 1}">
                            <a href="/apply/listbylesson?lessonNo=${lessonNo}&page=${pi.currentPage-1}" id="navi-btn2"> ＜ </a>
                        </c:if>
                        <c:forEach begin="${pi.startNavi}" end="${pi.endNavi}" var="p">
                            <c:url var="pageUrl" value="/apply/listbylesson">
                                <c:param name="lessonNo" value="${lessonNo}"></c:param>
                                <c:param name="page" value="${p }"></c:param> 
                            </c:url>
                            <a href="${pageUrl }" class="navi-btn3">${p }</a>&nbsp;
                        </c:forEach>
                        <c:if test="${pi.currentPage + 1 <= pi.maxPage}">
                            <a href="/apply/listbylesson?lessonNo=${lessonNo}&page=${pi.currentPage+1}" id="navi-btn4"> ＞ </a>
                        </c:if> 
                        <c:if test="${pi.currentPage + 1 <= pi.maxPage}">
                            <a href="/apply/listbylesson?lessonNo=${lessonNo}&page=${pi.maxPage}" id="navi-btn5"> ≫ </a>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </body>
</html>