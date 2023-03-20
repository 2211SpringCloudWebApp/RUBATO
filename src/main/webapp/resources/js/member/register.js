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
	// 유효성 검사 -민우 추가-
	var memberPwd = $("#memberPwd");
	var memberPwd2 = $("#memberPwd2");
	var pwdRegExp = /^(?!.*(.)\1{3,})(?!.*\d{4,})(?!.*[a-zA-Z]{4,})(?=.*[a-zA-Z])(?=.*\d)(?=.*[!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~])[a-zA-Z\d!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~]{8,16}$/;
	if(!pwdRegExp.test(memberPwd.val())) {
		$('#pwdCheck-msg').html("다시 입력해 주시길 바랍니다.");
		$('#pwdCheck-msg').css("color", "red");
		return false;
	}
	
	if(memberPwd.val() !== userPwd2.val()) {
		$('#pwdCheck-msg2').html("비밀번호가 다릅니다.");
		$('#pwdCheck-msg2').css("color", "red");
		return false;
	}
	
    
}