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
        <div id="list-content">
            <table id="list-detail"><a href="해당글">
                <tr>
                    <td colspan="4">제목</td>
                </tr>
                <tr>
                    <td  colspan="4">한줄소개</td>
                </tr>
                <tr>
                    <td>지역</td>
                    <td>금액</td>
                    <td>시간</td>
                    <td>작성자</td>
                </tr></a>
            </table>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>