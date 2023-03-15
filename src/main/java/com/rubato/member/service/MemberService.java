package com.rubato.member.service;

import com.rubato.member.domain.Member;

public interface MemberService {

	/**
	 * 로그인 service
	 * @param member
	 * @return member
	 */
	public Member selectIdPw(Member member);

	/**
	 * 회원가입 Service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);

	/**
	 * 아이디로 회원 조회 Service
	 * @param memberId
	 * @return Member
	 */
	public Member selectMemberById(String memberId);

	/**
	 * 닉네임으로 회원 조회 Service
	 * @param memberNickname
	 * @return Member
	 */
	public Member selectMemberByNickname(String memberNickname);
	
	/**
	 * 회원 정보 수정 Service
	 * @param member
	 * @return Member
	 */
	public int updateMember(Member member);
	
	/** 회원 탈퇴 Service
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(String memberId);

	
	
	
}
