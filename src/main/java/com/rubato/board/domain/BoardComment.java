package com.rubato.board.domain;

import java.sql.Timestamp;

public class BoardComment {
	
	private int commentNo;
	private int boardNo;
	private String commentContent;
	private String memberId;
	private Timestamp commentDate;
	private Timestamp commentUpdate;
	private int commentViewCount;
	private String memberNickname;
	
	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public BoardComment() {}

	public BoardComment(int commentNo, int boardNo, String commentContent, String memberId, Timestamp commentDate,
			Timestamp commentUpdate, int commentViewCount) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.commentContent = commentContent;
		this.memberId = memberId;
		this.commentDate = commentDate;
		this.commentUpdate = commentUpdate;
		this.commentViewCount = commentViewCount;
	}

	@Override
	public String toString() {
		return "BoardComment [댓글번호=" + commentNo + ", 게시물번호=" + boardNo + ", 댓글내용=" + commentContent
				+ ", 댓글작성자=" + memberId + ", 댓글작성일=" + commentDate + ", 댓글수정일=" + commentUpdate + ", 댓글개수=" + commentViewCount + "]";
	}

	public int getCommentViewCount() {
		return commentViewCount;
	}

	public void setCommentViewCount(int commentViewCount) {
		this.commentViewCount = commentViewCount;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Timestamp getCommentUpdate() {
		return commentUpdate;
	}

	public void setCommentUpdate(Timestamp commentUpdate) {
		this.commentUpdate = commentUpdate;
	}
	
	

}
