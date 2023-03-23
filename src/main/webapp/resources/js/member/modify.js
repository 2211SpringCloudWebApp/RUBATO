
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
	const memberPwd = document.getElementById("memberPwd").value;
	const memberPwd2 = document.getElementById("memberPwd2").value;
	const memberNickname = document.getElementById("memberNickname").value;
	const memberEmail1 = document.getElementsByName("memberEmail1")[0].value;
	const memberPwdRegex = /^(?=.*[a-zA-Z])(?=.*[0-9~!@#$%^&*()_+])[A-Za-z\d~!@#$%^&*()_+]{6,15}$/;
	const memberNicknameRegex = /^[가-힣]{2,6}$/;
	const memberEmail1Regex = /^[a-zA-Z0-9]+$/;
	
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
	if (!memberNicknameRegex.test(memberNickname)) {
	    alert("닉네임은 한글만 가능하며 최소 2글자에서 최대 6글자까지 입력 가능합니다.");
	    return false;
	  }
	  if (!memberEmail1Regex.test(memberEmail1)) {
	    alert("이메일은 영어 또는 숫자만 가능합니다.");
	    return false;
	  }
	
}