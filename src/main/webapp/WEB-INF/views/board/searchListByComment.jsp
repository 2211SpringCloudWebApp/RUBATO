<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>마이페이지 나의 댓글</title>
            <!-- common header css & js -->
            <link rel="stylesheet" href="/resources/css/common/header.css">
            <!-- common footer css & js -->
            <link rel="stylesheet" href="/resources/css/common/footer.css">
            <!-- boardlist css & js -->
            <link rel="stylesheet" type="text/css" href="/resources/css/board/mypageMyWrite.css">
        </head>

        <body>
            <!-- common header jsp include -->
            <jsp:include page="/WEB-INF/views/common/header.jsp" />
            <div id="boardMain">
                <h1 style="color: #2FBDB1;">내가 쓴 댓글</h1>

                <div id="boardList">
                    <!-- 게시판 목록  -->
                    <ul></ul>
                    <ul id="ulTable">
                        <li>
                            <ul id="boardListUl">
                                <li>번호</li>
                                <li>분류</li>
                                <li>댓글내용</li>
                                <li>작성일</li>
                                <li>작성자</li>
                                <li>조회수</li>
                            </ul>
                        </li>
                        <!-- 게시물이 출력될 영역 -->
                        <li>
                            <c:forEach items="${cList}" var="board" varStatus="i">
                                <ul>
                                    <li>${i.count }</li>
                                    <li>${board.boardCategory }</li>
                                    <li class="left">${board.commentContent }</a></li>
                                    <li class="boardLi">${board.commentDate }</li>
                                    <li>${board.memberId }</li>
                                    <li>${board.viewCount }</li>
                                    <li>
                                        <div class="listLine"></div>
                                    </li>
                                </ul>
                            </c:forEach>
                        </li>
                        <!-- 게시판 페이징 영역 -->
						<li id="divPaging">
                            <ul>
                                <li id="naviLi">
                                    <div id="naviDIV">
                                   		 <c:if test="${pi.currentPage ne 1 }">
                                        <a href="/board/searchListByComment?page=${pi.currentPage-1 }" class="naviBtn">◀</a>
                                     	 </c:if>
                                        <c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="p">
                                            <c:url var="pageUrl" value="/board/searchListByComment">
                                      	         <c:param name="page" value="${p }"></c:param>\
                                            </c:url>
                                            <a href="${pageUrl}"
                                                class="naviBtn ${p == currentPage ? 'active' : ''}">${p}</a>
                                        </c:forEach>
                                        <c:if test="${pi.maxPage ne pi.currentPage }">
                                        <a href="/board/searchListByComment?page=${pi.currentPage+1 }" class="naviBtn">▶</a>
                                        </c:if>
                                    </div>
                                    <!--글쓰기-->
                                   
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