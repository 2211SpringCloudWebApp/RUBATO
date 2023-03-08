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
    <link rel="stylesheet" href="/resources/css/lesson/apply.css">
    <link rel="stylesheet" href="/resources/css/common/header.css">
    <link rel="stylesheet" href="/resources/css/common/footer.css">
</head>
<body> 
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="apply-main">
        <fieldset>
            <legend>[ Rubato 레슨 신청하기 ]</legend>
            <form action="">
                <ul id="lesson-apply">
                    <li>
                        <label for="lesson-title">레슨 이름</label>
                        <input type="text" id="lesson-title" name="lesson-title">
                    </li>
                    <li>
                        <label for="apply-price">희망 금액 (회당)</label>
                        <input type="text" id="apply-price" name="apply-price" placeholder=""> 만원 / 1회 레슨당 <br>
                        <p><small>※ 선생님이 제시한 금액 내에서 요청해야 매칭이 가능해요</small></p>
                    </li>
                    <li style="margin-top: -30px;">
                        <label for="apply-plan">일정 요청</label>
                        <input type="text" id="apply-plan" name="apply-plan">
                    </li>
                    <li>
                        <label for="apply-content">요청사항</label>
                        <textarea name="apply-content" id="apply-content" cols="45" rows="10" placeholder="원하는 수업 내용을 자세히 적어주세요!"></textarea>
                    </li>        
                </ul>
            </fieldset>
            <div id="apply-btns">
                <input type="submit" value="신청하기" class="apply-btn">
                <input type="reset" value="초기화" class="apply-btn">
            </div>
            </form>
        </fieldset>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>