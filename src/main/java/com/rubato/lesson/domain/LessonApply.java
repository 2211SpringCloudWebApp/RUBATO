package com.rubato.lesson.domain;

import java.sql.Timestamp;

public class LessonApply {
	
	private int lessonNo;
	private String memberId;
	private String applyPrice;
	private String applyPlan;
	private String applyContent;
	private Timestamp applyDate;
	
	public LessonApply() {}
	
	public LessonApply(int lessonNo, String memberId, String applyPrice, String applyPlan, String applyContent,
			Timestamp applyDate) {
		super();
		this.lessonNo = lessonNo;
		this.memberId = memberId;
		this.applyPrice = applyPrice;
		this.applyPlan = applyPlan;
		this.applyContent = applyContent;
		this.applyDate = applyDate;
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
	
}
