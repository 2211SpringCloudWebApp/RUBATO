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

	/**
	 * 회원 정보 수정 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int updateMember(SqlSession session, Member member);
	
	/**
	 * 회원 탈퇴 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(SqlSession session, String memberId);
	
	/**
	 * 회원 아이디 찾기 Store
	 * @param session
	 * @param mParam
	 * @return Member
	 */
	public Member findId(SqlSession session, Member mParam);
	
	/**
	 * 회원 비밀번호 찾기 Store
	 * @param session
	 * @param mParam
	 * @return Member
	 */
	public Member findPwd(SqlSession session, Member mParam);
	
	/** 
	 * 마이페이지 작성한 글 내역 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int boardWriterCount(SqlSession session, String memberId);
	
	/**
	 * 마이페이지 댓글 작성 내역
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int boardCommentCount(SqlSession session, String memberId);
	
	/**
	 * 마이페이지 레슨 등록 내역
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int lessonWriteCount(SqlSession session, String memberId);
	
	/**
	 * 마이페이지 레슨 신청 내역
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int lessonApplyCount(SqlSession session, String memberId);
	
	/**
	 * 마이페이지 판매 등록 내역
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int sellWriteCount(SqlSession session, String memberId);
	
	/**
	 * 마이페이지 구매 신청 내역
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int buyApplyCount(SqlSession session, String memberId);
	
	
}
