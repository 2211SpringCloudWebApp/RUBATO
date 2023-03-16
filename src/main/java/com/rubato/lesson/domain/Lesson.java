package com.rubato.lesson.domain;

import java.sql.Timestamp;

public class Lesson {

	private int lessonNo;
	private String memberId;
	private String memberNickname;
	private String lessonTitle;
	private String lessonPre;
	private String lessonContent;
	private String lessonArea;
	private String lessonPlan;
	private String lessonPrice;
	private Timestamp lessonDate;
	private Timestamp lessonUpdate;
	
	
	public Lesson() {}
	
	public Lesson(int lessonNo, String memberId, String lessonTitle, String lessonPre, String lessonContent,
			String lessonArea, String lessonPlan, String lessonPrice, Timestamp lessonDate, Timestamp lessonUpdate) {
		super();
		this.lessonNo = lessonNo;
		this.memberId = memberId;
		this.lessonTitle = lessonTitle;
		this.lessonPre = lessonPre;
		this.lessonContent = lessonContent;
		this.lessonArea = lessonArea;
		this.lessonPlan = lessonPlan;
		this.lessonPrice = lessonPrice;
		this.lessonDate = lessonDate;
		this.lessonUpdate = lessonUpdate;
	}

	@Override
	public String toString() {
		return "Lesson [lessonNo=" + lessonNo + ", memberId=" + memberId + ", lessonTitle=" + lessonTitle
				+ ", lessonPre=" + lessonPre + ", lessonContent=" + lessonContent + ", lessonArea=" + lessonArea
				+ ", lessonPlan=" + lessonPlan + ", lessonPrice=" + lessonPrice + ", lessonDate=" + lessonDate
				+ ", lessonUpdate=" + lessonUpdate + "]";
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

	public String getLessonTitle() {
		return lessonTitle;
	}

	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}

	public String getLessonPre() {
		return lessonPre;
	}

	public void setLessonPre(String lessonPre) {
		this.lessonPre = lessonPre;
	}

	public String getLessonContent() {
		return lessonContent;
	}

	public void setLessonContent(String lessonContent) {
		this.lessonContent = lessonContent;
	}

	public String getLessonArea() {
		return lessonArea;
	}

	public void setLessonArea(String lessonArea) {
		this.lessonArea = lessonArea;
	}

	public String getLessonPlan() {
		return lessonPlan;
	}

	public void setLessonPlan(String lessonPlan) {
		this.lessonPlan = lessonPlan;
	}

	public String getLessonPrice() {
		return lessonPrice;
	}

	public void setLessonPrice(String lessonPrice) {
		this.lessonPrice = lessonPrice;
	}

	public Timestamp getLessonDate() {
		return lessonDate;
	}

	public void setLessonDate(Timestamp lessonDate) {
		this.lessonDate = lessonDate;
	}

	public Timestamp getLessonUpdate() {
		return lessonUpdate;
	}

	public void setLessonUpdate(Timestamp lessonUpdate) {
		this.lessonUpdate = lessonUpdate;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	
}
