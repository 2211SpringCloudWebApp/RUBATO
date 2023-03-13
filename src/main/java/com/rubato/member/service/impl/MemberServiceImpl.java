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

}
