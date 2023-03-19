<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 결제</title>
		<!-- common header, footer css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- marketBuy.jsp css & js -->
		<link rel="stylesheet" href="/resources/css/market/marketBuy.css">
		<script src="/resources/js/market/marketBuy.js" defer></script>
		<!-- Google Font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
    	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	    <!--포트원 결제 관련 API-->
	    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	    <!-- 아래 제이쿼리는 1.0이상이면 원하는 버전을 사용하셔도 무방합니다. -->
	    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	</head>
	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	    <!--main 부분-->
	    <main>
	        <h3>주문 상품 정보</h3>
	        <div class="product-area">
	        	<input type="hidden" name="sellNo" value="${sell.sellNo }">
        		<c:set var="img1" value="${sell.img1 }" />
	            <img src="${fn:substring(img1,56, fn:length(img1)) }" alt="">
	            <div class="product-area1">
	                <h4>${sell.sellTitle }</h4>
	                <c:if test="${sell.sellArea  eq 'seoul' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 서울<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'seoul' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 서울<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'seoul' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 서울<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'seoul' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 서울<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeonggi' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 경기도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeonggi' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 경기도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeonggi' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 경기도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeonggi' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 경기도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'busan' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 부산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'busan' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 부산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'busan' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 부산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'busan' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 부산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daegu' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 대구<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daegu' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 대구<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daegu' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 대구<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daegu' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 대구<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'incheon' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 인천<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'incheon' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 인천<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'incheon' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 인천<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'incheon' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 인천<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daejeon' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 대전<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daejeon' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 대전<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daejeon' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 대전<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'daejeon' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 대전<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'ulsan' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 울산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'ulsan' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 울산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'ulsan' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 울산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'ulsan' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 울산<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'sejong' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 세종<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'sejong' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 세종<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'sejong' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 세종<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'sejong' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 세종<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gangwon' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 강원도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gangwon' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 강원도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gangwon' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 강원도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gangwon' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 강원도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'chungcheong' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 충청도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'chungcheong' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 충청도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'chungcheong' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 충청도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'chungcheong' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 충청도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeonla' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 전라도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeonla' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 전라도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeonla' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 전라도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeonla' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 전라도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeongsang' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 경상도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeongsang' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 경상도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeongsang' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 경상도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'gyeongsang' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 경상도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeju' && sell.productCondition eq 'new'}">
		                <h5>거래지역: 제주도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 새상품
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeju' && sell.productCondition eq 'almostNew'}">
		                <h5>거래지역: 제주도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 거의 새것
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeju' && sell.productCondition eq 'used'}">
		                <h5>거래지역: 제주도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 중고
		                </h5>
	                </c:if>
	                <c:if test="${sell.sellArea  eq 'jeju' && sell.productCondition eq 'defective'}">
		                <h5>거래지역: 제주도<br>
		                    판매자: ${sell.memberNickname }<br>
		                    제품상태: 하자있음
		                </h5>
	                </c:if>
	                <h4><fmt:formatNumber value="${sell.sellPrice }" pattern="#,###" />원</h4>
	            </div>
	        </div>
	        <h3>주문자 정보</h3>
	        <div id="buyer-area">
	        	<input type="hidden" name="buyerId" value="${loginUser.memberId }">
	            <h4>${loginUser.memberName }</h4>
	            <h5>${loginUser.memberPhone }</h5>
	            <h5>${loginUser.memberEmail }</h5>
	            <span id="alert-msg">* 주문자 정보가 일치하지 않으면, 회원정보 수정 후 다시 이용해주세요.</span>
	            <button id="modify-btn" onclick="modify()">수정</button>
	        </div>
	        <h3>배송 정보 (주문자 정보 자동 기입)</h3>
	        <div id="delivery-area">
	            <h4>${loginUser.memberName }</h4>
	            <h5 id="phone-num">${loginUser.memberPhone }</h5>
	            <c:set var="memberAddr" value="${loginUser.memberAddr }"/>
	            <h5>${fn:replace(memberAddr, "++", " ")}</h5>
	            <h4>배송메모</h4>
	            <input type="text" name="deliveryMsg"><br>
	            <span id="alert-msg">* 배송 정보가 일치하지 않으면, 회원정보 수정 후 다시 이용해주세요.</span>
	            <button id="modify-btn" onclick="modify()">수정</button>
	        </div>
	        <h3>최종 결제금액</h3>
	        <div id="payment-area">
	            <div id="payment-info">
	                <h4>상품 가격</h4>
	                <h4>배송비</h4>
	                <h3>총 결제금액</h3>
	            </div>
	            <div id="payment-info2">
	                <h4><fmt:formatNumber value="${sell.sellPrice }" pattern="#,###" />원</h4>
	                <h4>+3,500원</h4>
	                <h3 id="total-payment"><fmt:formatNumber value="${sell.sellPrice+3500 }" pattern="#,###" />원</h3>
	                <input type="hidden"  id="total_price" value="${sell.sellPrice+3500 }">
	            </div>
	        </div>
	        <button id="payment-btn" onclick="payment()">결제하기</button>
        </main>
		<!-- common footer jsp include -->
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	</body>
</html>