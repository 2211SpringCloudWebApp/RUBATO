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
                                    <th>회원정보 수정일</th>
                                    <th>포인트 잔액</th>
                                    <th>관리</th>
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
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>ㅇ</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
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
                            <form action="/manager/memberView" method="post">
                                <select name="" id="">
                                    <option value="">전체</option>
                                    <option value="">아이디</option>
                                    <option value="">이름</option>
                                </select>
                                <input type="text" name="searchValue" placeholder="검색">
                                <input type="submit" id="search-btn" name="search-btn"value="검색">
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