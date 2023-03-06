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
	
	
}
