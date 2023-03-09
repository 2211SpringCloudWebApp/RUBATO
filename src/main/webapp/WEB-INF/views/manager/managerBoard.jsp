<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 게시물관리 페이지</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/manager/managerBoard.css">
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
            <div id="main-menu">
                <ul>
                    <li><a href="/manager/main">회원관리</a></li>
                    <li><a href="/manager/Board">게시글관리</a></li>
                    <li><a href="#">신고관리</a></li>
                    <li><a href="/manager/logout">로그아웃</a></li>

                </ul>
            </div>
            <div id="main-board">
                <div id="main-table">
                    <div class="table-title">
                        <h3>게시글관리</h3>
                        </div>
                    <table>
                        <thead>
                            <tr>
                                <th>글 번호</th>
                                <th>게시판 목록</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성날짜</th>
                                <th>삭제</th>
                            
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
    
                            </tr>
                        </tbody>
                    </table>
                    <div id="footer">
                        <div id="select">
                            <form action="/manager/board" method="post">
                                <select name="" id="">
                                    <option value="">전체</option>
                                    <option value="">글번호</option>
                                    <option value="">게시판</option>
                                    <option value="">작성자</option>

                                </select>
                                <input type="text" name="searchValue" placeholder="검색">
                                <input type="submit" id="search-btn" name="search-btn" value="검색">
                            </form>
                        </div>
                        <div id="page">
                            < 1 2 3 >
                        </div>
                    </div>

                </div>

            </div>
        </main>
</body>
</html>