<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 레슨등록</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/lesson/create.css">
    <link rel="stylesheet" href="/resources/css/common/header.css">
    <link rel="stylesheet" href="/resources/css/common/footer.css">
</head>
<body> 
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="create-main">
        <fieldset>
            <legend>[ Rubato 선생님 되기 ]</legend>
            <form action="/lesson/create" method="post">
                <ul id="lesson-create">
                    <li>
                        <label for="lesson-title">레슨 이름</label>
                        <input type="text" id="lesson-title" name="lessonTitle">
                    </li>
                    <li>
                        <label for="lesson-area">레슨 지역</label>
                        <select name="lessonArea" id="lesson-area">
                            <option value="서울">서울</option>
                            <option value="부산">부산</option>
                            <option value="대구">대구</option>
                            <option value="인천">인천</option>
                            <option value="광주">광주</option>
                            <option value="대전">대전</option>
                            <option value="울산">울산</option>
                            <option value="세종">세종</option>
                            <option value="강원">강원</option>
                            <option value="경기북부">경기북부</option>
                            <option value="경기남부">경기남부</option>
                            <option value="경북">경북</option>
                            <option value="경남">경남</option>
                            <option value="전북">전북</option>
                            <option value="전남">전남</option>
                            <option value="충북">충북</option>
                            <option value="충남">충남</option>             
                            <option value="제주">제주</option>
                        </select>
                    </li>
                    <li>
                        <label for="lesson-price">희망 금액 (회당)</label>
                        <select name="lessonPrice" id="lesson-price">
                            <option value="0~3" selected>0~3</option>
                            <option value="4~6">4~6</option>
                            <option value="7~9">7~9</option>
                            <option value="10~15">10~15</option>
                            <option value="15~">15~</option>
                        </select> 만원 / 1회 레슨당
                    </li>
                    <li>
                        <label for="lesson-plan">유효 일정</label>
                        <input type="text" id="lesson-plan" name="lessonPlan">
                    </li>
                    <li>
                        <label for="lesson-pre">한줄 소개</label>
                        <input type="text" id="lesson-pre" name="lessonPre" placeholder="목록에서 보일 한줄 소개를 적어주세요.">
                    </li>
                    <li>
                        <label for="lesson-content">상세 소개</label>
                        <textarea name="lessonContent" id="lesson-content" cols="45" rows="10" placeholder="상세한 소개로 매칭확률 UP!"></textarea>
                    </li>  
                </ul>
                <div id="create-btns">
                    <input type="submit" value="레슨 생성" class="create-btn">
                    <input type="reset" value="초기화" class="create-btn">
                </div>
            </form>
        </fieldset>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>