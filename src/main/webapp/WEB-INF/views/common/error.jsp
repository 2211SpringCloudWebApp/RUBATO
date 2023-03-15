<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>RUBATO - error</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/resources/css/common/error.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/footer.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <div id="error-container">
            <br><br>
            <h2>${msg }</h2>
            <h3>이용에 불편을 드려 죄송합니다.</h3>
            주소나 정보가 올바른지 다시 한번 확인해주시기 바랍니다. <br>
            지속적인 오류 발생 시, 고객센터로 문의하시면 향후 서비스 향상에 도움이 될 수 있습니다.<br>
            <button id="error-btn" onclick="location.href='/'">메인화면으로 가기</button>
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </body>
</html>