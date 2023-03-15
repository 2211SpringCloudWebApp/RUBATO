<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>자유게시판 목록</title>
            <!-- common header css & js -->
            <link rel="stylesheet" href="/resources/css/common/header.css">
            <!-- common footer css & js -->
            <link rel="stylesheet" href="/resources/css/common/footer.css">
            <!-- boardlist css & js -->
            <link rel="stylesheet" type="text/css" href="/resources/css/board/boardsearch.css">
        </head>

        <body>
            <!-- common header jsp include -->
            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <div id="boardMain">
                <h1 style="color: #2FBDB1;">자유게시판</h1>

                <div id="boardList">
                    <!-- 게시판 목록  -->
                    <ul></ul>
                    <ul id="ulTable">
                        <li>
                            <ul>
                                <li>번호</li>
                                <li>분류</li>
                                <li>제목</li>
                                <li>작성일</li>
                                <li>작성자</li>
                                <li>조회수</li>
                            </ul>
                        </li>
                        <!-- 게시물이 출력될 영역 -->
                        <li>
                            <c:forEach items="${sList}" var="board" varStatus="i">
                                <ul>
                                    <li>${i.count }</li>
                                    <li>${board.boardCategory }</li>
                                    <li class="left"><a href="/board/detail?boardNo=${board.boardNo }"
                                            id="boardTitlecss">${board.boardTitle }</a></li>
                                    <li class="boardLi">${board.boardDate }</li>
                                    <li>${board.memberId }</li>
                                    <li>${board.viewCount }</li>
                                    <li><div class="listLine"></div></li>
                                </ul>
                            </c:forEach>
                        </li>
                        <!-- 게시판 페이징 영역 -->
                        <li id="divPaging">
                            <ul>
                                <li id="naviLi">
                                    <div id="naviDIV">
                                        <a href="${pi.startNavi }" class="naviBtn">◀</a>
                                        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="p">
                                            <c:url var="pageUrl" value="/board/list">
                                                <c:param name="page" value="${p }"></c:param>
                                            </c:url>
                                            <a href="${pageUrl}"
                                                class="naviBtn ${p == currentPage ? 'active' : ''}">${p}</a>
                                        </c:forEach>
                                        <a href="${pi.endNavi }" class="naviBtn">▶</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <!-- 검색 폼 영역 -->
                    <li id='liSearchOption'>
                        <ul>
                            <li>
                                <div id="searchDIV">
                                    <form action="/board/search" method="get">
                                        <select id='selSearchOption' name="searchCondition">
                                            <option value='1' <c:if test="${search.searchCondition == '1' }">selected
                                                </c:if>>제목+내용</option>
                                            <option value='2' <c:if test="${search.searchCondition == '2' }">selected
                                                </c:if>>제목</option>
                                            <option value='3' <c:if test="${search.searchCondition == '3' }">selected
                                                </c:if>>내용</option>
                                            <option value='4' <c:if test="${search.searchCondition == '4' }">selected
                                                </c:if>>작성자</option> 
                                        </select>
                                        <input type="text" id='txtKeyWord' name="searchValue"
                                            value="${search.searchValue }" placeholder="검색어를 입력하세요." />
                                        <input type='submit' value='검색'>
                                    </form>
                                </div>
                            </li>
                        </ul>
                    </li>
                    </ul>
                </div>
            </div>
            <script>
                var boardDate = document.querySelectorAll(".boardLi");
                for (var i = 0; i < boardDate.length; i++) {
                    boardDate[i].innerHTML = boardDate[i].innerHTML.substr(0, 10);
                }
            </script>
        </body>
        <!-- common footer jsp include -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

        </html>