package com.rubato.lesson.domain;

import java.sql.Timestamp;
import java.util.List;

public class Apply {
	
	private int lessonNo;
	private String lessonTitle;
	private String memberId;
	private String memberEmail;
	private String applyPrice;
	private String applyPlan;
	private String applyContent;
	private Timestamp applyDate;
	
	public Apply() {}
	
	public Apply(int lessonNo, String memberId, String applyPrice, String applyPlan, String applyContent,
			Timestamp applyDate) {
		super();
		this.lessonNo = lessonNo;
		this.memberId = memberId;
		this.applyPrice = applyPrice;
		this.applyPlan = applyPlan;
		this.applyContent = applyContent;
		this.applyDate = applyDate;
	}
	
	public Apply(int lessonNo, String memberId) {
		super();
		this.lessonNo = lessonNo;
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "LessonApply [lessonNo=" + lessonNo + ", memberId=" + memberId + ", applyPrice=" + applyPrice
				+ ", applyPlan=" + applyPlan + ", applyContent=" + applyContent + ", applyDate=" + applyDate + "]";
	}
	
	public int getLessonNo() {
		return lessonNo;
	}
	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getApplyPrice() {
		return applyPrice;
	}
	public void setApplyPrice(String applyPrice) {
		this.applyPrice = applyPrice;
	}
	public String getApplyPlan() {
		return applyPlan;
	}
	public void setApplyPlan(String applyPlan) {
		this.applyPlan = applyPlan;
	}
	public String getApplyContent() {
		return applyContent;
	}
	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}
	public Timestamp getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}

	public String getLessonTitle() {
		return lessonTitle;
	}

	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
	
}
