package com.rubato.report.domain;

import java.sql.Timestamp;

public class Report {

	private int reportNo;
	private int postNo;
	private String postCategory;
	private String reportCategory;
	private String reportContent;
	private String memberId;
	private Timestamp reportDate;
	private String reportCondition;
	
	public Report() {}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public String getReportCategory() {
		return reportCategory;
	}

	public void setReportCategory(String reportCategory) {
		this.reportCategory = reportCategory;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Timestamp getReportDate() {
		return reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportCondition() {
		return reportCondition;
	}

	public void setReportCondition(String reportCondition) {
		this.reportCondition = reportCondition;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", postNo=" + postNo + ", postCategory=" + postCategory
				+ ", reportCategory=" + reportCategory + ", reportContent=" + reportContent + ", memberId=" + memberId
				+ ", reportDate=" + reportDate + ", reportCondition=" + reportCondition + "]";
	}
	
	
}
