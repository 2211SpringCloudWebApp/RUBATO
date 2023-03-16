function deleteCheck(memberId) {
	if(confirm("탈퇴 처리 하시겠습니까?")) {
		location.href="/manager/memberOut?memberId="+memberId;
	}
}

function updateCheck(memberId) {
	if(confirm("활성화 상태를 변경하시겠습니까?")) {
		location.href="/manager/updateStatus?memberId="+memberId;
	}
}