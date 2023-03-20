<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RUBATO - ${sell.sellTitle }</title>
		<!-- common header, footer css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- marketList.jsp css & js -->
		<link rel="stylesheet" href="/resources/css/market/marketDetail.css">
		<script src="/resources/js/market/marketDetail.js" defer></script>
		<!-- Google Font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
    	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	</head>
	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <!--main 부분-->
    <main>
        <div id="img-area">
        	<c:set var="img1" value="${sell.img1 }" />
        	<c:set var="img2" value="${sell.img2 }" />
        	<c:set var="img3" value="${sell.img3 }" />
            <img src="${fn:substring(img1,56, fn:length(img1)) }" class="uploadImg" onclick="window.open(this.src, '_self')">
            <c:if test="${fn:contains(img2, 'null')}">
	            <img src="${fn:substring(img1,56, fn:length(img1)) }" class="uploadImg" onclick="window.open(this.src, '_self')">
            </c:if>
            <c:if test="${not fn:contains(img2, 'null')}">
	            <img src="${fn:substring(img2,56, fn:length(img2)) }" class="uploadImg" onclick="window.open(this.src, '_self')">
            </c:if>
            <c:if test="${fn:contains(img3, 'null')}">
	            <img src="${fn:substring(img1,56, fn:length(img1)) }" class="uploadImg" onclick="window.open(this.src, '_self')">
            </c:if>
            <c:if test="${not fn:contains(img3, 'null')}">
	            <img src="${fn:substring(img3,56, fn:length(img3)) }" class="uploadImg" onclick="window.open(this.src, '_self')">
            </c:if>
	        <span id="imgGuide">사진을 클릭하고 자세히 보세요 !</span>
	        <p class="controller">
			    <!-- &lang: 왼쪽 방향 화살표
			    &rang: 오른쪽 방향 화살표 -->
			    <span class="prev">&lang;</span>  
			    <span class="next">&rang;</span>
		    </p>
        </div>
        <div id="profile-area">
            <img src="/resources/images/market/user.png" id="userimg" alt="">
            <span id="nickname">${sell.memberNickname }</span><br>
            <span id="registerDay">가입일: <fmt:formatDate value="${seller.regDate }" pattern="yyyy-MM-dd"/></span>
            <c:if test="${sell.sellCondition eq 'selling' && seller.memberId ne loginMember.memberId }">
	            <button id="buy-btn" onclick="location.href='/market/payment?sellNo=${sell.sellNo}'">구매하기</button>
            </c:if>
            <c:if test="${sell.sellCondition eq 'soldout' }">
	            <button id="buy-btn" style="background-color: red; cursor: not-allowed;">판매완료</button>
            </c:if>
        </div>
        <div id="info-area">
            <h3>${sell.sellTitle }</h3>
            <c:if test="${sell.sellArea  eq 'seoul'}">
            	<b>거래 지역:</b> 서울 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'gyeonggi'}">
            	<b>거래 지역:</b> 경기도 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'busan'}">
            	<b>거래 지역:</b> 부산 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'daegu'}">
            	<b>거래 지역:</b> 대구 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'incheon'}">
            	<b>거래 지역:</b> 인천 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'daejeon'}">
            	<b>거래 지역:</b> 대전 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'ulsan'}">
            	<b>거래 지역:</b> 울산 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'sejong'}">
            	<b>거래 지역:</b> 세종 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'gangwon'}">
            	<b>거래 지역:</b> 강원도 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'chungcheong'}">
            	<b>거래 지역:</b> 충청도 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'jeonla'}">
            	<b>거래 지역:</b> 전라도 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'gyeongsang'}">
            	<b>거래 지역:</b> 경상도 <br>
            </c:if>
            <c:if test="${sell.sellArea  eq 'jeju'}">
            	<b>거래 지역:</b> 제주도 <br>
            </c:if>
            <c:if test="${sell.productCondition eq 'new'}">
          		<b>제품 상태: </b> 새상품 <br>
          	</c:if>
            <c:if test="${sell.productCondition eq 'almostNew'}">
          		<b>제품 상태: </b> 거의 새것 <br>
          	</c:if>
            <c:if test="${sell.productCondition eq 'used'}">
          		<b>제품 상태: </b> 중고 <br>
          	</c:if>
            <c:if test="${sell.productCondition eq 'defective'}">
          		<b>제품 상태: </b> 하자있음 <br>
          	</c:if>
           	<b>등록일:</b> <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/> <br>
            <h3><fmt:formatNumber value="${sell.sellPrice }" pattern="#,###" />원</h3>
            <pre>
${sell.sellContent }
            </pre>
            <span id="viewComment">조회 ${sell.viewCount } · 댓글 ${commentCount }</span>
            <c:if test="${seller.memberId ne loginMember.memberId }">
	            <a href="#" id="report">신고</a>
            </c:if>
            <c:if test="${seller.memberId eq loginMember.memberId }">
	            <a href="/market/modify?sellNo=${sell.sellNo }" id="modify">수정</a><span id="partition"> · </span>
	            <a href="/market/delete?sellNo=${sell.sellNo }" id="delete" onclick="return deleteCheck()">삭제</a>
            </c:if>
        </div>
        <div id="comment-area">
            <textarea name="commentContent" id="commentContent" cols="30" rows="10" placeholder="부적절한 댓글을 작성할 시 관련 법령에 의거 처벌될 수 있습니다."></textarea>
            <button id="enroll-btn" onclick="commentWrite(${sell.sellNo})">등록하기</button>
			<c:forEach items="${commentList }" var="comment" varStatus="status">
	            <div id="comment">
	                <img src="/resources/images/market/user.png" id="userimg" alt="">
	                <span id="nickname">${comment.memberNickname }</span>
	                <c:if test="${sell.memberId eq comment.memberId }">
		                <span id="writerMark">작성자</span>
	                </c:if>
	                <c:if test="${comment.memberId eq loginMember.memberId }">
		                <span id="commentModify" onclick="commentModify(${status.count}, '${comment.commentContent }', ${comment.commentNo })">수정</span>
		                <span id="partition"> · </span>
		                <span id="commentDelete" onclick="commentDelete(${sell.sellNo}, ${comment.commentNo })">삭제</span>
	                </c:if>
	                <c:if test="${comment.memberId ne loginMember.memberId }">
		                <span id="commentReport">신고</span>
	                </c:if>
	                <br>
	                <span id="registerDay"><fmt:formatDate value="${comment.writeDate }" pattern="yyyy-MM-dd HH:mm"/></span>
	                <p id="ptag${status.count }">${comment.commentContent }</p>
	            </div>
			</c:forEach>
            <div id="navi">
           	<!--  [<] 버튼 -->
            	<c:if test="${pi.currentPage eq 1}">
	            	<a href="javscript:void(0);" id="comment-prev">＜</a>
            	</c:if>
   		        <c:if test="${pi.currentPage gt 1 }">
   		        	<a href="/market/detail?sellNo=${sell.sellNo }&page=${pi.currentPage-1}" id="comment-prev">＜</a>
		        </c:if>
           	<!--  [>] 버튼 -->
		        <c:if test="${pi.currentPage lt pi.maxPage }">
			        <a href="/market/detail?sellNo=${sell.sellNo }&page=${pi.currentPage+1 }" id="comment-next">＞</a>		        
		        </c:if>
   		        <c:if test="${pi.currentPage eq pi.maxPage }">
			        <a href="javscript:void(0);" id="comment-next">＞</a>		        
		        </c:if>
            </div>
        </div>
    </main>

		<!-- common footer jsp include -->
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	</body>
</html>