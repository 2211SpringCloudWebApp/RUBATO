<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RUBATO</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/common/main.css">
<link rel="stylesheet" href="/resources/css/common/header.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="container">
        <div id="main-layer1">
            <div id="main-info">
                <p id="main-slogan">
                    <b>Rubato : 박자에 얽매이지 않고 자유롭게</b>
                </p><br><br><br>
                <div>  
                    음악을 배우고 싶지만 비용, 시간이 부담되는 사람들과 <br>
                    원하는 시간에 음악을 가르치고 싶은 사람들을 위한 <br>
                    <b>1:1 레슨 매칭</b>
                </div>
            </div>
            <div id="main-slide">slide</div>
            <!-- https://doraeul19.tistory.com/176 -->
        </div>
        <div id="main-layer2">
            <p id="main2-title">[ Rubato 실시간 인기 강의 ]</p>
            <div id="main2-img">
                <div class="lesson-hot" id="lesson-1">
                    <p>오늘 등록된 따끈따끈한 레슨</p>
                    <div>
                        <br><br>
                        있어보이게 피아노 치는 법 <br>
                        일주일에 한번 레슨으로 한달에 한곡 완성!
                    </div>
                </div>
                <div class="lesson-hot" id="lesson-2">
                    <p>조회수 급상승↗</p>
                    <div>
                        <br><br>
                        대형기획사 현직 트레이너가 알려드리는 <br>
                        발성 기초부터 보컬 스킬까지
                    </div>
                </div>
            </div>   
        </div>
    </div>
    <div id="underContainer">
        <div class="quickS">
            <div id="quickBox1" style=" cursor: pointer;" onclick="location.href='#';">
                <h3 class="quickText">레슨을 하고 싶다면,</h3>
                <p class="quickText2">레슨 글 작성하기</p>
                <img src="/resources/images/common/quick_선생님.png">
            </div>
            <div id="quickBox2" style=" cursor: pointer;" onclick="location.href='#';">
                <h3 class="quickText">취미를 시작해볼까요?</h3>
                <p class="quickText2">레슨 찾아보기</p>
                <img src="/resources/images/common/quick_학생.png">
            </div>
            <div id="quickBox3" style=" cursor: pointer;" onclick="location.href='#';">
                <h3 class="quickText">자유게시판</h3>
                <p class="quickText2">레슨후기·일상공유</p>
                <img src="/resources/images/common/quick_게시판.png">
            </div>
            <div id="quickBox4" style=" cursor: pointer;" onclick="location.href='#';">
                <h3 class="quickText">마켓거래</h3>
                <p class="quickText2">안전하고 편하게 구매</p>
                <img src="/resources/images/common/quick_마켓.png">
            </div>
        </div>

        <div id="siteGuide">
            <h2>사이트 가이드</h2>
        </div>

        <div class="divLine"></div>

        <div class="quickS">
            <div id="underBox1">
                <h3>시간을 아낄 수 있어요.</h3>
                <p>본업과 음악레슨을 함께 할 수 있도록<br> 도와드릴게요.<br>레슨시간과 비용을 자유롭게 조율하여,<br>효율적인 레슨 관리가 가능합니다.</p>
            </div>
            <div id="underBox2">
                <h3>취미를 취미답게!</h3>
                <p>나에게 맞는 일정과 비용으로 <br>가볍고 즐겁게 음악을 배울 수 있습니다.</p>
            </div>
            <div id="underBox3">
                <h3>믿고 거래하기</h3>
                <p>중고거래가 두려우신가요?<br>소중한 내 돈,<br> 안전한 결제시스템으로 보호해드립니다.</p>
            </div>
        </div>
	</div>
</body>
</html>