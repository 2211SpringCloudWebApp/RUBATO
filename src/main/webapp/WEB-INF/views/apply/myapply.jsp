<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>RUBATO - 나의신청</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/resources/css/apply/myapply.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/footer.css">
    </head>
    <body> 
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <div id="list-main">
            <div id="list-title">
                <h2>나의 신청 내역</h2>
            </div>
            <div id="list-content">
                <input type="hidden" name="lessonNo" value="${apply.lessonNo }">
                <c:forEach items="${aList}" var="apply" varStatus="i">   
                    <table id="list-detail">
                        <tr>
                            <td colspan="4"><a href="/lesson/detail?lessonNo=${apply.lessonNo}" id="detailLink"><b>레슨명 | </b><span>${apply.lessonTitle}</span></a></td>
                            
                        </tr>
                        <tr>
                            <td colspan="4"><b>나의 요청 | </b>${apply.applyContent}</td>
                        </tr>
                        <tr>
                            <td style="width: 20%;"><b>제시 금액 | </b> ${apply.applyPrice}</td>
                            <td style="width: 40%;"><b>요청 일정 | </b>${apply.applyPlan}</td>
                            <td style="width: 20%;"><button onclick="location.href='/apply/modify?lessonNo=${apply.lessonNo}&memberId=${apply.memberId}' ">수정</button></td>
                            <td style="width: 20%;"><button onclick="removeApply('${apply.lessonNo}', '${apply.memberId}');">삭제</button></td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

        <script> 
            function removeApply(lessonNo, memberId) {
                if(confirm("신청을 취소하시겠습니까?")) {
                    location.href="/apply/remove?lessonNo="+lessonNo+"&memberId="+memberId;
                }
            }
        </script>
    </body>
</html>