function deleteCheck(boardNo) {
	if(confirm("게시글을 삭제하시겠습니까?")) {
		location.href="/manager/boardDelete?boardNo="+boardNo;
	}
}