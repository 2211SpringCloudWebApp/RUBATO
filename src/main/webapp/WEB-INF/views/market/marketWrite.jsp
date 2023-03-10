<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 판매등록</title>
		<!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<!-- marketWrite css & js -->
		<link rel="stylesheet" href="/resources/css/market/marketWrite.css">
		<script src="/resources/js/market/marketWrite.js" defer></script>
	</head>
	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		<main>
		    <div id="top-area">
		        <p>마켓 - 판매등록</p>
		    </div>
		    <form action="/market/write" id="form-tag" method="POST" enctype="multipart/form-data">
		    <div id="post-area">
		        <div id="title-area">
		            <input type="text" id ="title" name="sellTitle" placeholder="상품명">
		            <select name="sellArea" id="area">
		                <option value="seoul">서울</option>
		                <option value="gyeonggi">경기도</option>
		                <option value="busan">부산</option>
		                <option value="daegu">대구</option>
		                <option value="incheon">인천</option>
		                <option value="daejeon">대전</option>
		                <option value="ulsan">울산</option>
		                <option value="sejong">세종</option>
		                <option value="gangwon">강원도</option>
		                <option value="chungcheong">충청도</option>
		                <option value="jeonla">전라도</option>
		                <option value="gyeongsang">경상도</option>
		                <option value="jeju">제주도</option>
		            </select>
		            <select name="productCondition" id="condition">
		                <option value="new">새상품</option>
		                <option value="almostNew">거의 새것</option>
		                <option value="used">중고</option>
		                <option value="defective">하자있음</option>
		            </select>
		        </div>
		        <div id="file-area">
		            <button type="button" id="upload-btn" value="1/3" onclick="imageUpload()">
		                <img src="/resources/images/market/imgUpload.png" alt=""><br>
		                <span id="uploadLimit">0/3</span>
		            </button>
		            <!-- <input type="button" id="upload-btn" value="1/3" onclick="imageUpload()"> -->
		            <div id="file-tag"></div>
		            <div id="thumbnails"></div>
		        </div>
		        <div id="price-area">
		            <span id="won">￦</span>
		            <input type="text" id="price" name="strPrice" placeholder="가격">
		            <span id="won">원</span>
		            <span id="price-msg">(가격을 허위로 기재할 시 이용약관에 의해 제재될 수 있습니다.)</span>
		        </div>
		        <div id="content-area">
		            <textarea name="sellContent" cols="0" rows="0"></textarea>
		        </div>
		    </div>
		    <div id="submit-area">
		        <input type="submit" id="enroll-btn" value="판매등록">
		    </div>
		    </form>
		</main>
	</body>
</html>