<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 신청수정</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/apply/modify.css">
    <link rel="stylesheet" href="/resources/css/common/header.css">
    <link rel="stylesheet" href="/resources/css/common/footer.css">
</head>
<body> 
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="modify-main">
        <form action="/apply/modify" method="post">
        	<input type="hidden" name="lessonNo" value=${apply.lessonNo }>
            <fieldset>
                <legend>[ Rubato 신청내용 수정 ]</legend>
                <ul id="apply-modify">
                    <li>
                        <label for="apply-price">희망 금액 (회당)</label>
                        <input type="text" id="apply-price" name="applyPrice" value="${apply.applyPrice}"> 만원<br>
                    </li>
                    <li>
                        <label for="apply-plan">희망 일정</label>
                        <input type="text" id="apply-plan" name="applyPlan"  value="${apply.applyPlan}">
                    </li>
                    <li>
                        <label for="apply-content">요청사항</label>
                        <textarea name="applyContent" id="apply-content" cols="45" rows="10">${apply.applyContent}</textarea>
                    </li>        
                </ul>
            </fieldset>
            <div id="modify-btns">
                <input type="submit" value="수정하기" class="modify-btn">
                <input type="reset" value="초기화" class="modify-btn">
            </div>
        </form>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>