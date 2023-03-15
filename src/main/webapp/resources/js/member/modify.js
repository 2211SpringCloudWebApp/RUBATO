
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
	
}