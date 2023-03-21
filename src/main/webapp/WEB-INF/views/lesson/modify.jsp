<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 레슨수정</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/resources/css/lesson/modify.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/footer.css">
	</head>
	<body>
		 <script>
	        function check() {
	            var lessonTitle = document.querySelector("#lesson-title");
	            var lessonPlan = document.querySelector("#lesson-plan");
	            var titleRegExp = /^[a-zA-Zㄱ-힣0-9]{5,20}$/;
	            var planRegExp = /^[a-zA-Zㄱ-힣0-9]{5,20}$/;    
	            if(!titleRegExp.test(lessonTitle.value)) {
	                lessonTitle.style.backgroundColor = 'palegoldenrod'; 
	                alert("레슨명은 5~20자로 만들어 주세요!");
	                return false;
	            } else if(!planRegExp.test(lessonPlan.value)) {
	            	lessonPlan.style.backgroundColor = 'palegoldenrod'; 
	                alert("한줄 소개는 5~20자로 적어주세요!");
	                return false;
	            } 
	        }
	    </script>
    
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <div id="modify-main">
        <form action="/lesson/modify" method="post">
            <fieldset>
            <legend>[ 레슨 정보 수정하기 ]</legend>
           		<input type="hidden" name="lessonNo" value="${lesson.lessonNo }">
                <ul id="lesson-modify">
                    <li>
                        <label for="lesson-title">레슨 이름</label>
                        <input type="text" id="lesson-title" name="lessonTitle" value="${lesson.lessonTitle}">
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
                        <!-- 자바스크립트 써서 선택한값 선택되어있게 하기 -->
                        <label for="lesson-price">희망 금액 (회당)</label>
                        <select name="lessonPrice" id="lesson-price">
                            <option value="0~3">0~3</option>
                            <option value="4~6">4~6</option>
                            <option value="7~9">7~9</option>
                            <option value="10~15">10~15</option>
                            <option value="15~">15~</option>
                        </select> 만원 / 1회 레슨당
                    </li>
                    <li>
                        <label for="lesson-plan">유효 일정</label>
                        <input type="text" id="lesson-plan" name="lessonPlan" value="${lesson.lessonPlan}">
                    </li>
                    <li>
                        <label for="lesson-pre">한줄 소개</label>
                        <input type="text" id="lesson-pre" name="lessonPre" value="${lesson.lessonPre}">
                    </li>
                    <li>
                        <label for="lesson-content">상세 소개</label>
                        <textarea name="lessonContent" id="lesson-content" cols="45" rows="10">${lesson.lessonContent}</textarea>
                    </li>  
                </ul>
            </fieldset>
            <div id="modify-btns">
                <input type="submit" value="저장" class="modify-btn" onclick="return check();">
                <input type="button" value="삭제" class="modify-btn" onclick="removeLesson(${lesson.lessonNo });">
            </div>
        </form>   
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        
        
        <script>
            document.querySelector("[value='${lesson.lessonArea}']").selected = true;
            document.querySelector("[value='${lesson.lessonPrice}']").selected = true;
           
            function removeLesson(lessonNo) {
                if(confirm("레슨을 삭제하시겠습니까?")) {
                    location.href="/lesson/remove?lessonNo="+lessonNo;
                }
            }
           
        </script>
	</body>
</html>