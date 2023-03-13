<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/footer.css">
        <link rel="stylesheet" href="/resources/css/member/mypage.css">
        <title>RUBATO - 마이페이지</title>
    </head>

    <body>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <form action="/member/modify" method="get">
        <div id="main">
            <div id="container">
                <div id="logo">
                    <a href="/index.jsp"></a>
                </div>
                <section id="member-message">
                    <h1>${member.memberNickname }님 환영합니다!</h1> <br>
                    <div id="member-message2">
                        <h3>${member.memberPoint }원</h3>
                    </div>
                </section>
                <div id="table">
                    <table border="1">
                        <tr>
                            <td>작성한 글</td>
                            <td>작성한 댓글</td>
                        </tr>
                        <tr>
                            <td>0</td>
                            <td>0</td>
                        </tr>
                    </table>
                </div>
                <div id="table">
                    <table border="1">
                        <tr>
                            <td>레슨 등록 내역</td>
                            <td>레슨 신청 내역</td>
                        </tr>
                        <tr>
                            <td>0</td>
                            <td>0</td>
                        </tr>
                    </table>
                </div>
                <div id="table">
                    <table border="1">
                        <tr>
                            <td>판매 등록 내역</td>
                            <td>구매 신청 내역</td>
                        </tr>
                        <tr>
                            <td>0</td>
                            <td>0</td>
                        </tr>
                    </table>
                </div>
            </div>
            <input type="hidden" name="memberId" value="${memberId}">
            </form>
            <button type="submit" id="login-modify">회원정보수정</button>
        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    </body>

    </html>