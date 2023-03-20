package com.rubato.market.domain;

import java.sql.Timestamp;

public class MarketComment {
	private int commentNo;
	private int sellNo;
	private String memberId;
	private String commentContent;
	private Timestamp writeDate;
	private Timestamp modifyDate;
	private String memberNickname;

	@Override
	public String toString() {
		return "MarketComment [commentNo=" + commentNo + ", sellNo=" + sellNo + ", memberId=" + memberId
				+ ", commentContent=" + commentContent + ", writeDate=" + writeDate + ", modifyDate=" + modifyDate
				+ ", memberNickname=" + memberNickname + "]";
	}
	
	

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}



	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getSellNo() {
		return sellNo;
	}

	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
	
}
