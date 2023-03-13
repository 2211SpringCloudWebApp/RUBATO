<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id="header-container">
		<a href="/"><div id="logo-img"></div></a>
		<ul id="navigator">
			<li class="item"><a href="/lesson/list">레슨매칭</a></li>
			<li class="item"><a href="/market/list">마켓</a></li>
			<li class="item"><a href="/board/list">커뮤니티</a></li>
		</ul>
		<c:if test="${sessionScope.loginUser.memberId eq null }">
			<div id="login-wrapper">
				<button id="login-btn" onclick="location.href='/member/login'">로그인</button>
				<button id="join-btn" onclick="location.href='/member/register'">회원가입</button>
			</div>
		</c:if>
		<div id="login-wrapper">
			<c:if test="${sessionScope.loginUser.memberId ne null }">
				<div id="login-success">
					<input type="hidden" id="member-id" value="${sessionScope.loginUser.memberId }">
				</div>
				<div id="login-success2">
					<button id="login-btn" onclick="location.href='/member/login/member/mypage?member-id=${sessionScope.loginUser.memberId }'">마이페이지</button>
					<button id="join-btn" onclick="location.href='/member/logout'">로그아웃</button>
				</div>
			</c:if>
		</div>
	</div>
