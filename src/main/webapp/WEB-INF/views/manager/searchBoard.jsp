<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 자유게시판 관리 페이지</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/manager/managerBoard.css">
    <script src="/resources/js/manager/managerBoard.js" defer></script>
</head>
<body>
    <div id="container">
        <header>
            <div id="logo">
                <a href="/manager/main"><img src="/resources/images/manager/logo.png" alt="로고"></a>
            </div>
            <hr>
        </header>
        <main>
            <ul id="navi">
                <li class="group">
                    <div class="title"><a href="/manager/main">회원관리</a></div>
                    
                </li>
                <li class="group">
                    <div class="title">게시글관리</div>
                    <ul class="sub">
                        <li><a href="/manager/board">-- 자유게시판</a></li>  
                        <li><a href="/manager/lessonBoard">-- 레슨게시판</a></li>                
                        <li><a href="/manager/marketBoard">-- 마켓게시판</a></li>                

                    </ul>
                </li>
                <li class="group">
                    <div class="title"><a href="/manager/reportBoard">신고관리</a></div>
                </li> 
                <li class="group">
                    <div class="title"><a href="/manager/logout">로그아웃</a></div>
                    
                </li>
            </ul>
            
            <div id="main-board">
                <div id="main-table">
                    <div class="table-title">
                        <h3>자유게시판 관리</h3>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>글 번호</th>
                                    <th>카테고리</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성날짜</th>
                                    <th>조회수</th>
                                    <th>삭제</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${searchBoardList }" var="board">
                                 <tr>
                                    <td>${board.boardNo }</td>
                                    <td>${board.boardCategory }</td>
                                    <td><a class="a-color" href="/board/detail?boardNo=${board.boardNo }">${board.boardTitle }</a></td>
                                    <td>${board.memberId }</td>
                                    <td>${board.boardDate }</td>
                                    <td>${board.viewCount }</td>
                                    <td><a class="a-color" href="javascript:void(0)" onclick="deleteCheck('${board.boardNo}');">삭제</a></td>
                                </tr>
                              </c:forEach>
                            </tbody>
                        </table>
            
                    <div id="footer">
                        <div id="select">
                            <form action="/manager/searchBoard" method="get">
                                <select name="searchCondition" id="">
                                    <option value="all" <c:if test="${searchBoard.searchCondition == 'all' }">selected</c:if>>전체</option>
                                    <option value="category" <c:if test="${searchBoard.searchCondition == 'category' }">selected</c:if>>카테고리</option>
                                    <option value="writer" <c:if test="${searchBoard.searchCondition == 'writer' }">selected</c:if>>작성자</option>
                                </select>
                                <input type="text" name="searchValue" value="${searchBoard.searchValue }"placeholder="검색">
                                <input type="submit" id="search-btn" name="search-btn"value="검색">
                            </form>
                        </div>
                        <div id="page">
                        	<tr>
                        		<td colspan="7">
                        			<!-- 한번에 1페이지로 이동 -->
                        			<c:if test="${pi.currentPage - 1 != 0}">
                        				<a href="/manager/searchBoard?page=1&searchValue=${searchBoard.searchValue }&searchCondition=${searchBoard.searchCondition }" class="naviBtn"> ◀◀ </a>
									</c:if>
									<!--'<' 누르면 현재페이지 -1 한 페이지를 보여주기 -->
									<c:if test="${pi.currentPage - 1 != 0}">
                        				<a href="/manager/searchBoard?page=${pi.currentPage - 1 }&searchValue=${searchBoard.searchValue }&searchCondition=${searchBoard.searchCondition }" class="naviBtn"> ◀ </a>
									</c:if>
									<c:if test="${pi.currentPage - 1 == 0}">
                        				<a href="javascript:void(0)" class="naviBtn"> ◀ </a>
									</c:if>
									<!--ㄴ 현재페이지 - 1 해서 0이 아닐때만 이전으로 이동 0 이면 a링크 동작 x -->
                        			<c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="p">
										<c:url var="pageUrl" value="/manager/searchBoard">
											<c:param name="page" value="${p }"></c:param>
											<c:param name="searchValue" value="${searchBoard.searchValue }"></c:param>
											<c:param name="searchCondition" value="${searchBoard.searchCondition }"></c:param>
										</c:url>
										<a href="${pageUrl }" class="naviBtn">${p }</a>&nbsp;
									</c:forEach>
									<!--현재페이지 + 1 이 최대페이지랑 똑같을때까지 '>' 이걸 보여주겠다 -->
									<c:if test="${pi.currentPage + 1 <= pi.maxPage}">
                        				<a href="/manager/searchBoard?page=${pi.currentPage + 1 }&searchValue=${searchBoard.searchValue }&searchCondition=${searchBoard.searchCondition }" class="naviBtn"> ▶ </a>
									</c:if>
									<!--근데 현재페이지가 최대페이지랑 같다면 a링크는 동작하지 x -->
									<c:if test="${pi.currentPage == pi.maxPage}">
                        				<a href="javascript:void(0)" class="naviBtn"> ▶ </a>
									</c:if>
									<!-- 한번에 마지막 페이지로 이동 -->
									<c:if test="${pi.currentPage + 1 <= pi.maxPage}">
                        				<a href="/manager/searchBoard?page=${pi.maxPage }&searchValue=${searchBoard.searchValue }&searchCondition=${searchBoard.searchCondition }" class="naviBtn"> ▶▶ </a>
									</c:if>
                        		</td>
                        	</tr>
                        </div>
                    </div>

                </div>

            </div>
        </main>
        
</body>
</html>