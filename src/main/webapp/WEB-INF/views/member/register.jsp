<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 회원가입</title>
		<!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<!-- register.jsp css & js -->
		<link rel="stylesheet" href="/resources/css/member/register.css">
		<script src="/resources/js/member/register.js" defer></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script> <!-- 다음 주소 API -->
		<!-- jQuery CDN -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		<!-- Google Font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
    	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
		
	</head>

	<body>
		<!-- common header jsp include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<main>
			<section id="register-msg">
				<p>회원정보 입력</p>
				<p>양식에 맞게 정확히 입력해주세요.</p>
				<div id="register-msg2">
					<p><span>*</span>로 표기된 항목은 필수입력 항목입니다.</p>
				</div>
			</section>
			<section id="form-area">
				<form action="/member/register" method="POST">
					<table>
						<tr>
							<th>아이디 <span>*</span></th>
							<td>
								<input type="text" id="memberId" name="memberId" class="input-box" maxlength="15"
									required>
								<input type="button" id="idCheck-btn" value="중복확인">
								<br>
								<span id="idCheck-msg"></span>
							</td>
						</tr>
						<tr>
							<th>패스워드 <span>*</span></th>
							<td>
								<input type="password" id="memberPwd" name="memberPwd" class="input-box"
									placeholder="패스워드를 입력하세요" maxlength="16">
								<p id="required-pwd">
									※ 6~15자로 영문 대소문자, 최소 1개의 숫자 혹은 특수 문자를 포함해야 합니다.
								</p>
								<!-- 민우추가 -->
								<span id="pwdCheck-msg"></span>

							</td>
						</tr>
						<tr>
							<th>패스워드 확인 <span>*</span></th>
							<td>
								<input type="password" id="memberPwd2" name="memberPwd2" class="input-box"
									placeholder="패스워드를 다시 입력하세요" maxlength="16">
								<!-- 민우추가 -->
								<span id="pwdCheck-msg2"></span>
							</td>
						</tr>
						<tr>
							<th>이름 <span>*</span></th>
							<td>
								<input type="text" name="memberName" class="input-box" placeholder="이름을 입력하세요">
							</td>
						</tr>
						<tr>
							<th>닉네임 <span>*</span></th>
							<td>
								<input type="text" id="memberNickname" name="memberNickname" class="input-box"
									placeholder="닉네임을 입력하세요">
								<input type="button" id="nickCheck-btn" value="중복확인">
								<br>
								<span id="nickCheck-msg"></span>
							</td>
						</tr>
						<tr>
							<th>이메일 <span>*</span></th>
							<td>
								<input type="text" name="memberEmail1" class="email-box">
								<span id="gol">@</span>
								<input type="text" name="memberEmail2" class="email-box">
								<select name="domain" id="domain-box">
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="gmail.com">gmail.com</option>
								</select>
								<input type="button" id="auth-send" value="이메일 인증">
								<input type="hidden" id="auth-code" placeholder="인증번호 입력">
								<input type="hidden" id="auth-btn" value="확인">
								<span id="auth-msg"></span>
							</td>
						</tr>
						<tr>
							<th>연락처 <span>*</span></th>
							<td><input type="text" id="memberPhone" name="memberPhone" class="input-box"
									placeholder="하이픈(-)을 제외하고 입력하세요" maxlength="11"></td>
						</tr>
						<tr>
							<th>주소 <span>*</span></th>
							<td>
								<input type="text" name="memberAddr1" class="input-box" readonly>
								<input type="button" value="주소찾기" onclick="searchAddr()">
								<br><br>
								<input type="text" name="memberAddr2" class="input-box" placeholder="상세주소를 입력하세요">
							</td>
						</tr>
					</table>
					<div id="button-area">
						<input type="submit" value="가입하기" onclick="return validation(event)">
					</div>
				</form>
			</section>
		</main>
		<!-- common footer jsp include -->
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	</body>
	

	</html>