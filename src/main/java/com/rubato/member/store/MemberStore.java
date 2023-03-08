package com.rubato.member.store;

import org.apache.ibatis.session.SqlSession;

import com.rubato.member.domain.Member;

public interface MemberStore {
	
	/**
	 * 로그인 Store
	 * @param member
	 * @return member
	 */
	public Member selectIdPw(SqlSession session, Member member);

	/**
	 * 회원가입 Store
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member);

	/**
	 * 아이디로 회원 조회 Store
	 * @param session
	 * @param memberId
	 * @return Member
	 */
	public Member selectMemberById(SqlSession session, String memberId);

	/**
	 * 닉네임으로 회원 조회 Store
	 * @param session
	 * @param memberNickname
	 * @return Member
	 */
	public Member selectMemberByNickname(SqlSession session, String memberNickname);
}
