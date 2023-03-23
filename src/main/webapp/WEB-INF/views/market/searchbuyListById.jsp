<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 나의 판매 내역</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/market/searchbuyListById.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/common/header.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/common/footer.css">
    <script src="/resources/js/manager/managerMarketBoard.js" defer></script>
</head>
<body>
    <div id="container">
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
           
            <div id="main-board">
                <div id="main-table">
            <h1 style="color: #2FBDB1;">구매 신청 내역</h1>
                   
                        <table>
                            <thead>
                                <tr>
                                    <th>글 번호</th>
                                    <th>이미지</th>
                                    <th>글 제목</th>
                                    <th>판매 가격</th>
                                    <th>판매자 ID</th>
                                    <th>배송 메세지</th>
                                    <th>결제일</th>
                                </tr>
                            </thead>
                            <tbody>
                             <!-- value="${imageList[status.index].img1 }"  -->
                            
                     
                              <c:forEach items="${paymentList }" var="market" varStatus="status">
                                <tr>
                                    <td>${market.sellNo }</td>
                                    <td><img style="width: 100px;" src="${market.img1 }" alt=""></td>
                                    <td>${market.sellTitle }</td>
                                    <td>${market.paymentPrice }</td>
                                    <td>${market.sellerId }</td>
                                    <td>${market.deleveryMsg }</td>
                                    <td>${market.paymentDate }</td>
                                </tr>
                              </c:forEach>
                            </tbody>
                        </table>
            </div>
            <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>