package com.rubato.member.domain;

public class CategoryCount {
	private int boardWriteCount;
	private int boardCommentCount;
	private int lessonWriteCount;
	private int lessonApplyCount;
	private int sellWriteCount;
	private int buyApplyCount;
	
	public CategoryCount(int boardWriteCount, int totalCommentCount, int lessonWriteCount, int lessonApplyCount,
			int sellWriteCount, int buyApplyCount, int boardCommentCount) {
		super();
		this.boardWriteCount = boardWriteCount;
		this.boardCommentCount = boardCommentCount;
		this.lessonWriteCount = lessonWriteCount;
		this.lessonApplyCount = lessonApplyCount;
		this.sellWriteCount = sellWriteCount;
		this.buyApplyCount = buyApplyCount;
	}

	public CategoryCount() {
		
	}

	public int getBoardWriteCount() {
		return boardWriteCount;
	}

	public void setBoardWriteCount(int boardWriteCount) {
		this.boardWriteCount = boardWriteCount;
	}

	public int getboardCommentCount() {
		return boardCommentCount;
	}

	public void setboardCommentCount(int totalCommentCount) {
		this.boardCommentCount = totalCommentCount;
	}

	public int getLessonWriteCount() {
		return lessonWriteCount;
	}

	public void setLessonWriteCount(int lessonWriteCount) {
		this.lessonWriteCount = lessonWriteCount;
	}

	public int getLessonApplyCount() {
		return lessonApplyCount;
	}

	public void setLessonApplyCount(int lessonApplyCount) {
		this.lessonApplyCount = lessonApplyCount;
	}

	public int getSellWriteCount() {
		return sellWriteCount;
	}

	public void setSellWriteCount(int sellWriteCount) {
		this.sellWriteCount = sellWriteCount;
	}

	public int getBuyApplyCount() {
		return buyApplyCount;
	}

	public void setBuyApplyCount(int buyApplyCount) {
		this.buyApplyCount = buyApplyCount;
	}

	@Override
	public String toString() {
		return "CategoryCount [boardWriteCount=" + boardWriteCount + ", boardCommentCount=" + boardCommentCount
				+ ", lessonWriteCount=" + lessonWriteCount + ", lessonApplyCount=" + lessonApplyCount
				+ ", sellWriteCount=" + sellWriteCount + ", buyApplyCount=" + buyApplyCount + "]";
	}
	
	
	
}
