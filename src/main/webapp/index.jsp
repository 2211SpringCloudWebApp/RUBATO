<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>RUBATO</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/resources/css/common/main.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/footer.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <div id="container">
            <div id="main-layer1">
                <div class="slideshow-container">
                    <div class="mySlides fade">
                        <div class="numbertext">1</div>
                        <img src="/resources/images/common/3.png" style="width:100%; height: 624px;">
                    </div>
                    <div class="mySlides fade">
                        <div class="numbertext">2</div>
                        <img src="/resources/images/common/2.png" style="width:100%; height: 624px;">
                    </div>
                    <div class="mySlides fade">
                        <div class="numbertext">3</div>
                        <img src="/resources/images/common/info.png" style="width:100%; height: 624px;">
                    </div>
                    <br>
                    <div style="text-align:center">
                        <span class="dot"></span> 
                        <span class="dot"></span> 
                        <span class="dot"></span> 
                    </div>
                </div>
            </div>
            <div id="main-layer2">
                <div id="main-info">
                    <div>  
                        <strong>Rubato : 박자에 얽매이지 않고 자유롭게</strong><br><br>
                        음악을 배우고 싶지만 비용, 시간이 부담되는 사람들과 <br>
                        원하는 시간에 음악을 가르치고 싶은 사람들을 위한 <br>
                        <b>1:1 레슨 매칭</b>
                    </div>
                </div>
                <div class="main2-title">[ Rubato 실시간 인기 강의 ]</div>
                <div id="main2-img">
                    <div class="lesson-hot" id="lesson-1">
                        <p>오늘 등록된 따끈따끈한 레슨</p>
                        <div><a href="/lesson/detail?lessonNo=182">
                            <br><br><br><br>
                            있어보이게 피아노 치는 법 <br>
                            일주일에 한번 레슨으로 한달에 한곡 완성!
                        </a></div>
                    </div>
                    <div class="lesson-hot" id="lesson-2">
                        <p>조회수 급상승↗</p>
                        <div><a href="/lesson/detail?lessonNo=181">
                            <br><br><br><br>
                            대형기획사 현직 트레이너가 알려드리는 <br>
                            발성 기초부터 보컬 스킬까지
                        </a></div>
                    </div>
                </div>   
            </div>
        </div>
        <div id="underContainer">
            <div id="divLine">
                <div class="main2-title">[ Rubato 사이트 가이드 ]</div>
            </div>
            <div class="quickS">
                <div class="quick-box" onclick="location.href='/lesson/create';">
                        <img src="/resources/images/common/quick.png">
                        <div class="info">
                            <p>레슨글 작성</p> 
                        </div>
                </div>
                <div class="quick-box" onclick="location.href='/lesson/list';">
                        <img src="/resources/images/common/qqq.png">
                        <div class="info">
                            <p class="quickText2">레슨 찾아보기</p>
                        </div>
                </div>
                <div class="quick-box" onclick="location.href='/board/list';">           
                        <img src="/resources/images/common/quick.png">
                        <div class="info">
                            <p class="quickText2">자유게시판</p>
                        </div>
                </div>
                <div class="quick-box" onclick="location.href='/market/list';">            
                        <img src="/resources/images/common/qqq.png">             
                        <div class="info">
                            <p class="quickText2">마켓거래</p>
                        </div>
                </div>
            </div>
            <div class="quickS">
                <div class="underBox">
                    <h3>시간을 아낄 수 있어요.</h3>
                    <p>본업과 음악레슨을 함께 할 수 있도록<br> 도와드릴게요.<br>레슨시간과 비용을 자유롭게 조율하여,<br>효율적인 레슨 관리가 가능합니다.</p>
                </div>
                <div class="underBox">
                    <h3>취미를 취미답게!</h3>
                    <p>나에게 맞는 일정과 비용으로 <br>가볍고 즐겁게 음악을 배울 수 있습니다.</p>
                </div>
                <div class="underBox">
                    <h3>믿고 거래하기</h3>
                    <p>중고거래가 두려우신가요?<br>소중한 내 돈,<br> 안전한 결제시스템으로 보호해드립니다.</p>
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        
        <script>
            var slideIndex = 0;
            showSlides();
    
            function showSlides() {
                var i;
                var slides = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("dot");
                for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";  
                }
                slideIndex++;
                if (slideIndex > slides.length) {slideIndex = 1}    
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex-1].style.display = "block";  
                dots[slideIndex-1].className += " active";
                setTimeout(showSlides, 3000); 
            }
        </script>
    </body>
    </html>