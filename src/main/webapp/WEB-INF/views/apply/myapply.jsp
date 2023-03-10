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
            <c:forEach items="${aList}" var="apply" varStatus="i">   
                <table id="list-detail">
                    <tr>
                        <td colspan="2">${lesson.lessonTitle}</td>
                        <td rowspan="2"><button onclick="removeApply('${apply.lessonNo}', '${apply.memberId}');">삭제</button></td>
                    </tr>
                    <tr>
                        <!-- inner값 가져오도록 컨트롤러 수정하기 -->
                        <td>${apply.applyPrice}</td>
                        <td>${apply.applyPlan}</td>
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