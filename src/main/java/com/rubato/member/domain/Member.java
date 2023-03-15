package com.rubato.member.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberNickname;
	private String memberEmail;
	private String memberPhone;
	private String memberAddr;
	private Date regDate;
	private Timestamp modDate;
	private String status;
	private int memberPoint;
	
	public Member() {}
	
	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
		
	public Member(String memberId, String memberPwd, String memberName, String memberNickname, String memberEmail,
			String memberPhone, String memberAddr) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
	}
	
	
	@Override
	public String toString() {
		return "Member [아이디=" + memberId + ", 비밀번호=" + memberPwd + ", 이름=" + memberName
				+ ", 닉네임=" + memberNickname + ", 이메일=" + memberEmail + ", 폰번호=" + memberPhone
				+ ", 주소=" + memberAddr + ", 가입일=" + regDate + ", 회원정보 수정일=" + modDate + ", 계정활성화여부=" + status
				+ ", 포인트 잔액=" + memberPoint
				+ "]";
	}

	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Timestamp getModDate() {
		return modDate;
	}
	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
}
