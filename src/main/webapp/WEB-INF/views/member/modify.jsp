<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="/resources/css/member/modify.css">
		<link rel="stylesheet" href="/resources/css/common/header.css">
		<link rel="stylesheet" href="/resources/css/common/footer.css">
		<script src="/resources/js/member/modify.js" defer></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
		<!-- 다음 주소 API -->
		<!-- jQuery CDN -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		<title>RUBATO - 회원정보수정</title>
	</head>

	<body>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<main>
			<section id="register-msg">
				<p>
					<strong>회원정보 수정</strong>
				</p>
				<p>양식에 맞게 정확히 입력해주세요.</p>
				<div id="register-msg2">
					<p>
						<span>*</span>로 표기된 항목은 필수입력 항목입니다.
					</p>
				</div>
			</section>
			<section id="form-area">
				<form action="/member/modify1" method="post">
					<table>
						<tr>
							<th>아이디 <!-- <span>*</span> --></th>
							<td><input type="text" name="memberId" class="input-box" maxlength="15"
									value="${member.memberId }" readonly> <br>
							</td>
						</tr>
						<tr>
							<th>패스워드 <span>*</span></th>
							<td><input type="password" name="memberPwd" class="input-box" placeholder="패스워드를 입력하세요"
									maxlength="16" value="${member.memberPwd }">
								<p id="required-pwd">
									※ 영문 대소문자, 숫자, 특수문자 중 2가지 이상 조합하여 설정해주세요. (8~16자)<br> ※
									아이디와 4자리 이상 동일하거나, 4자리 이상 반복되는 문자와 숫자는 사용이 불가합니다.<br> ※ 사용
									가능 특수문자: !”#$%’()*+,-./:;<=>?@[]^_`{|}~
								</p>
							</td>
						</tr>
						<tr>
							<th>패스워드 확인 <span>*</span></th>
							<td><input type="password" name="memberPwd2" class="input-box" placeholder="패스워드를 다시 입력하세요"
									maxlength="16" value="${member.memberPwd }"></td>
						</tr>
						<tr>
							<th>이름 <!-- <span>*</span> --></th>
							<td><input type="text" name="memberName" class="input-box" value="${member.memberName }"
									readonly></td>
						</tr>
						<tr>
							<th>닉네임 <span>*</span></th>
							<td><input type="text" name="memberNickname" class="input-box" placeholder="닉네임을 입력하세요"
									value="${member.memberNickname }"> <input type="button" id="nickCheck-btn"
									value="중복확인"> <br> <span id="nickCheck-msg"></span></td>
						</tr>
						<tr>
							<th>이메일 <!-- <span>*</span> --></th>
							<td><input type="text" name="memberEmail" class="input-box" value="${member.memberEmail }"
									readonly></td>
						</tr>
						<tr>
							<th>연락처 <!-- <span>*</span> --></th>
							<td><input type="text" name="memberPhone" class="input-box" placeholder="하이픈(-)을 제외하고 입력하세요"
									maxlength="11" value="${member.memberPhone }"></td>
						</tr>
						<tr>
							<th>주소 <span>*</span></th>
							<td><input type="text" name="memberAddr1" class="input-box" value="${member.memberAddr }"
									readonly> <input type="button" value="주소찾기" onclick="searchAddr()"> <br>
								<br> <input type="text" name="memberAddr2" class="input-box" placeholder="상세주소를 입력하세요">
							</td>
						</tr>
					</table>
			</section>
			<div id="select-area">
				<div id="button-area">
					<input type="submit" value="수정하기">
					<!-- onclick="return validation()" -->
				</div>
				</form>

				<div id="delete-area">
					<button type="button" onclick="removeMember();">탈퇴하기</button>
				</div>
			</div>
		</main>
		<script>
			function removeMember() {
				if (window.confirm("탈퇴하시겠습니까?")) {
					var memberId = "${member.memberId }";
					location.href = "/member/delete?memberId=" + memberId;
				}
			}
		</script>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</body>

	</html>