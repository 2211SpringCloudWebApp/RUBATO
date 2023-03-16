function deleteCheck(memberId) {
	if(confirm("탈퇴 처리 하시겠습니까?")) {
		location.href="/manager/memberOut?memberId="+memberId;
	}
}