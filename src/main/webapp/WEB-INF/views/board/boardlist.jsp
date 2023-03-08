<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" type="text/css" href="../board/boardlist.css">
	</head>
	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="boardMain">
        <h1 style="color: #2FBDB1;">자유게시판</h1>

    <div id="boardList">
        <ul>
            <!-- 게시판 목록  -->
            <li>
                <ul id ="ulTable">
                    <li>
                        <ul>
                            <li>No</li>
                            <li>분류</li>
                            <li>제목</li>
                            <li>작성일</li>
                            <li>작성자</li>
                            <li>조회수</li>
                        </ul>
                    </li>
                    <!-- 게시물이 출력될 영역 -->
                    <li>
                        <ul>
                            <li>1</li>
                            <li>고민상담</li>
                            <li class="left">글제목을 뭘로 할지 고민이에요.</li>
                            <li>2023.03.07</li>
                            <li>김성자</li>
                            <li>2</li>
                        </ul>
                    </li>

                    <li>
                        <ul>
                            <li>2</li>
                            <li>레슨후기</li>
                            <li class="left">예상보다 더 좋았어요.</li>
                            <li>2023.03.07</li>
                            <li>최성자</li>
                            <li>32</li>
                        </ul>
                    </li>

                    <li>
                        <ul>
                            <li>3</li>
                            <li>기타</li>
                            <li class="left">레슨 신청 하고 나서요...</li>
                            <li>2023.03.07</li>
                            <li>이성자</li>
                            <li>3</li>
                        </ul>
                    </li>

                    <li>
                        <ul>
                            <li>4</li>
                            <li>고민상담</li>
                            <li class="left">피아노를 배우고 싶은데 고민이에요.</li>
                            <li>2023.03.07</li>
                            <li>송성자</li>
                            <li>17</li>
                        </ul>
                    </li>   
                    </ul>

            <!-- 게시판 페이징 영역 -->
                <div id="divPaging">
                    <a href="#">◀</a>
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">▶</a>
                </div>

            <!--글쓰기-->
            <!-- 검색 폼 영역 -->
            <li id='liSearchOption'>
                <div>
                    <select id='selSearchOption' >
                        <option value='A'>제목+내용</option>
                        <option value='T'>제목</option>
                        <option value='C'>내용</option>
                    </select>
                    <input id='txtKeyWord' />
                    <input type='button' value='검색' onClick="window.open('#')"/>
                    <input type='submit' value='글쓰기' onClick="'#'"/>
                </div>
                </li>

        </ul>
    </div>
    </div>
	</body>
	<!-- common footer jsp include -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</html>