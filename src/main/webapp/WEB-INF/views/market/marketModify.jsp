<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 판매수정</title>
		<!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- marketWrite css & js -->
		<link rel="stylesheet" href="/resources/css/market/marketWrite.css">
		<link rel="stylesheet" href="/resources/css/market/marketModify.css">
		<script src="/resources/js/market/marketWrite.js" defer></script>
		<script src="/resources/js/market/marketModify.js" defer></script>
	    <link rel="preconnect" href="https://fonts.googleapis.com">
    	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	</head>
	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		<main>
		    <div id="top-area">
		        <p>마켓 - 판매글 수정</p>
		    </div>
		    <form action="/market/modify" id="form-tag" method="POST" enctype="multipart/form-data">
		    <div id="post-area">
		        <div id="title-area">
		            <input type="text" id ="title" name="sellTitle" placeholder="상품명" value="${sell.sellTitle }">
		            <select name="sellArea" id="area">
		            
		                <option value="seoul" <c:if test="${sell.sellArea eq 'seoul' }">selected</c:if>>서울</option>
		                <option value="gyeonggi" <c:if test="${sell.sellArea eq 'gyeonggi' }">selected</c:if>>경기도</option>
		                <option value="busan" <c:if test="${sell.sellArea eq 'busan' }">selected</c:if>>부산</option>
		                <option value="daegu" <c:if test="${sell.sellArea eq 'daegu' }">selected</c:if>>대구</option>
		                <option value="incheon" <c:if test="${sell.sellArea eq 'incheon' }">selected</c:if>>인천</option>
		                <option value="daejeon" <c:if test="${sell.sellArea eq 'daejeon' }">selected</c:if>>대전</option>
		                <option value="ulsan" <c:if test="${sell.sellArea eq 'ulsan' }">selected</c:if>>울산</option>
		                <option value="sejong" <c:if test="${sell.sellArea eq 'sejong' }">selected</c:if>>세종</option>
		                <option value="gangwon" <c:if test="${sell.sellArea eq 'gangwon' }">selected</c:if>>강원도</option>
		                <option value="chungcheong" <c:if test="${sell.sellArea eq 'chungcheong' }">selected</c:if>>충청도</option>
		                <option value="jeonla" <c:if test="${sell.sellArea eq 'jeonla' }">selected</c:if>>전라도</option>
		                <option value="gyeongsang" <c:if test="${sell.sellArea eq 'gyeongsang' }">selected</c:if>>경상도</option>
		                <option value="jeju" <c:if test="${sell.sellArea eq 'jeju' }">selected</c:if>>제주도</option>
		            </select>
		            <select name="productCondition" id="condition">
		                <option value="new" <c:if test="${sell.productCondition eq 'new' }">selected</c:if>>새상품</option>
		                <option value="almostNew" <c:if test="${sell.productCondition eq 'almostNew' }">selected</c:if>>거의 새것</option>
		                <option value="used" <c:if test="${sell.productCondition eq 'used' }">selected</c:if>>중고</option>
		                <option value="defective" <c:if test="${sell.productCondition eq 'defective' }">selected</c:if>>하자있음</option>
		            </select>
		        </div>
		        <div id="file-area">
                   	<c:set var="img1" value="${sell.img1 }" />
			      	<c:set var="img2" value="${sell.img2 }" />
			      	<c:set var="img3" value="${sell.img3 }" />
		            <button type="button" id="upload-btn" value="1/3" onclick="imageUpload()">
		                <img src="/resources/images/market/imgUpload.png" alt=""><br>
			                <span id="uploadLimit">0/3</span>
<%-- 		                <c:if test="${fn:contains(img2, 'null') && fn:contains(img3, 'null')}"> --%>
<!-- 			                <span id="uploadLimit">1/3</span> -->
<%-- 		                </c:if> --%>
<%-- 		                <c:if test="${not fn:contains(img2, 'null') && fn:contains(img3, 'null')}"> --%>
<!-- 			                <span id="uploadLimit">2/3</span> -->
<%-- 		                </c:if> --%>
<%-- 		                <c:if test="${not fn:contains(img2, 'null') && not fn:contains(img3, 'null')}"> --%>
<!-- 			                <span id="uploadLimit">3/3</span> -->
<%-- 		                </c:if> --%>
		            </button>
		            <div id="file-tag"></div>
		            <div id="thumbnails">
<%-- 		            	<img src="${fn:substring(img1,56, fn:length(img1)) }" class="uploadImg" id="uploadImg1" onclick="thumbnailsDelete('1')"> --%>
<%-- 			            <c:if test="${not fn:contains(img2, 'null')}"> --%>
<%-- 				            <img src="${fn:substring(img2,56, fn:length(img2)) }" class="uploadImg" id="uploadImg2" onclick="thumbnailsDelete('2')"> --%>
<%-- 			            </c:if> --%>
<%-- 			            <c:if test="${not fn:contains(img3, 'null')}"> --%>
<%-- 				            <img src="${fn:substring(img3,56, fn:length(img3)) }" class="uploadImg" id="uploadImg3" onclick="thumbnailsDelete('3')"> --%>
<%-- 			            </c:if> --%>
		            </div>
		        </div>
		        <div id="price-area">
		            <h4 id="img-msg">* 판매글 수정 시 이미지를 다시 등록하셔야 합니다.</h4>
		            <span id="won">￦</span>
		            <input type="text" id="price" name="strPrice" placeholder="가격" value="<fmt:formatNumber value="${sell.sellPrice }" pattern="#,###" />">
		            <span id="won">원</span>
		            <span id="price-msg">(가격을 허위로 기재할 시 이용약관에 의해 제재될 수 있습니다.)</span>
		        </div>
		        <div id="content-area">
		            <textarea name="sellContent" cols="0" rows="0">${sell.sellContent }</textarea>
		        </div>
		    </div>
		    <div id="submit-area">
		    	<input type="hidden" name="sellNo" value="${sell.sellNo }">
		        <input type="submit" id="enroll-btn" value="판매등록">
		    </div>
		    </form>
		</main>
		<!-- common footer jsp include -->
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	</body>
</html>