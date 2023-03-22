package com.rubato.board.domain;

import java.sql.Timestamp;

public class BoardComment {
	
	private int commentNo;
	private int boardNo;
	private String boardCategory;
	private String commentContent;
	private String memberId;
	private int viewCount;
	private Timestamp commentDate;
	private Timestamp commentUpdate;
	
	public BoardComment() {}

	public BoardComment(int commentNo, int boardNo, String boardCategory, String commentContent, String memberId,
			int viewCount, Timestamp commentDate, Timestamp commentUpdate) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.boardCategory = boardCategory;
		this.commentContent = commentContent;
		this.memberId = memberId;
		this.viewCount = viewCount;
		this.commentDate = commentDate;
		this.commentUpdate = commentUpdate;
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

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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

	@Override
	public String toString() {
		return "BoardComment [commentNo=" + commentNo + ", boardNo=" + boardNo + ", boardCategory=" + boardCategory
				+ ", commentContent=" + commentContent + ", memberId=" + memberId + ", viewCount=" + viewCount
				+ ", commentDate=" + commentDate + ", commentUpdate=" + commentUpdate + "]";
	}
	
	

}
