<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 마켓</title>
		<!-- common header, footer css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- marketList.jsp css & js -->
		<link rel="stylesheet" href="/resources/css/market/marketList.css">
		<script src="/resources/js/market/marketList.js" defer></script>
	    <link rel="preconnect" href="https://fonts.googleapis.com">
    	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	</head>
	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		<main>
		    <div id="top-area">
		        <img alt="" src="/resources/images/market/banner.png">
		    </div>
		    <div id="main-area">
			    <form action="/market/list" method="GET">
			        <div id="top-area2">
			        	<input type="hidden" name="sellArea" value="${searchInfo.sellArea }">
			        	<input type="hidden" name="sellCondition" value="${searchInfo.sellCondition }">
			            <input type="text" id="search-input" name="search" placeholder="원하는 상품을 검색해보세요" value="${searchInfo.search }">
			            <input type="button" id="write-btn" value="판매등록" onclick="enroll()">
			        </div>
			    </form>
			    <ul id="place-nav">
			        <a href="/market/list"><li>전체</li></a>
			        <a href="/market/list?sellArea=seoul&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>서울</li></a>
			        <a href="/market/list?sellArea=gyeonggi&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>경기도</li></a>
			        <a href="/market/list?sellArea=busan&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>부산</li></a>
			        <a href="/market/list?sellArea=daegu&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>대구</li></a>
			        <a href="/market/list?sellArea=incheon&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>인천</li></a>
			        <a href="/market/list?sellArea=daejeon&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>대전</li></a>
			        <a href="/market/list?sellArea=ulsan&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>울산</li></a>
			        <a href="/market/list?sellArea=sejong&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>세종</li></a>
			        <a href="/market/list?sellArea=gangwon&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>강원도</li></a>
			        <a href="/market/list?sellArea=chungcheong&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>충청도</li></a>
			        <a href="/market/list?sellArea=jeonla&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>전라도</li></a>
			        <a href="/market/list?sellArea=gyeongsang&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>경상도</li></a>
			        <a href="/market/list?sellArea=jeju&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search}"><li>제주도</li></a>
			    </ul>
		        <input type="hidden" id="sellAreaValue" value="${searchInfo.sellArea }">
		        <input type="hidden" id="searchValue" value="${searchInfo.search }">
			    <select name="sellCondition" id="selectCondition">
			        <option value="all">전체</option>
			        <option value="selling" <c:if test="${searchInfo.sellCondition eq 'selling'}">selected</c:if>>판매중</option>
			        <option value="soldout" <c:if test="${searchInfo.sellCondition eq 'soldout'}">selected</c:if>>판매완료</option>
			    </select>
			    <div id="list-area">
			    <c:if test="${sellList eq null }">
			    	<h4 id="no-posting">게시물이 존재하지 않습니다.</h4>
			    </c:if>
			    <c:forEach items="${sellList }" var="sell">
			        <div class="product-area">
			        	<a href="/market/detail?sellNo=${sell.sellNo }">
			        	<c:set var="img1" value="${sell.img1 }" />
			            <img src="${fn:substring(img1,56, fn:length(img1)) }" alt="">
			            <div class="product-area1">
			                <h3>${sell.sellTitle }</h3>
			        	</a>
			        		<c:if test="${sell.sellArea  eq 'seoul'}">
				                <span>서울 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'gyeonggi'}">
				                <span>경기도 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'busan'}">
				                <span>부산 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'daegu'}">
				                <span>대구 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'incheon'}">
				                <span>인천 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'daejeon'}">
				                <span>대전 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'ulsan'}">
				                <span>울산 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'sejong'}">
				                <span>세종 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'gangwon'}">
				                <span>강원도 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'chungcheong'}">
				                <span>충청도 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'jeonla'}">
				                <span>전라도 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'gyeongsang'}">
				                <span>경상도 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			        		<c:if test="${sell.sellArea  eq 'jeju'}">
				                <span>제주도 · <fmt:formatDate value="${sell.writeDate }" pattern="yyyy-MM-dd"/></span>
			        		</c:if>
			                <h3><fmt:formatNumber value="${sell.sellPrice }" pattern="#,###" />원</h3>
			            </div>
			            <div class="product-area2">
			            	<c:if test="${sell.sellCondition  eq 'selling' && sell.productCondition eq 'new'}">
				                <h3>판매중 · 새상품</h3>
			            	</c:if>
			            	<c:if test="${sell.sellCondition  eq 'selling' && sell.productCondition eq 'almostNew'}">
				                <h3>판매중 · 거의 새것</h3>
			            	</c:if>
			            	<c:if test="${sell.sellCondition  eq 'selling' && sell.productCondition eq 'used'}">
				                <h3>판매중 · 중고</h3>
			            	</c:if>
			            	<c:if test="${sell.sellCondition  eq 'selling' && sell.productCondition eq 'defective'}">
				                <h3>판매중 · 하자있음</h3>
			            	</c:if>
			            	<c:if test="${sell.sellCondition  eq 'soldout'}">
				                <h3>판매완료</h3>
			            	</c:if>
	<%-- 		                <h3>${sell.sellCondition } · ${sell.productCondition }</h3> --%>
			                <div class="product-area3">
			                    <h4>판매자: ${sell.memberNickname }</h4>
			                    <img src="/resources/images/market/comment.png" alt=""><span id="comment">${sell.commentCount }</span>
			                    <img src="/resources/images/market/view.png" alt=""><span id="viewCount">${sell.viewCount }</span>
			                </div>
			            </div>
			        </div>
			    </c:forEach>
			    </div>
	   		    <c:if test="${sellList ne null }">
				    <!-- 전체 동적 네비게이터 -->
				    <c:if test="${searchInfo.search eq null && searchInfo.sellArea eq null && searchInfo.sellCondition eq null}">
				    <div id="navi-area">
				        <a href="/market/list?page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 검색 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea eq '' && searchInfo.sellCondition eq '' and searchInfo.search ne ''}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=&sellCondition=&search=${searchInfo.search}&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=&sellCondition=&search=${searchInfo.search}&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=&sellCondition=&search=${searchInfo.search}&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=&sellCondition=&search=${searchInfo.search}&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=&sellCondition=&search=${searchInfo.search}&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 지역 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea ne '' && searchInfo.sellCondition eq '' and searchInfo.search eq ''}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 판매여부 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea eq '' && searchInfo.sellCondition ne '' and searchInfo.search eq ''}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 지역+검색 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea ne '' && searchInfo.sellCondition eq '' and searchInfo.search ne ''}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=${searchInfo.search }&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=${searchInfo.search }&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=${searchInfo.search }&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=${searchInfo.search }&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=&search=${searchInfo.search }&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 지역+판매여부 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea ne '' && searchInfo.sellCondition ne '' and searchInfo.search eq ''}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 판매여부+검색 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea eq '' && searchInfo.sellCondition ne '' and searchInfo.search ne ''}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
				    <!-- 지역+판매여부+검색 동적 네비게이터 -->
				    <c:if test="${searchInfo.sellArea ne '' && searchInfo.sellCondition ne '' and searchInfo.search ne '' and searchInfo.sellArea ne null && searchInfo.sellCondition ne null and searchInfo.search ne null}">
				    <div id="navi-area">
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=1" id="navi-btn1">≪</a>
				        <!-- 현재 페이지가 1이면 < 가 동작하지 않도록 -->
				        <c:if test="${pi.currentPage eq 1 }">
					        <a href="javscript:void(0);" id="navi-btn2">＜</a>
				        </c:if>
				        <!-- 현재 페이지가 1보다 크면 < 가 동작 -->
		   		        <c:if test="${pi.currentPage gt 1 }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${pi.currentPage-1 }" id="navi-btn2">＜</a>
				        </c:if>
				        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="i">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${i }" class="navi-btn3">${i }</a>
				        </c:forEach>
				        <c:if test="${pi.currentPage lt pi.maxPage }">
					        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${pi.currentPage+1 }" id="navi-btn4">＞</a>		        
				        </c:if>
		   		        <c:if test="${pi.currentPage eq pi.maxPage }">
					        <a href="javscript:void(0);" id="navi-btn4">＞</a>		        
				        </c:if>
				        <a href="/market/list?sellArea=${searchInfo.sellArea }&sellCondition=${searchInfo.sellCondition }&search=${searchInfo.search }&page=${pi.maxPage }" id="navi-btn5">≫</a>
				    </div>
				    </c:if>
			    </c:if>
		    </div>
		</main>
		<!-- common footer jsp include -->
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	</body>
</html>