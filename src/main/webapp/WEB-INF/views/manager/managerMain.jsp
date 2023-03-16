<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RUBATO - 관리자 페이지</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="/resources/css/manager/managerMain.css">
    <script src="/resources/js/manager/managerMain.js" defer></script>
</head>
<body>
    <div id="container">
        <div class="login-wrapper">
            <img src="/resources/images/manager/logo.png" alt="로고">
            <h3>관리자 페이지</h3>
            <form method="post" action="/manager/main" id="login-form">
                <input type="text" name="memberId" placeholder="관리자 아이디">
                <input type="password" name="memberPwd" placeholder="관리자 비밀번호">
            
                <input type="submit" id="loginBtn" value="Login">
            </form>
        </div>
		
<!-- 로그인 실패 시 모달창 실행 -->
		<c:if test="${loginUser == 0}">
			<button type="button" id="modal" class="btn btn-primary" data-toggle="modal" data-target="#myModal"></button>
			
			<div class="modal" id="myModal">
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">로그인 실패</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        관리자 정보와 일치하지 않습니다.
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			</div>
		</c:if>
    </div>
</body>
</html>