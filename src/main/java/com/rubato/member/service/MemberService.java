package com.rubato.member.service;

import java.util.List;

import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.PageInfo;
import com.rubato.member.domain.Member;

public interface MemberService {

	/**
	 * 로그인 service
	 * @param member
	 * @return member
	 */
	public Member selectIdPw(Member member);

	/** 회원 아이디 찾기 Service
	 * @param mParam
	 * @return Member
	 */
	public Member findId(Member mParam);
	
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

	/**
	 * 회원 비밀번호 찾기 Service
	 * @param mParam
	 * @return Member
	 */
	public Member findPwd(Member mParam);
	
	/**
	 * 마이페이지 작성한 글 내역
	 * @param memberId
	 * @return int
	 */
	public int boardWriterCount(String memberId);
	
	/**
	 * 마이페이지 내가 쓴 댓글 내역
	 * @param memberId
	 * @return int
	 */
	public int boardCommentCount(String memberId);
	
	/** 
	 * 마이페이지 레슨 등록 내역
	 * @param memberId
	 * @return int
	 */
	public int lessonWriteCount(String memberId);
	
	/**
	 * 마이페이지 레슨 신청 내역
	 * @param memberId
	 * @return
	 */
	public int lessonApplyCount(String memberId);
	
	/** 
	 * 마이페이지 판매 등록 내역
	 * @param memberId
	 * @return int
	 */
	public int sellWriteCount(String memberId);
	
	/**
	 * 마이페이지 구매 신청 내역
	 * @param memberId
	 * @return
	 */
	public int buyApplyCount(String memberId);
	
	
	
	
	
}
