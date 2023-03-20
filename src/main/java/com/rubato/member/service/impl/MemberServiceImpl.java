package com.rubato.member.service.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.member.domain.Member;
import com.rubato.member.service.MemberService;
import com.rubato.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private MemberStore mStore;

	@Override
	public Member selectIdPw(Member member) {
		Member mOne = mStore.selectIdPw(session, member);
		return mOne;
	}

	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public Member selectMemberById(String memberId) {
		Member member = mStore.selectMemberById(session, memberId);
		return member;
	}

	@Override
	public Member selectMemberByNickname(String memberNickname) {
		Member member = mStore.selectMemberByNickname(session, memberNickname);
		return member;
	}

	@Override
	public int updateMember(Member member) {
		int result = mStore.updateMember(session, member);
		return result;
	}

	
	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public Member findId(Member mParam) {
		Member member = mStore.findId(session, mParam);
		return member;
	}

	@Override
	public Member findPwd(Member mParam) {
		Member member = mStore.findPwd(session, mParam);
		return member;
	}

	@Override
	public int boardWriterCount(String memberId) {
		int result = mStore.boardWriterCount(session, memberId);
		return result;
	}

	@Override
	public int boardCommentCount(String memberId) {
		int result = mStore.boardCommentCount(session, memberId);
		return result;
	}

	@Override
	public int lessonWriteCount(String memberId) {
		int result = mStore.lessonWriteCount(session, memberId);
		return result;
	}

	@Override
	public int lessonApplyCount(String memberId) {
		int result = mStore.lessonApplyCount(session, memberId);
		return result;
	}

	@Override
	public int sellWriteCount(String memberId) {
		int result = mStore.sellWriteCount(session, memberId);
		return result;
	}

	@Override
	public int buyApplyCount(String memberId) {
		int result = mStore.buyApplyCount(session, memberId);
		return result;
	}

	

}
