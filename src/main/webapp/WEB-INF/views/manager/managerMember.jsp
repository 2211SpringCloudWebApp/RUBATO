<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 회원관리 페이지</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/manager/managerMember.css">
    <script src="/resources/js/manager/managerMember.js" defer></script>
</head>
<body>
    <div id="container">
        <header>
            <div id="logo">
                <img src="/resources/images/manager/logo.png" alt="로고">
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
                        <li><a href="#">-- 마켓게시판</a></li>                

                    </ul>
                </li>
                <li class="group">
                    <div class="title">신고관리</div>
                </li> 
                <li class="group">
                    <div class="title"><a href="/manager/logout">로그아웃</a></div>
                    
                </li>
            </ul>
            
            <div id="main-board">
                <div id="main-table">
                    <div class="table-title">
                        <h3>회원관리</h3>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>아이디</th>
                                    <th>이름</th>
                                    <th>닉네임</th>
                                    <th>이메일</th>
                                    <th>연락처</th>
                                    <th>주소</th>
                                    <th>가입일</th>
                                    <th>포인트</th>
                                    <th>관리</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${mList }" var="member">
                                <tr>
                                    <td style="width: 130px;">${member.memberId }</td>
                                    <td style="width: 100px;">${member.memberName }</td>
                                    <td style="width: 130px;">${member.memberNickname }</td>
                                    <td style="width: 210px;">${member.memberEmail }</td>
                                    <td style="width: 150px;">${member.memberPhone }</td>
                                    <td style="width: 400px;">${member.memberAddr }</td>
                                    <td style="width: 100px;">${member.regDate }</td>
                                    <td style="width: 50px;">${memberPoint }</td>
									<!--아이디가 관리자라면 탈퇴에 a 태그 안뜨게, 나머지 회원들한테만 뜨게 c:if 사용 (관리자는 탈퇴못하게) -->
                                    <c:if test="${member.memberId != 'mngmt2023' }">
                                    	<td><a href="javascript:void(0)" onclick="deleteCheck('${member.memberId}');">탈퇴</a></td>
                                    </c:if>
                                    <c:if test="${member.memberId == 'mngmt2023' }">
                                    	<td>탈퇴</td>
                                    </c:if>
                                </tr>
                              </c:forEach>
                            </tbody>
                        </table>
            
                    <div id="footer">
                        <div id="select">
                            <form action="/manager/searchMember" method="get">
                                <select name="searchMemberCondition" id="">
                                    <option value="all">전체</option>
                                    <option value="m-id">아이디</option>
                                    <option value="m-name">이름</option>
                                </select>
                                <input type="text" name="searchValue" value="${keyword }"placeholder="검색">
                                <input type="submit" id="search-btn" name="search-btn"value="검색">
                            </form>
                        </div>
                        <div id="page">
                        	<tr>
                        		<td colspan="9">
									<!--'<' 누르면 현재페이지 -1 한 페이지를 보여주기 -->
									<c:if test="${pi.currentPage - 1 != 0}">
                        				<a href="/manager/main?page=${pi.currentPage - 1 }" class="naviBtn"> ◀ </a>
									</c:if>
									<c:if test="${pi.currentPage - 1 == 0}">
                        				<a href="javascript:void(0)" class="naviBtn"> ◀ </a>
									</c:if>
									<!--ㄴ 현재페이지 - 1 해서 0이 아닐때만 이전으로 이동 0 이면 a링크 동작 x -->
                        			<c:forEach begin="${pi.startNavi }" end="${pi.endNavi }" var="p">
										<c:url var="pageUrl" value="/manager/main">
											<c:param name="page" value="${p }"></c:param>
										</c:url>
										<a href="${pageUrl }" class="naviBtn">${p }</a>&nbsp;
									</c:forEach>
									<!--현재페이지 + 1 이 최대페이지랑 똑같을때까지 '>' 이걸 보여주겠다 -->
									<c:if test="${pi.currentPage + 1 <= pi.maxPage}">
                        				<a href="/manager/main?page=${pi.currentPage + 1 }" class="naviBtn"> ▶ </a>
									</c:if>
									<!--근데 현재페이지가 최대페이지랑 같다면 a링크는 동작하지 x -->
									<c:if test="${pi.currentPage == pi.maxPage}">
                        				<a href="javascript:void(0)" class="naviBtn"> ▶ </a>
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