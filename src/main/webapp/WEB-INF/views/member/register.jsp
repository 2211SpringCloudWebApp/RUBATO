<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>RUBATO - 회원가입</title>
		<!-- common header css & js -->
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<!-- register.jsp css & js -->
		<link rel="stylesheet" href="/resources/css/member/register.css">
		<script src="/resources/js/member/register.js" defer></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script> <!-- 다음 주소 API -->
		<!-- jQuery CDN -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
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
								<input type="text" name="memberId" class="input-box" maxlength="15" required>
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
									※ 영문 대소문자, 숫자, 특수문자 중 2가지 이상 조합하여 설정해주세요. (8~16자)<br>
									※ 아이디와 4자리 이상 동일하거나, 4자리 이상 반복되는 문자와 숫자는 사용이 불가합니다.<br>
									※ 사용 가능 특수문자: !”#$%’()*+,-./:;<=>?@[]^_`{|}~
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
								<input type="text" name="memberNickname" class="input-box" placeholder="닉네임을 입력하세요">
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
							<td><input type="text" name="memberPhone" class="input-box" placeholder="하이픈(-)을 제외하고 입력하세요"
									maxlength="11"></td>
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
						<input type="submit" value="가입하기" onclick="return validation()">
					</div>
				</form>
			</section>
		</main>
	</body>

	</html>