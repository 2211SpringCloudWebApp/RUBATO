//이메일 select
document.querySelector("select").addEventListener("change", function(){
    var domain = document.querySelector("option:checked").value;
    if(domain==""){
        document.querySelector("[name=memberEmail2]").removeAttribute("readonly");
        document.querySelector("[name=memberEmail2]").value = domain;
        document.querySelector("[name=memberEmail2]").focus();
    }
    else{
        document.querySelector("[name=memberEmail2]").setAttribute("readonly", true);
        document.querySelector("[name=memberEmail2]").value = domain;

    }
})

// 주소API
var searchAddr = function(){
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            }
            document.querySelector("[name=memberAddr1]").value = data.address + extraAddr;
            document.querySelector("[name=memberAddr2]").focus();
        }
    }).open();
}



// 이메일 인증 ajax
$('#auth-send').click(function(){
	const email = $('[name=memberEmail1]').val() + '@' + $('[name=memberEmail2]').val();
	$('#auth-code').attr("type", "text"); //hidden 상태의 인증번호 입력창 활성화
	$('#auth-btn').attr("type", "button"); //hidden 상태의 인증번호 확인창 활성화
	$('#auth-code').focus(); //hidden 상태의 인증번호 확인창 활성화
	// ajax통신
	$.ajax({
		type : "get",
		url : "/member/register/mailAuth?email="+email,
		success : function(data){
			code = data;
			alert("인증번호가 발송되었습니다.\n이메일을 확인해주세요.");
			
		}
	}); // end ajax
}); // end send email

// 인증번호 비교
$('#auth-btn').click(function(){
	const inputCode = $('#auth-code').val();
	if(inputCode === code){
		$('#auth-msg').html("인증번호가 일치합니다.");
		$('#auth-msg').css('color', 'green');
		$('[name=memberEmail1]').attr("readonly", true);
		$('[name=memberEmail2]').attr("readonly", true);
		$('[name=memberEmail1]').css("backgroundColor", "rgb(237, 236, 236)");
		$('[name=memberEmail2]').css("backgroundColor", "rgb(237, 236, 236)");
	}
	else{
		$('#auth-msg').html("인증번호가 일치하지 않습니다.");
		$('#auth-msg').css('color', 'red');
	}
})



// 아이디 중복확인 ajax
$('#idCheck-btn').click(function(){
	const memberId = $('[name=memberId]').val();
	// ajax 통신
	$.ajax({
		type : "get",
		url : "/member/register/idCheck?memberId="+memberId,
		success : function(data){
			answer = data;
			if(answer==="true"){
				$('#idCheck-msg').html("사용 가능한 아이디입니다.");
				$('#idCheck-msg').css("color", "green");
			}
			else{
				$('#idCheck-msg').html("이미 사용중인 아이디입니다.");
				$('#idCheck-msg').css("color", "red");
			}
		}
	});
});

// 닉네임 중복확인 ajax
$('#nickCheck-btn').click(function(){
	const memberNickname = $('[name=memberNickname]').val();
	// ajax 통신
	$.ajax({
		type : "get",
		url : "/member/register/nickCheck?memberNickname="+memberNickname,
		success : function(data){
			nickanswer = data;
			if(nickanswer==="true"){
				$('#nickCheck-msg').html("사용 가능한 닉네임입니다.");
				$('#nickCheck-msg').css("color", "green");
			}
			else{
				$('#nickCheck-msg').html("이미 사용중인 닉네임입니다.");
				$('#nickCheck-msg').css("color", "red");
			}
		}
	});
});

// 유효성 체크
var validation = ()=>{
	//아이디 중복확인 버튼 눌렀는지 체크
	if($('#idCheck-msg').text()===""){
		alert("아이디 중복확인을 해주세요.");
		return false;
	}
	//아이디 중복 유효성 체크
	if(answer==="false"){
		$('[name=memberId]').focus();
		$('#idCheck-msg').html("이미 사용중인 아이디입니다.");
		$('#idCheck-msg').css("color", "red");
		return false;
	}
	
	//닉네임 중복확인 버튼 눌렀는지 체크
	if($('#nickCheck-msg').text()===""){
		alert("닉네임 중복확인을 해주세요.");
		return false;
	}
	//닉네임 중복 유효성 체크
	if(nickanswer==="false"){
		$('[name=memberNickname]').focus();
		$('#nickCheck-msg').html("이미 사용중인 닉네임입니다.");
		$('#nickCheck-msg').css("color", "red");
		return false;
	}
	
	//이메일 인증 버튼 눌렀는지 체크
	if($('#auth-msg').text()!=="인증번호가 일치합니다."){
		alert("이메일 인증을 해주세요.");
		return false;
	}
	const memberId = document.getElementById("memberId").value;
	  const memberPwd = document.getElementById("memberPwd").value;
	  const memberPwd2 = document.getElementById("memberPwd2").value;
	  const memberName = document.getElementsByName("memberName")[0].value;
	  const memberNickname = document.getElementById("memberNickname").value;
	  const memberEmail1 = document.getElementsByName("memberEmail1")[0].value;
	  const memberPhone = document.getElementById("memberPhone").value;
	  const memberIdRegex = /^[a-z]+[a-z0-9]{5,19}$/g;
	  const memberPwdRegex = /^(?=.*[a-zA-Z])(?=.*[0-9~!@#$%^&*()_+])[A-Za-z\d~!@#$%^&*()_+]{6,15}$/;
	  const memberNameRegex = /^[가-힣]{2,4}$/;
	  const memberNicknameRegex = /^[가-힣]{2,6}$/;
	  const memberEmail1Regex = /^[a-zA-Z0-9]+$/;
	  const memberPhoneRegex = /^[0-9]{1,11}$/;
	
	  if (!memberIdRegex.test(memberId)) {
	    alert("아이디는 영문 소문자를 포함하여 4~12자리로 입력해주세요.");
	    return false;
	  }
	
	  if (!memberPwdRegex.test(memberPwd)) {
	    alert(
	      "비밀번호는 6~15자로 영문 대소문자, 최소 1개의 숫자 혹은 특수 문자를 포함해야 합니다."
	    );
	    return false;
	  }
	
	  if (memberPwd !== memberPwd2) {
	    alert("비밀번호가 일치하지 않습니다.");
	    return false;
	  }
	
	  if (!memberNameRegex.test(memberName)) {
	    alert("이름은 한글만 가능하며 최소 2글자에서 최대 4글자까지 입력 가능합니다.");
	    return false;
	  }
	
	  if (!memberNicknameRegex.test(memberNickname)) {
	    alert("닉네임은 한글만 가능하며 최소 2글자에서 최대 6글자까지 입력 가능합니다.");
	    return false;
	  }
	
	  if (!memberEmail1Regex.test(memberEmail1)) {
	    alert("이메일은 영어 또는 숫자만 가능합니다.");
	    return false;
	  }
	
	  if (!memberPhoneRegex.test(memberPhone)) {
	    alert(
	      "연락처는 -가 입력되지 않고 숫자만 가능하며 최대 11글자까지 입력 가능합니다."
	    );
	    return false;
	  }
 }