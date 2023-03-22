package com.rubato.board.domain;

import java.sql.Timestamp;

public class Board {
	private int boardNo;
	private String boardCategory;
	private String boardTitle;
	private String memberId;
	private String boardContent;
	private Timestamp boardDate;
	private Timestamp boardUpdate;
	private int viewCount;
	private String memberNickname;
	
	public Board() {}

	public Board(int boardNo, String boardCategory, String boardTitle, String memberId, String boardContent,
			Timestamp boardDate, Timestamp boardUpdate, int viewCount) {
		super();
		this.boardNo = boardNo;
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.memberId = memberId;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardUpdate = boardUpdate;
		this.viewCount = viewCount;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	@Override
	public String toString() {
		return "Board [게시글번호=" + boardNo + ", 게시글분류=" + boardCategory + ", 게시글제목=" + boardTitle
				+ ", 게시글작성자=" + memberId + ", 게시글내용=" + boardContent + ", 게시글작성일=" + boardDate
				+ ", 게시글수정일=" + boardUpdate + ", 조회수=" + viewCount + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Timestamp getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}

	public Timestamp getBoardUpdate() {
		return boardUpdate;
	}

	public void setBoardUpdate(Timestamp boardUpdate) {
		this.boardUpdate = boardUpdate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
	

}
